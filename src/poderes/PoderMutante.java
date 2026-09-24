package poderes;
import constantes.Constantes;

// Clase ABSTRACTA: no se puede hacer "new PoderMutante()".
// Guarda lo que todos los poderes tienen en común (el daño) y deja
// dispararPoder() para que cada poder concreto lo implemente a su manera.
public abstract class PoderMutante implements IPower {
    private int danio;
    public PoderMutante() {
        this.danio = (int) (Math.random() * (Constantes.DANIO_MAX_INICIAL - Constantes.DANIO_MIN + 1))
                + Constantes.DANIO_MIN;
    }

    @Override
    public int getDanio() {
        return this.danio;
    }

    // Sube el daño en AUMENTO_DANIO, pero nunca por encima de DANIO_MAXIMO.
    @Override
    public void aumentarDanio() {
        this.danio = Math.min(Constantes.DANIO_MAXIMO, this.danio + Constantes.AUMENTO_DANIO);
    }

    // No se implementa aquí: cada subclase decide cómo se ve su poder.
    @Override
    public abstract void dispararPoder();
}
