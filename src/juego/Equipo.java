package juego;
import java.awt.Color;
import personas.Persona;

// Un equipo: nombre, color, símbolo y sus mutantes.
// Se usa un arreglo de tamaño fijo, porque el tamaño del equipo se conoce al crear la partida.
public class Equipo {

    private String nombre;
    private Color color;
    private String simbolo;
    private Persona[] mutantes;
    private int cantidad;   // cuántos mutantes se han agregado hasta ahora

    public Equipo(String pNombre, Color pColor, String pSimbolo, int pCapacidad) {
        this.nombre = pNombre;
        this.color = pColor;
        this.simbolo = pSimbolo;
        this.mutantes = new Persona[pCapacidad];
        this.cantidad = 0;
    }

    // Agrega un mutante en el siguiente espacio libre (si todavía hay espacio).
    public void agregarMutante(Persona pMutante) {
        if (this.cantidad < this.mutantes.length) {
            this.mutantes[this.cantidad] = pMutante;
            this.cantidad++;
        }
    }

    // true si el mutante pertenece a este equipo.
    public boolean contiene(Persona pMutante) {
        for (int i = 0; i < this.cantidad; i++) {
            if (this.mutantes[i] == pMutante) {
                return true;
            }
        }
        return false;
    }

    public int contarVivos() {
        int vivos = 0;
        for (int i = 0; i < this.cantidad; i++) {
            if (this.mutantes[i].estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }

    public int contarMuertos() {
        return this.cantidad - this.contarVivos();
    }

    public boolean tieneVivos() {
        return this.contarVivos() > 0;
    }

    public Persona[] getMutantes() {
        return this.mutantes;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Color getColor() {
        return this.color;
    }

    public String getSimbolo() {
        return this.simbolo;
    }
}