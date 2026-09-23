package profesiones;

import personas.Persona;

public class Futbolista extends Persona {
    private String equipo;
    private int netWorth = 0; //Un valor inicial de su net worth en dolares.
    private int salario = 0;


    public Futbolista(String pNombre, byte pEdad, String pEquipo) {
        super(pNombre, pEdad);
        this.equipo = pEquipo;
    }

    public int getNetWorth() {
        return this.netWorth;
    }

    public void setSalario(int pSalario) {
        this.salario = pSalario;
        this.netWorth += pSalario; //Al establecer el salario, también se suma al net worth.
    }

    public int getSalario(){
        return this.salario;
    }

    public void cambiarEquipo(String pNuevoEquipo) {
        this.equipo = pNuevoEquipo;
        System.out.println(this.getNombre() + " ahora es parte del equipo: " + this.equipo);
    }

    public void pagarFutbolista(){
        this.netWorth += this.salario;
        System.out.println("El net worth del futbolista ha amumentado.");
    }

}

