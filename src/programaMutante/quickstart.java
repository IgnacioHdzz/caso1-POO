package programaMutante;

import personas.Persona;
import profesiones.Futbolista;
import profesiones.Musico;
import profesiones.Pirata;
import poderes.IPower;
import poderes.PoderTiraAster;
import poderes.PoderTiraCelebs;
import poderes.PoderTiraFlechas;
import poderes.PoderTirarEstrellas;
import poderes.PoderTirarPrimos;

public class quickstart {
    public static void main(String[] args) {
        
        /* { ------- PRUEBAS DE LA CLASE PERSONA Y SUS CONSTRUCTORES VISTAS EN CLASE ---------------------}

        System.out.println("Hello clase de Poo");

        Persona Ignacio = new Persona();
        Persona p1 = new Persona("Francisco", (byte) 21); //Transformar el 21 a byte, porque el constructor recibe un byte y no un int.
        
        System.out.println(Ignacio.getNombre());
        Ignacio.cantar();

        System.out.println("--------------------------------------------------------------------");

        System.out.println(p1.getNombre());
        p1.cantar();

        System.out.println("La edad de Ignacio es:" + Ignacio.getEdad());
        Ignacio.setEdad((byte)20);
        System.out.println("La nueva edad de Ignacio es:" + Ignacio.getEdad()); *
      
        { -----------------------------------------------------------------------------------------------------}*/ 

        //Probando poder de la herencia en persona y el poliformismo de IPower y Persona

        Persona profesionales[] = new Persona[10];
        IPower poderesDisponibles[] = {new PoderTiraAster(), new PoderTiraCelebs(), new PoderTiraFlechas(),new PoderTirarEstrellas(), new PoderTirarPrimos()};

        for (int i = 0; i < 10; i++) {
            int tipoProfesion = (int)(Math.random() * 3);
            switch (tipoProfesion) {
                case 0:
                    profesionales[i] = new Futbolista("Messi "+i, (byte)39, "Barcelona");
                    break;
                case 1:
                    profesionales[i] = new Musico("Bad Bunny "+i, (byte)32, "Reggaeton");
                    break;
                case 2:
                    profesionales[i] = new Pirata("Barba Negra "+i, (byte)54, "Caribe");
                    break;
                default:
                    profesionales[i] = new Musico("Micheal Jackson"+i, (byte)30, "Pop");
            }
            profesionales[i].setPower(poderesDisponibles[(int)(Math.random() * 5)]);
        }

        for(Persona p : profesionales) {
            System.out.println("Ataca "+p.getNombre());
            p.atacar();
        }

    }
}