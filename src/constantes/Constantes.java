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
    public static final double RADIO_COMBATE = 60;
    public static final double VELOCIDAD_MIN = 2;
    public static final double VELOCIDAD_MAX = 5;
    public static final int PASOS_POR_DIRECCION = 25;   // pasos antes de cambiar de dirección
    public static final int PAUSA_HILO_MS = 30;         // cada cuánto se mueve un mutante
    public static final int ENFRIAMIENTO_COMBATE_MS = 300; // tiempo sin pelear después de un combate

    // {------------ Constantes de la capa de la UI ------------}
    public static final int REFRESCO_UI_MS = 33;        // aprox 30 cuadros por segundo
    public static final int TAMANIO_MUTANTE_PX = 16;
    public static final int ALTO_BARRA_ENERGIA_PX = 4;
    public static final String TITULO_VENTANA = "Batalla de Mutantes";
    public static final int ALTO_MARCADOR_PX = 40;          // franja de arriba donde va el marcador
    public static final int MARGEN_TEXTO_PX = 10;
    public static final int TAMANIO_FUENTE_MARCADOR = 16;
    public static final int TAMANIO_FUENTE_GANADOR = 40;
    public static final int COLUMNAS_CAMPO_TAMANIO = 3;
    public static final Color COLOR_FONDO_CAMPO = new Color(235, 240, 225);
    public static final Color COLOR_FONDO_MARCADOR = new Color(40, 40, 40);
    public static final Color COLOR_TEXTO_MARCADOR = Color.WHITE;
    public static final Color COLOR_SIMBOLO = Color.WHITE;
    public static final Color COLOR_ENERGIA = new Color(0, 170, 0);
    public static final Color COLOR_ENERGIA_FONDO = Color.DARK_GRAY;
    public static final Color COLOR_TEXTO_GANADOR = Color.BLACK;

    public static final String TEXTO_TAMANIO = "Mutantes por equipo (3 a 11):";
    public static final String TEXTO_BOTON_INICIAR = "Iniciar";
    public static final String MENSAJE_INICIAL = "Escriba el tamaño y presione Iniciar";
    public static final String MENSAJE_NO_ES_NUMERO = "Debe escribir un número entero";
    public static final String MENSAJE_FUERA_DE_RANGO = "El tamaño debe estar entre 3 y 11";
    public static final String MENSAJE_EN_CURSO = "Batalla en curso...";
    public static final String MENSAJE_EMPATE = "¡Empate!";
    public static final String PREFIJO_GANADOR = "¡Ganan los ";

}

