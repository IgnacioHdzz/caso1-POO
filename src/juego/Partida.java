package juego;

import constantes.Constantes;
import personas.Persona;
import poderes.IPower;
import poderes.PoderTirarAster;
import poderes.PoderTirarCelebs;
import poderes.PoderTirarEstrellas;
import poderes.PoderTirarFlechas;
import poderes.PoderTirarPrimos;
import profesiones.Futbolista;
import profesiones.Musico;
import profesiones.Pirata;

// La partida organiza la batalla (sin dibujar nada y sin mover a nadie):
// crea el campo y los dos equipos, y sabe si la batalla terminó y quién ganó.
public class Partida {
    private Campo campo;
    private Equipo equipo1;
    private Equipo equipo2;
    private int tamanioEquipo;

    // Supone que pTamanioEquipo ya es válido (se revisa antes con esTamanioValido).
    public Partida(int pTamanioEquipo) {
        this.tamanioEquipo = pTamanioEquipo;
        this.campo = new Campo(Constantes.ANCHO_CAMPO, Constantes.ALTO_CAMPO);
        this.equipo1 = new Equipo(Constantes.NOMBRE_EQUIPO_1, Constantes.COLOR_EQUIPO_1,
                Constantes.SIMBOLO_EQUIPO_1, pTamanioEquipo);
        this.equipo2 = new Equipo(Constantes.NOMBRE_EQUIPO_2, Constantes.COLOR_EQUIPO_2,
                Constantes.SIMBOLO_EQUIPO_2, pTamanioEquipo);
        crearEquipos();
    }

    // static: se puede preguntar ANTES de crear la partida -> Partida.esTamanioValido(5)
    public static boolean esTamanioValido(int pTamanio) {
        return pTamanio >= Constantes.MIN_MUTANTES_POR_EQUIPO && pTamanio <= Constantes.MAX_MUTANTES_POR_EQUIPO;
    }

    // Llena ambos equipos con la misma cantidad de mutantes al azar y les da su posición inicial.
    private void crearEquipos() {
        for (int i = 0; i < this.tamanioEquipo; i++) {
            Persona mutante1 = crearMutanteAleatorio();
            colocarMutante(mutante1, true);
            this.equipo1.agregarMutante(mutante1);

            Persona mutante2 = crearMutanteAleatorio();
            colocarMutante(mutante2, false);
            this.equipo2.agregarMutante(mutante2);
        }
    }

    // Reutiliza la lógica del quickstart de la Semana 5: profesión al azar + poder al azar.
    // OJO: cada mutante necesita un poder NUEVO (new), porque su daño crece por separado.
    private Persona crearMutanteAleatorio() {
        int edad = (int) (Math.random() * (Constantes.EDAD_MAX - Constantes.EDAD_MIN + 1)) + Constantes.EDAD_MIN;
        int tipoProfesion = (int) (Math.random() * Constantes.CANTIDAD_PROFESIONES);
        Persona mutante;

        switch (tipoProfesion) {
            case 0:
                mutante = new Futbolista("Futbolista " + Persona.getCantidadPersonas(), (byte) edad,
                        Constantes.EQUIPO_FUTBOL_DEFECTO);
                break;
            case 1:
                mutante = new Musico("Musico " + Persona.getCantidadPersonas(), (byte) edad,
                        Constantes.GENERO_MUSICAL_DEFECTO);
                break;
            default:
                mutante = new Pirata("Pirata " + Persona.getCantidadPersonas(), (byte) edad);
        }

        mutante.setPower(crearPoderAleatorio());
        return mutante;
    }

    private IPower crearPoderAleatorio() {
        int tipoPoder = (int) (Math.random() * Constantes.CANTIDAD_PODERES);
        switch (tipoPoder) {
            case 0:
                return new PoderTirarAster();
            case 1:
                return new PoderTirarCelebs();
            case 2:
                return new PoderTirarFlechas();
            case 3:
                return new PoderTirarEstrellas();
            default:
                return new PoderTirarPrimos();
        }
    }

    // Equipo 1 aparece en la mitad izquierda del campo y equipo 2 en la mitad derecha.
    private void colocarMutante(Persona pMutante, boolean pEsEquipo1) {
        double mitad = this.campo.getAncho() / 2.0;
        double x;
        if (pEsEquipo1) {
            x = Math.random() * mitad;
        } else {
            x = mitad + Math.random() * mitad;
        }
        double y = Math.random() * this.campo.getAlto();
        pMutante.setPosicion(x, y);
    }

    // Devuelve el equipo al que pertenece el mutante.
    public Equipo getEquipoDe(Persona pMutante) {
        if (this.equipo1.contiene(pMutante)) {
            return this.equipo1;
        }
        return this.equipo2;
    }

    // Devuelve los mutantes del equipo contrario (la capa Control los usa para buscar enemigos).
    public Persona[] getEnemigosDe(Persona pMutante) {
        if (this.equipo1.contiene(pMutante)) {
            return this.equipo2.getMutantes();
        }
        return this.equipo1.getMutantes();
    }

    // La partida termina cuando al menos un equipo se queda sin vivos.
    public boolean estaTerminada() {
        return !this.equipo1.tieneVivos() || !this.equipo2.tieneVivos();
    }

    // Empate: terminó y ninguno de los dos equipos tiene vivos.
    public boolean esEmpate() {
        return this.estaTerminada() && !this.equipo1.tieneVivos() && !this.equipo2.tieneVivos();
    }

    // null si la partida no ha terminado o si fue empate.
    public Equipo getGanador() {
        if (!this.estaTerminada() || this.esEmpate()) {
            return null;
        }
        if (this.equipo1.tieneVivos()) {
            return this.equipo1;
        }
        return this.equipo2;
    }

    public Campo getCampo() {
        return this.campo;
    }

    public Equipo getEquipo1() {
        return this.equipo1;
    }

    public Equipo getEquipo2() {
        return this.equipo2;
    }

    public int getTamanioEquipo() {
        return this.tamanioEquipo;
    }
}