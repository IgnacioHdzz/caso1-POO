package personas;

import constantes.Constantes;
import poderes.IPower;

public class Persona {
    private byte edad;
    protected String nombre;
    private IPower power;
    private static int cantidadPersonas = 0;
    //Esto se ejecuta cada vez que se crea un objeto de la clase Persona, y sirve para incrementar el contador de personas creadas.
    private int id;              // único por mutante; sirve para que solo UNO de la pareja resuelva el combate
    private double energia;      // inicia en Constantes.ENERGIA_INICIAL; double porque el daño se divide
    private int defensa;         // al azar entre DEFENSA_MIN y DEFENSA_MAX
    private double x;            // posición en el campo
    private double y;
    private double velocidad;    // al azar entre VELOCIDAD_MIN y VELOCIDAD_MAX
    private long finEnfriamiento; // momento (en ms) hasta el que no puede volver a pelear
    {
        cantidadPersonas++;
        this.id = cantidadPersonas;
        this.energia = Constantes.ENERGIA_INICIAL;
        this.defensa = (int) (Math.random() * (Constantes.DEFENSA_MAX - Constantes.DEFENSA_MIN + 1))
                + Constantes.DEFENSA_MIN;
        this.velocidad = Math.random() * (Constantes.VELOCIDAD_MAX - Constantes.VELOCIDAD_MIN)
                + Constantes.VELOCIDAD_MIN;
        this.finEnfriamiento = 0;
    }

    // constructor no tiene valor de retorno, y debe llamarse igual que la clase
    public Persona() {
        // inicializar persona con sus datos, edad, nombre y nacionalidad. 
        edad = 1;
        nombre = "Fulanito";
    }

    //Un segundo constructor que recibe paramametros
    public Persona(byte pEdad, String pNombre){
        this.edad = pEdad;
        this.nombre = pNombre;
    }

    public Persona(String pNombre, byte pEdad){
        this.edad =pEdad;
        this.nombre = pNombre;
    }

    public Persona(String pNombre){
        this();                     //Llama al constructor sin parámetros, para no tener que poner todos los atributos a mano. 
        this.nombre = pNombre;
    }

    public byte getEdad(){
        return this.edad;
    }

    public void setEdad( byte pEdad){
        this.edad = pEdad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setPower(IPower pPower) {
        this.power = pPower;
    }

    public void cantar() {
        // impriman un verso de no más de 4 líneas, de una canción que les guste y el autor. 
        System.out.println(
            "Debí tirar más fotos de cuando te tuve" + "\n" +
            "Debí darte más beso' y abrazo' las vece' que pude" + "\n" +
            "Ey, ojalá que los mío' nunca se muden" + "\n" +
            "Y si hoy me emborracho, pues que me ayuden"); 
    }

    public void atacar() {
        if (this.power != null) {
            this.power.dispararPoder();
        }
    }

public IPower getPower() {
        return this.power;
    }

    public int getId() {
        return this.id;
    }

    public double getEnergia() {
        return this.energia;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    // Mueve al mutante a una nueva posición. La usan Partida (posición inicial) y HiloMutante (movimiento).
    public void setPosicion(double pX, double pY) {
        this.x = pX;
        this.y = pY;
    }

    public boolean tienePoder() {
        return this.power != null;
    }

    public boolean estaVivo() {
        return this.energia > 0;
    }

    public void recibirDanio(double pDanio) {
        this.energia = Math.max(0, this.energia - pDanio);
    }

        // Distancia en línea recta entre este mutante y otro (teorema de Pitágoras).
    public double distanciaA(Persona pOtra) {
        double dx = this.x - pOtra.getX();
        double dy = this.y - pOtra.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
    // Cada profesión puede sobrescribir este método (@Override) con su propia probabilidad.
    public double getProbabilidadAtaque() {
        return Constantes.PROB_ATAQUE_PERSONA;
    }

    // true = decide atacar, false = decide defender.
    // Usa getProbabilidadAtaque(); gracias al polimorfismo, un Pirata usará la suya.
    public boolean decidirAtacar() {
        return Math.random() < this.getProbabilidadAtaque();
    }

    public boolean puedeCombatir() {
        return System.currentTimeMillis() >= this.finEnfriamiento;
    }

    public void iniciarEnfriamiento() {
        this.finEnfriamiento = System.currentTimeMillis() + Constantes.ENFRIAMIENTO_COMBATE_MS;
    }

}
