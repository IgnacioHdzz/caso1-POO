package control;

import constantes.Constantes;
import juego.Campo;
import juego.Partida;
import personas.Persona;

// Un hilo por mutante: lo mueve por el campo y busca enemigos dentro del radio.
public class HiloMutante extends Thread {

    private Persona mutante;
    private Partida partida;
    private double direccionX;
    private double direccionY;
    private int pasosRestantes;
    private volatile boolean activo;    // Volatile obliga a leer siempre el valor real. 
                                       // Si un hilo cambia una varible, es necesario que esta sea volatile para que otro hilo se entere del cambio.

    public HiloMutante(Persona pMutante, Partida pPartida) {
        this.mutante = pMutante;
        this.partida = pPartida;
        this.activo = true;
        cambiarDireccion();
    }

    @Override
    public void run() {
        while (activo && mutante.estaVivo() && !partida.estaTerminada()) {
            mover();
            buscarEnemigos();
            try {
                Thread.sleep(Constantes.PAUSA_HILO_MS);
            } catch (InterruptedException e) {
                activo = false;
            }
        }
    }

    private void mover() {
        if (pasosRestantes <= 0) {
            cambiarDireccion();
        }

        Campo campo = partida.getCampo();
        double nuevaX = mutante.getX() + direccionX * mutante.getVelocidad();    // Para lograr moverse aritméticamente se calcula la  posición nueva como: 
        double nuevaY = mutante.getY() + direccionY * mutante.getVelocidad();    // posición actual + dirección (valor entre -1 y 1) × velocidad.

        if (nuevaX < 0 || nuevaX > campo.getAncho()) { // Si se sale por la izquierda o por la derecha
            direccionX = -direccionX;                  // Se invierte la dirección para el siguiente paso.
            nuevaX = mutante.getX();                   // No se mueve en X, se queda donde estaba, por eso se le asigna la posicion actual de X a la nueva.
        }
        if (nuevaY < 0 || nuevaY > campo.getAlto()) {
            direccionY = -direccionY;
            nuevaY = mutante.getY();
        }

        mutante.setPosicion(nuevaX, nuevaY);
        pasosRestantes--;
    }

    private void cambiarDireccion() {
        direccionX = Math.random() * 2 - 1;      //Cada dirección va de -1 a 1. Jugando con esos valores, los mutantes se pueden mover en distintas direcciones.
        direccionY = Math.random() * 2 - 1;     // (1, 0) sería a la derecha, (-1, -1) arriba a la izquierda, y así sucesivamente.
        pasosRestantes = Constantes.PASOS_POR_DIRECCION;            //Contador de pasos.
    }

    private void buscarEnemigos() {
        Persona[] enemigos = partida.getEnemigosDe(mutante);
        for (Persona enemigo : enemigos) {
            if (enemigo == null || !enemigo.estaVivo()) {
                continue;
            }
            boolean estaCerca = mutante.distanciaA(enemigo) <= Constantes.RADIO_COMBATE;
            boolean soyMenor = mutante.getId() < enemigo.getId();
            if (estaCerca && soyMenor) {
                Combate.resolver(mutante, enemigo);
            }
        }
    }

    public void detener() {
        this.activo = false;
    }
}