package control;

import juego.Equipo;
import juego.Partida;
import personas.Persona;

// Programa de prueba de la capa Control (sin ventana): corre una batalla completa y la muestra en consola.
public class PruebaControl {

    public static void main(String[] args) throws InterruptedException {
        int tamanioEquipo = 5;
        Partida partida = new Partida(tamanioEquipo);

        System.out.println("=== Mutantes al inicio ===");
        imprimirEquipo(partida.getEquipo1());
        imprimirEquipo(partida.getEquipo2());

        MotorBatalla motor = new MotorBatalla(partida);
        motor.agregarObservador(new ObservadorConsola(partida));

        System.out.println("\n=== Batalla ===");
        long inicio = System.currentTimeMillis();
        motor.start();
        motor.join();
        long segundos = (System.currentTimeMillis() - inicio) / 1000;

        System.out.println("\n=== Resultado (" + segundos + " segundos) ===");
        if (partida.esEmpate()) {
            System.out.println("¡Empate!");
        } else {
            System.out.println("Ganador: " + partida.getGanador().getNombre());
        }
        imprimirEquipo(partida.getEquipo1());
        imprimirEquipo(partida.getEquipo2());
    }

    private static void imprimirEquipo(Equipo pEquipo) {
        System.out.println("Equipo " + pEquipo.getNombre() + ":");
        Persona[] mutantes = pEquipo.getMutantes();
        for (int i = 0; i < pEquipo.getCantidad(); i++) {
            Persona p = mutantes[i];
            System.out.println("  " + p.getNombre() + " (" + p.getClass().getSimpleName() + ")"
                    + "  energía: " + Math.round(p.getEnergia())
                    + "  defensa: " + p.getDefensa()
                    + "  daño: " + p.getPower().getDanio());
        }
    }
}