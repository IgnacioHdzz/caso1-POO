package ui;

import juego.Partida;

// Programa de prueba de la capa UI: abre la ventana con una partida QUIETA
// (sin motor ni hilos) para revisar que el dibujo se vea bien.
public class PruebaUI {
    public static void main(String[] args) {
        Partida partida = new Partida(5);

        VentanaJuego ventana = new VentanaJuego();
        ventana.getPanelCampo().setPartida(partida);
        ventana.mostrarMensaje("Prueba de dibujo: los mutantes no se mueven");
        ventana.setVisible(true);
    }
}
