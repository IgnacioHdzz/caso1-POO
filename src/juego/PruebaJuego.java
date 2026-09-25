package juego;
import personas.Persona;

// Programa de prueba de la capa Juego (sin hilos y sin ventana).
public class PruebaJuego {
    public static void main(String[] args) {
        // Bloque prueba 1: esTamanioValido con 2, 3, 11 y 12
        System.out.println("     Prueba esTamanioValido");
        System.out.println("2 -> " + Partida.esTamanioValido(2) + " (esperado: false)");
        System.out.println("3 -> " + Partida.esTamanioValido(3) + " (esperado: true)");
        System.out.println("11 -> " + Partida.esTamanioValido(11) + " (esperado: true)");
        System.out.println("12 -> " + Partida.esTamanioValido(12) + " (esperado: false)");
        System.out.println();

        // Bloque prueba 2: crear una Partida de 5 e imprimir cada mutante
        System.out.println("     Creando partida de 5");
        Partida partida = new Partida(5);
        System.out.println("--- " + partida.getEquipo1().getNombre() + " ---");
        for (Persona p : partida.getEquipo1().getMutantes()) {
            imprimirMutante(p);
        }
        System.out.println("--- " + partida.getEquipo2().getNombre() + " ---");
        for (Persona p : partida.getEquipo2().getMutantes()) {
            imprimirMutante(p);
        }
        System.out.println();

        // Bloque prueba 3: marcador (vivos y muertos por equipo)
        System.out.println("     Marcador inicial");
        imprimirMarcador(partida);
        System.out.println();

        // Bloque prueba 4: simular a mano la muerte de todo el equipo 2
        System.out.println("     Simulando muerte de todo el equipo 2");
        for (Persona p : partida.getEquipo2().getMutantes()) {
            p.recibirDanio(100);
        }
        imprimirMarcador(partida);
        System.out.println("estaTerminada(): " + partida.estaTerminada() + " (esperado: true)");
        System.out.println("esEmpate(): " + partida.esEmpate() + " (esperado: false)");
        if (partida.getGanador() != null) {
            System.out.println("Ganador: " + partida.getGanador().getNombre()
                    + " (esperado: " + partida.getEquipo1().getNombre() + ")");
        } else {
            System.out.println("Ganador: null (no debería pasar aquí)");
        }
    }

    private static void imprimirMutante(Persona pMutante) {
        System.out.println(pMutante.getNombre()
                + " (" + pMutante.getClass().getSimpleName() + ")"
                + " -> energia: " + pMutante.getEnergia()
                + ", defensa: " + pMutante.getDefensa()
                + ", danio del poder: " + pMutante.getPower().getDanio()
                + ", posicion: (" + pMutante.getX() + ", " + pMutante.getY() + ")");
    }

    private static void imprimirMarcador(Partida pPartida) {
        System.out.println(pPartida.getEquipo1().getNombre() + " -> vivos: "
                + pPartida.getEquipo1().contarVivos() + ", muertos: " + pPartida.getEquipo1().contarMuertos());
        System.out.println(pPartida.getEquipo2().getNombre() + " -> vivos: "
                + pPartida.getEquipo2().contarVivos() + ", muertos: " + pPartida.getEquipo2().contarMuertos());
    }
}