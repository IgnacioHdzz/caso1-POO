package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constantes.Constantes;
import control.MotorBatalla;
import juego.Partida;

// CONTROLADOR (MVC): recibe el clic del botón, valida el tamaño,
// crea la Partida (modelo) y el MotorBatalla, y conecta la vista como observador.
public class ControladorUI implements ActionListener {

    private VentanaJuego vista;
    private Partida partida;
    private MotorBatalla motor;

    public ControladorUI(VentanaJuego pVista) {
        this.vista = pVista;
        this.vista.getBotonIniciar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        iniciarPartida();
    }

    private void iniciarPartida() {
        int tamanio;
        try {
            tamanio = Integer.parseInt(vista.getTextoTamanio());
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje(Constantes.MENSAJE_NO_ES_NUMERO);
            return;
        }

        if (!Partida.esTamanioValido(tamanio)) {
            vista.mostrarMensaje(Constantes.MENSAJE_FUERA_DE_RANGO);
            return;
        }

        if (motor != null) {
            motor.detener();
        }

        partida = new Partida(tamanio);
        motor = new MotorBatalla(partida);
        motor.agregarObservador(vista.getPanelCampo());
        vista.getPanelCampo().setPartida(partida);
        vista.mostrarMensaje(Constantes.MENSAJE_EN_CURSO);
        motor.start();
    }
}
