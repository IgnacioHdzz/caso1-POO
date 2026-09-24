package juego;

// El campo de batalla: solo conoce sus medidas.
// Los mutantes le preguntan su tamaño para no salirse (capa Control).
public class Campo {
    private int ancho;
    private int alto;
    public Campo(int pAncho, int pAlto) {
        this.ancho = pAncho;
        this.alto = pAlto;
    }
    public int getAncho() {
        return this.ancho;
    }
    public int getAlto() {
        return this.alto;
    }
    // true si el punto (x, y) está dentro del campo (entre 0 y ancho, entre 0 y alto).
    public boolean estaDentro(double pX, double pY) {
        if (pX < 0) {
            return false;
        }
        if (pX > this.ancho) {
            return false;
        }
        if (pY < 0) {
            return false;
        }
        if (pY > this.alto) {
            return false;
        }
        return true;
    }
}
