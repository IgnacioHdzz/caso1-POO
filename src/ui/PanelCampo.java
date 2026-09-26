package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import constantes.Constantes;
import control.IObservador;
import juego.Equipo;
import juego.Partida;
import personas.Persona;

// VISTA: dibuja el marcador, los mutantes vivos con su energía y el ganador.
// Solo CONSULTA la partida; nunca decide nada del juego.
public class PanelCampo extends JPanel implements IObservador {

    private Partida partida;

    public PanelCampo() {
        setPreferredSize(new Dimension(Constantes.ANCHO_CAMPO,
                Constantes.ALTO_CAMPO + Constantes.ALTO_MARCADOR_PX));
        setBackground(Constantes.COLOR_FONDO_CAMPO);
    }

    public void setPartida(Partida pPartida) {
        this.partida = pPartida;
        repaint();
    }

    @Override
    public void actualizar() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        dibujarFondoMarcador(g2);
        if (partida == null) {
            dibujarTextoMarcador(g2, Constantes.MENSAJE_INICIAL, Constantes.MARGEN_TEXTO_PX);
            return;
        }

        dibujarEquipo(g2, partida.getEquipo1());
        dibujarEquipo(g2, partida.getEquipo2());
        dibujarMarcador(g2);

        if (partida.estaTerminada()) {
            dibujarGanador(g2);
        }
    }

    private void dibujarFondoMarcador(Graphics2D g2) {
        g2.setColor(Constantes.COLOR_FONDO_MARCADOR);
        g2.fillRect(0, 0, getWidth(), Constantes.ALTO_MARCADOR_PX);
    }

    private void dibujarTextoMarcador(Graphics2D g2, String pTexto, int pX) {
        g2.setColor(Constantes.COLOR_TEXTO_MARCADOR);
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, Constantes.TAMANIO_FUENTE_MARCADOR));
        int y = Constantes.ALTO_MARCADOR_PX / 2 + g2.getFontMetrics().getAscent() / 2;
        g2.drawString(pTexto, pX, y);
    }

    private String textoEquipo(Equipo pEquipo) {
        return pEquipo.getSimbolo() + " " + pEquipo.getNombre() + ": "
                + pEquipo.contarVivos() + " vivos, " + pEquipo.contarMuertos() + " muertos";
    }

    private void dibujarMarcador(Graphics2D g2) {
        dibujarTextoMarcador(g2, textoEquipo(partida.getEquipo1()), Constantes.MARGEN_TEXTO_PX);

        String texto2 = textoEquipo(partida.getEquipo2());
        int ancho2 = g2.getFontMetrics().stringWidth(texto2);
        dibujarTextoMarcador(g2, texto2, getWidth() - ancho2 - Constantes.MARGEN_TEXTO_PX);
    }

    private void dibujarEquipo(Graphics2D g2, Equipo pEquipo) {
        Persona[] mutantes = pEquipo.getMutantes();
        for (int i = 0; i < pEquipo.getCantidad(); i++) {
            if (mutantes[i].estaVivo()) {
                dibujarMutante(g2, mutantes[i], pEquipo);
            }
        }
    }

    private void dibujarMutante(Graphics2D g2, Persona pMutante, Equipo pEquipo) {
        int tamanio = Constantes.TAMANIO_MUTANTE_PX;
        int x = (int) pMutante.getX() - tamanio / 2;
        int y = (int) pMutante.getY() + Constantes.ALTO_MARCADOR_PX - tamanio / 2;

        // Cuerpo: círculo del color del equipo
        g2.setColor(pEquipo.getColor());
        g2.fillOval(x, y, tamanio, tamanio);

        // Símbolo del equipo en el centro
        g2.setColor(Constantes.COLOR_SIMBOLO);
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, tamanio - 4));
        FontMetrics medidas = g2.getFontMetrics();
        int xTexto = x + (tamanio - medidas.stringWidth(pEquipo.getSimbolo())) / 2;
        int yTexto = y + (tamanio + medidas.getAscent()) / 2 - 2;
        g2.drawString(pEquipo.getSimbolo(), xTexto, yTexto);

        // Barra de energía encima del mutante
        int yBarra = y - Constantes.ALTO_BARRA_ENERGIA_PX - 2;
        int anchoLleno = (int) (tamanio * pMutante.getEnergia() / Constantes.ENERGIA_INICIAL);
        g2.setColor(Constantes.COLOR_ENERGIA_FONDO);
        g2.fillRect(x, yBarra, tamanio, Constantes.ALTO_BARRA_ENERGIA_PX);
        g2.setColor(Constantes.COLOR_ENERGIA);
        g2.fillRect(x, yBarra, anchoLleno, Constantes.ALTO_BARRA_ENERGIA_PX);
    }

    private void dibujarGanador(Graphics2D g2) {
        String texto;
        if (partida.esEmpate()) {
            texto = Constantes.MENSAJE_EMPATE;
            g2.setColor(Constantes.COLOR_TEXTO_GANADOR);
        } else {
            Equipo ganador = partida.getGanador();
            texto = Constantes.PREFIJO_GANADOR + ganador.getNombre() + "!";
            g2.setColor(ganador.getColor());
        }
        g2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, Constantes.TAMANIO_FUENTE_GANADOR));
        int ancho = g2.getFontMetrics().stringWidth(texto);
        int x = (getWidth() - ancho) / 2;
        int y = Constantes.ALTO_MARCADOR_PX + Constantes.ALTO_CAMPO / 2;
        g2.drawString(texto, x, y);
    }
}
