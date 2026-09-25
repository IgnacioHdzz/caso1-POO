package personas;

import constantes.Constantes;
import poderes.IPower;
import poderes.PoderTirarAster;
import poderes.PoderTirarCelebs;
import poderes.PoderTirarEstrellas;
import poderes.PoderTirarFlechas;
import poderes.PoderTirarPrimos;
import profesiones.Futbolista;
import profesiones.Musico;
import profesiones.Pirata;

public class PruebaModelo {
    public static void main(String[] args) {
        //Pruebas con la profesión de pirata.

        Pirata pirata = new Pirata("Jack Sparrow", (byte)50);

        System.out.println("Existe un pirata llamado " + pirata.getNombre());
        pirata.buscarTesoro();
        pirata.setNombreBarco("El Perla Negro");
        System.out.println("El nombre del barco de " + pirata.getNombre() + " es: " + pirata.getNombreBarco());
        
        pirata.setTieneLoro(true, "Rafael el Loro");
        if(pirata.getNombreLoro() == null){
            System.out.println(pirata.getNombre() + " aún no tiene loro.");
        }
        else{
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
    
        // Herencia + polimorfismo: profesión y poder al azar (lógica de la Semana 5).
        // Corregido: cada persona recibe su PROPIO new de poder, ya no comparten el mismo objeto.
        Persona profesionales[] = new Persona[5];
        for (int i = 0; i < profesionales.length; i++) {
            int tipoProfesion = (int) (Math.random() * Constantes.CANTIDAD_PROFESIONES);
            switch (tipoProfesion) {
                case 0:
                    profesionales[i] = new Futbolista("Messi " + i, (byte) 39, "Barcelona");
                    break;
                case 1:
                    profesionales[i] = new Musico("Bad Bunny " + i, (byte) 32, "Reggaeton");
                    break;
                default:
                    profesionales[i] = new Pirata("Barba Negra " + i, (byte) 54);
            }
            profesionales[i].setPower(crearPoderAleatorio());
        }

        for(Persona p : profesionales) {
            System.out.println("Ataca "+p.getNombre());
            p.atacar();
        }

        //Codigo actualizado para caso 1
        System.out.println("\n     Pruebas del Caso 1     ");

        // id, energía, defensa y daño del poder de cada persona
        for (Persona p : profesionales) {
            System.out.println(p.getNombre() + " -> id: " + p.getId()
                    + ", energia: " + p.getEnergia()
                    + ", defensa: " + p.getDefensa()
                    + ", danio del poder: " + p.getPower().getDanio());
        }
        System.out.println();

        // recibirDanio(): la energía baja y nunca queda negativa; estaVivo()
        Persona pruebaDanio = new Pirata("Prueba Danio", (byte) 30);
        System.out.println("Energia inicial: " + pruebaDanio.getEnergia() + ", vivo: " + pruebaDanio.estaVivo());
        pruebaDanio.recibirDanio(40);
        System.out.println("Tras recibir 40 de danio: " + pruebaDanio.getEnergia() + ", vivo: " + pruebaDanio.estaVivo());
        pruebaDanio.recibirDanio(1000);
        System.out.println("Tras recibir 1000 de danio: " + pruebaDanio.getEnergia() + ", vivo: " + pruebaDanio.estaVivo());
        System.out.println();

        // aumentarDanio(): llamarlo 10 veces y comprobar que no pasa de DANIO_MAXIMO
        IPower poderPrueba = crearPoderAleatorio();
        System.out.println("Danio inicial del poder: " + poderPrueba.getDanio());
        for (int i = 0; i < 10; i++) {
            poderPrueba.aumentarDanio();
        }
        System.out.println("Danio tras 10 aumentos (tope " + Constantes.DANIO_MAXIMO + "): " + poderPrueba.getDanio());
        System.out.println();

        // distanciaA() entre dos personas con posiciones conocidas (0,0) y (3,4) -> 5
        Persona pA = new Pirata("Punto A", (byte) 30);
        Persona pB = new Pirata("Punto B", (byte) 30);
        pA.setPosicion(0, 0);
        pB.setPosicion(3, 4);
        System.out.println("Distancia entre (0,0) y (3,4): " + pA.distanciaA(pB) + " (esperado: 5.0)");
        System.out.println();

        // decidirAtacar() 1000 veces en un Pirata y en un Musico
        Pirata pirataProb = new Pirata("Pirata Prob", (byte) 30);
        Musico musicoProb = new Musico("Musico Prob", (byte) 30, "Rock");
        int ataquesPirata = 0;
        int ataquesMusico = 0;
        for (int i = 0; i < 1000; i++) {
            if (pirataProb.decidirAtacar()) {
                ataquesPirata++;
            }
            if (musicoProb.decidirAtacar()) {
                ataquesMusico++;
            }
        }
        System.out.println("El pirata atacó " + ataquesPirata + " de 1000 veces (prob esperada: "
                + Constantes.PROB_ATAQUE_PIRATA + ")");
        System.out.println("El musico atacó " + ataquesMusico + " de 1000 veces (prob esperada: "
                + Constantes.PROB_ATAQUE_MUSICO + ")");
        System.out.println();

        // una Persona sin poder llamando atacar() no debe caerse
        Persona sinPoder = new Pirata("Sin Poder", (byte) 30);
        System.out.println("Persona sin poder, tiene poder: " + sinPoder.tienePoder());
        sinPoder.atacar();
        System.out.println("atacar() no lanzó error aunque no tenía poder.");
    }

    // Cada llamada devuelve un poder NUEVO: dos personas nunca comparten el mismo objeto poder.
    private static IPower crearPoderAleatorio() {
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
}