package poderes;

// Contrato de TODO poder mutante. Persona solo conoce esta interfaz, nunca los poderes concretos.
// Las interfaces NO pueden guardar atributos de objeto (solo static), por eso el daño
// vive en la clase abstracta PoderMutante.
public interface IPower {

    public void dispararPoder();

    public int getDanio();

    public void aumentarDanio();
}