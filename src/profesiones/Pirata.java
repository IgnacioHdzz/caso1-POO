package profesiones;

import personas.Persona;

public class Pirata extends Persona {

    // atributos propios de Pirata
    private String nombreBarco;
    private int tesorosEncontrados;
    private boolean tieneLoro;
    private String nombreLoro;

    public Pirata(String pNombre, byte pEdad, String pNombreBarco) {
        super(pNombre, pEdad);
        this.nombreBarco = pNombreBarco;
        this.tesorosEncontrados = 0;
        this.tieneLoro = false;
    }

    public String getNombreBarco() {
        return this.nombreBarco;
    }

    public void setNombreBarco(String pNombreBarco) {
        this.nombreBarco = pNombreBarco;
    }

     public void setTieneLoro(boolean pTieneLoro, String pNombreLoro) {
        this.tieneLoro = pTieneLoro;
        this.nombreLoro = pNombreLoro;
    }
   
    public String getNombreLoro() {
        if(this.tieneLoro) {
            return this.nombreLoro;
        } else {
            return "No tiene loro";
        }
    }
    public void buscarTesoro() {
        this.tesorosEncontrados++;
        System.out.println(this.nombre + " encontró un tesoro a bordo de " + this.nombreBarco + ".\n" +
            " Lleva " + this.tesorosEncontrados + " tesoros encontrados.");
    }
    public void gritar() {
        System.out.println("AAAAAARRRRRRRRRR!!!");
    }
}