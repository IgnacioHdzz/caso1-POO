package constantes;

import java.awt.Color;

public class Constantes {
    private Constantes() {
    }

    // {------------ Constantes de la capa de modelo ------------}
    public static final double ENERGIA_INICIAL = 100;
    public static final int DEFENSA_MIN = 1;
    public static final int DEFENSA_MAX = 3;
    public static final int DANIO_MIN = 1;
    public static final int DANIO_MAX_INICIAL = 3;
    public static final int DANIO_MAXIMO = 7;
    public static final int AUMENTO_DANIO = 1;

    public static final int EDAD_MIN = 18;
    public static final int EDAD_MAX = 60;

    // Probabilidad de que cada profesión decida atacar.
    // De esta forma el tipo de profesión sí influye en la batalla.
    public static final double PROB_ATAQUE_PERSONA = 0.5;
    public static final double PROB_ATAQUE_FUTBOLISTA = 0.6;
    public static final double PROB_ATAQUE_MUSICO = 0.3;
    public static final double PROB_ATAQUE_PIRATA = 0.8;

    // Valores por defecto para crear profesiones al azar
    public static final int CANTIDAD_PROFESIONES = 3;
    public static final int CANTIDAD_PODERES = 5;
    public static final String EQUIPO_FUTBOL_DEFECTO = "Saprissa";
    public static final String GENERO_MUSICAL_DEFECTO = "Reggaeton";
    public static final String BARCO_DEFECTO = "El Perla Negra";
    public static final int MAX_CANCIONES = 5;

    // {------------ Constantes de la capa de juego ------------}
    public static final int MIN_MUTANTES_POR_EQUIPO = 3;
    public static final int MAX_MUTANTES_POR_EQUIPO = 11;

    public static final int ANCHO_CAMPO = 800;
    public static final int ALTO_CAMPO = 600;

    public static final String NOMBRE_EQUIPO_1 = "Rojos";
    public static final Color COLOR_EQUIPO_1 = Color.RED;
    public static final String SIMBOLO_EQUIPO_1 = "#";

    public static final String NOMBRE_EQUIPO_2 = "Azules";
    public static final Color COLOR_EQUIPO_2 = Color.BLUE;
    public static final String SIMBOLO_EQUIPO_2 = "*";

    // {------------ Constantes de la capa de control ------------}
    public static final double RADIO_COMBATE = 30;
    public static final double VELOCIDAD_MIN = 1;
    public static final double VELOCIDAD_MAX = 4;
    public static final int PASOS_POR_DIRECCION = 25;   // pasos antes de cambiar de dirección
    public static final int PAUSA_HILO_MS = 30;         // cada cuánto se mueve un mutante
    public static final int ENFRIAMIENTO_COMBATE_MS = 800; // tiempo sin pelear después de un combate

    // {------------ Constantes de la capa de la UI ------------}
    public static final int REFRESCO_UI_MS = 33;        // aprox 30 cuadros por segundo
    public static final int TAMANIO_MUTANTE_PX = 16;
    public static final int ALTO_BARRA_ENERGIA_PX = 4;
    public static final String TITULO_VENTANA = "Batalla de Mutantes";
}
