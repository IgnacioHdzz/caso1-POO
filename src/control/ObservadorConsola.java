package control;

import juego.Equipo;
import juego.Partida;

// Observador para probar la capa Control sin ventana: imprime el marcador en consola,
// pero solo cuando cambia (si no, imprimiría ~30 líneas por segundo).
public class ObservadorConsola implements IObservador {

    private Partida partida;
    private int ultimosVivos1;
    private int ultimosVivos2;

    public ObservadorConsola(Partida pPartida) {
        this.partida = pPartida;
        this.ultimosVivos1 = -1;
        this.ultimosVivos2 = -1;
    }

    @Override
    public void actualizar() {
        Equipo equipo1 = partida.getEquipo1();
        Equipo equipo2 = partida.getEquipo2();
        int vivos1 = equipo1.contarVivos();
        int vivos2 = equipo2.contarVivos();

        if (vivos1 != ultimosVivos1 || vivos2 != ultimosVivos2) {
            System.out.println(equipo1.getNombre() + ": " + vivos1 + " vivos, " + equipo1.contarMuertos() + " muertos"
                    + "  |  " + equipo2.getNombre() + ": " + vivos2 + " vivos, " + equipo2.contarMuertos() + " muertos");
            ultimosVivos1 = vivos1;
            ultimosVivos2 = vivos2;
        }
    }
}