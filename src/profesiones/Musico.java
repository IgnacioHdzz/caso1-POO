package profesiones;

import personas.Persona;

public class Musico extends Persona {

    private String generoMusical;
    private String cancionesCompuestas[] = {};


    public Musico(String pNombre, byte pEdad, String pGeneroMusical) {
        super(pNombre, pEdad);
        this.generoMusical = pGeneroMusical;
        this.cancionesCompuestas = new String[5]; // Un musico puede tener un máximo de 5 canciones compuestas.
    }

    public String getGeneroMusical() {
        return this.generoMusical;
    }

    public void componerCancion(String pNombreCancion) {
        
        for (int i = 0; i < cancionesCompuestas.length; i++) {
            if (cancionesCompuestas[i] == null) {
                cancionesCompuestas[i] = pNombreCancion;
                break;
            }
        }
    }

    public void getCancionesCompuestas() {
        System.out.println("Canciones compuestas por " + this.getNombre() + ":");
        for (String cancion : cancionesCompuestas) {
            if (cancion != null) {
                System.out.println("- " + cancion);
            }
        }
    }

    public void cantar() {
        super.cantar();
    }
}



