package programaMutante;

import ui.ControladorUI;
import ui.VentanaJuego;

// Programa principal: corre el juego completo de principio a fin.
public class Main {
    public static void main(String[] args) {
        VentanaJuego ventana = new VentanaJuego();
        new ControladorUI(ventana);
        ventana.setVisible(true);
    }
}
