package profesiones;
import constantes.Constantes;
import personas.Persona;

public class Musico extends Persona {
    private String generoMusical;
    private String cancionesCompuestas[] = {};
    private int cantidadCanciones;

    public Musico(String pNombre, byte pEdad, String pGeneroMusical) {
        super(pNombre, pEdad);
        this.generoMusical = pGeneroMusical;
        this.cancionesCompuestas = new String[Constantes.MAX_CANCIONES]; // Un musico puede tener un máximo de MAX_CANCIONES canciones compuestas.
    }

    public void setGeneroMusical(String pGeneroMusical){
        this.generoMusical = pGeneroMusical;
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
        cantidadCanciones++;
    }

    public void nombrarCancionesCompuestas() {
        System.out.println("Canciones compuestas por " + this.getNombre() + ":");
        for (String cancion : cancionesCompuestas) {
            if (cancion != null) {
                System.out.println("- " + cancion);
            }
        }
    }

    public int getCancionesCompuestas(){
        return this.cantidadCanciones;
    }

    public void cantar() {
        super.cantar();
    }

    // Sobrescribe el método de Persona: cada profesión pelea con su propio estilo (polimorfismo).
    @Override
    public double getProbabilidadAtaque() {
        return Constantes.PROB_ATAQUE_MUSICO;
    }
}



