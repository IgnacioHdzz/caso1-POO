package programaMutante;

import personas.Persona;
import profesiones.Futbolista;
import profesiones.Musico;
import profesiones.Pirata;
import poderes.IPower;
import poderes.PoderTirarAster;
import poderes.PoderTirarCelebs;
import poderes.PoderTirarFlechas;
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


        System.out.println(p1.getNombre());
        p1.cantar();

        System.out.println("La edad de Ignacio es:" + Ignacio.getEdad());
        Ignacio.setEdad((byte)20);
        System.out.println("La nueva edad de Ignacio es:" + Ignacio.getEdad()); *
      
        { -----------------------------------------------------------------------------------------------------}*/ 

        //Pruebas con la profesión de pirata.

        Pirata pirata = new Pirata("Jack Sparrow", (byte)50);

        System.out.println("Existe un pirata llamado " + pirata.getNombre());
        pirata.buscarTesoro();
        pirata.setNombreBarco("El Perla Negro");
        System.out.println("El nombre del barco de " + pirata.getNombre() + " es: " + pirata.getNombreBarco());
        
        pirata.setTieneLoro(true, "Rafael el Loro");
        if(pirata.getNombreLoro() == null){
            System.out.println(pirata.getNombre() + " aún no tiene loro.");
        }else{
            System.out.println(pirata.getNombre() + " tiene un loro que se llama: " + pirata.getNombreLoro());  
        }
        pirata.buscarTesoro();
        pirata.buscarTesoro();
        System.out.println(pirata.getNombre() + " lleva " + pirata.getCantidadTesoros() + " tesoros encontrados.");
        pirata.gritar();
        
        System.out.println();

        //Pruebas con la profesión de músico.

        Musico cantante = new Musico("Romeo Santos", (byte)45, "Rock");

        System.out.println("Existe un músico cantante llamado " + cantante.getNombre());
        System.out.println("En este momento " + cantante.getNombre() + " canta canciones pertenecientes al género de: " + cantante.getGeneroMusical());
        cantante.setGeneroMusical("Bachata");
        System.out.println("Ahora " + cantante.getNombre() + " canta canciones pertenecientes al género de: " + cantante.getGeneroMusical());
        cantante.componerCancion("Propuesta Indecente");
        cantante.componerCancion("Eres Mía");
        cantante.componerCancion("Imitadora");
        cantante.nombrarCancionesCompuestas();
        cantante.cantar();

        System.out.println();

        //Pruebas con la profesión de Futbolista

        Futbolista futbolista = new Futbolista("Harry Kane", (byte)33, "Bayern Munich");

        System.out.println("Existe un futbolista llamado " + futbolista.getNombre());
        futbolista.setSalario(500000);
        System.out.println("El salario de " + futbolista.getNombre() + " es: $" + futbolista.getSalario());
        futbolista.pagarFutbolista();
        futbolista.pagarFutbolista();
        System.out.println("El net worth de " + futbolista.getNombre() + " actualmente es de: $" + futbolista.getNetWorth());
        futbolista.cambiarEquipo("LiverPool");

        System.out.println();
    

        //Probando poder de la herencia en persona y el poliformismo de IPower y Persona

        Persona profesionales[] = new Persona[5];
        IPower poderesDisponibles[] = {new PoderTirarAster(), new PoderTirarCelebs(), new PoderTirarFlechas(),new PoderTirarEstrellas(), new PoderTirarPrimos()};

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
                    profesionales[i] = new Pirata("Barba Negra "+i, (byte)54);
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