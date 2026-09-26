package control;

import java.util.ArrayList;             // Para manejar los observadores.

import constantes.Constantes;
import juego.Equipo;
import juego.Partida;
import personas.Persona;

// Arranca los hilos de todos los mutantes y avisa a los observadores (la UI) cada REFRESCO_UI_MS mientras la partida siga.
public class MotorBatalla extends Thread {

    private Partida partida;
    private HiloMutante[] hilos;
    private ArrayList<IObservador> observadores;        // Lista que crece sola.
    private volatile boolean activo;

    public MotorBatalla(Partida pPartida) {
        this.partida = pPartida;
        this.observadores = new ArrayList<IObservador>();
        this.activo = true;
        int total = pPartida.getEquipo1().getCantidad() + pPartida.getEquipo2().getCantidad();
        this.hilos = new HiloMutante[total];
    }

    public void agregarObservador(IObservador pObservador) {
        this.observadores.add(pObservador);
    }

    private void notificarObservadores() {
        for (IObservador observador : this.observadores) {
            observador.actualizar();
        }
    }

    private void iniciarHilos() {
        Equipo[] equipos = { partida.getEquipo1(), partida.getEquipo2() };
        int indice = 0;
        for (Equipo equipo : equipos) {
            Persona[] mutantes = equipo.getMutantes();
            for (int i = 0; i < equipo.getCantidad(); i++) {
                hilos[indice] = new HiloMutante(mutantes[i], partida);
                hilos[indice].start();
                indice++;
            }
        }
    }

    @Override
    public void run() {
        iniciarHilos();
        while (activo && !partida.estaTerminada()) {
            notificarObservadores();
            try {
                Thread.sleep(Constantes.REFRESCO_UI_MS);
            } catch (InterruptedException e) {
                activo = false;
            }
        }
        notificarObservadores();
    }

    public void detener() {
        this.activo = false;
        for (HiloMutante hilo : hilos) {
            if (hilo != null) {
                hilo.detener();
            }
        }
    }
}