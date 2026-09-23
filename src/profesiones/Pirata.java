package profesiones;

import personas.Persona;

public class Pirata extends Persona {

    // atributos propios de Pirata
    private String nombreBarco;
    private int tesorosEncontrados;
    private boolean tieneLoro;
    private String nombreLoro;

    public Pirata(String pNombre, byte pEdad) {
        super(pNombre, pEdad);
        this.nombreBarco = null;
        this.tesorosEncontrados = 0;
        this.tieneLoro = false;
    }

    public void setNombreBarco(String pNombreBarco) {
        this.nombreBarco = pNombreBarco;
    }

    public String getNombreBarco() {
        if (this.nombreBarco == null) {
            return null;
        }
        return this.nombreBarco;
    }

     public void setTieneLoro(boolean pTieneLoro, String pNombreLoro) {
        this.tieneLoro = pTieneLoro;
        this.nombreLoro = pNombreLoro;
    }
   
    public String getNombreLoro() {
        if(this.tieneLoro) {
            return this.nombreLoro;
        } 
        return null;    
    }

    public void buscarTesoro() {
        if (this.nombreBarco == null) {
            System.out.println("¡Para buscar tesoros es necesario tener un barco!");
            return;
        }

        if (this.tesorosEncontrados == 0){
            System.out.println("¡" + this.nombre + " encontró su primer tesoro a bordo de " + this.nombreBarco + "!");
        }else{
            System.out.println("¡" + this.nombre + " encontró otro tesoro a bordo de " + this.nombreBarco + "!"); 
        } 
        
        this.tesorosEncontrados++;
    }

    public int getCantidadTesoros(){
        return this.tesorosEncontrados;
    }

    public void gritar() {
        System.out.println("AAAAAARRRRRRRRRR!!!");
    }
}