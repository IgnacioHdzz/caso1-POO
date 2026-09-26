package ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constantes.Constantes;

// VISTA: la ventana principal. Arriba, los controles (tamaño, botón y mensaje);
// en el centro, el panel donde se dibuja la batalla.
public class VentanaJuego extends JFrame {

    private PanelCampo panelCampo;
    private JTextField campoTamanio;
    private JButton botonIniciar;
    private JLabel etiquetaMensaje;

    public VentanaJuego() {
        super(Constantes.TITULO_VENTANA);

        campoTamanio = new JTextField(Constantes.COLUMNAS_CAMPO_TAMANIO);
        botonIniciar = new JButton(Constantes.TEXTO_BOTON_INICIAR);
        etiquetaMensaje = new JLabel(Constantes.MENSAJE_INICIAL);
        panelCampo = new PanelCampo();

        JPanel panelControles = new JPanel();
        panelControles.add(new JLabel(Constantes.TEXTO_TAMANIO));
        panelControles.add(campoTamanio);
        panelControles.add(botonIniciar);
        panelControles.add(etiquetaMensaje);

        setLayout(new BorderLayout());
        add(panelControles, BorderLayout.NORTH);
        add(panelCampo, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public PanelCampo getPanelCampo() {
        return this.panelCampo;
    }

    public JButton getBotonIniciar() {
        return this.botonIniciar;
    }

    public String getTextoTamanio() {
        return this.campoTamanio.getText().trim();
    }

    public void mostrarMensaje(String pMensaje) {
        this.etiquetaMensaje.setText(pMensaje);
    }
}
