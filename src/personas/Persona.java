/*
Nombres de clase: La primer letra en mayúscula, esto por lo general son sustantivos o entidades, 
cosas reales, su nombre en Singular. 
Ej. Arbol, Casa, Carro, Persona. 

Atributos: La primer letra minúscula, y si son varias palabras juntas, la primer letra de las 
segunda palabra en adelante, en mayúscula. son adjetivos, características de la clase. 
Ej. impuestoDeVenta, fechaIngreso, cantidadSeleccionada

Métodos: mismo estandard de nombres que los atributos, pero inicia con un verbo, porque esto es comportamiento, es acción.
Ej. cantar(), extraerDatos(), obtenerEdad(), animarMovimiento()
*/

/*
    public: esto es un modificador de visibilidad, quiere decir que este método puede ser invocado desde cualquier otra clase
    
    void: lo que retorna el método, por ejemplo int, boolean, float, en el caso de void significa que no retorna nada
    ejemplo: 
    // estoy declarando que el método debe retornar un número int
    public int sumar(int valor1, int valor2) {
        return valor1+valor2;
    }

    cantar() : el nombre del método y los parámetros que recibe, dado que es (), significa que no recibe parámetros. 
    Los parámetros se pasan igual como declarar atributos  <tipoDeDato> etiqueta, y se separan por coma, por ejemplo, el 
    código del método sumar de arriba. 
*/

package personas;

import poderes.IPower;

public class Persona {
    
    private byte edad;
    protected String nombre;
    private IPower power;

    // Atributo ststic, existe una sola copia, compartida por todas las Personas
    private static int cantidadPersonas = 0;

    //Esto se ejecuta cada vez que se crea un objeto de la clase Persona, y sirve para incrementar el contador de personas creadas.
    {
        cantidadPersonas++;
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

    public void cantar() {
        // impriman un verso de no más de 4 líneas, de una canción que les guste y el autor. 
        System.out.println(
            "Debí tirar más fotos de cuando te tuve" + "\n" +
            "Debí darte más beso' y abrazo' las vece' que pude" + "\n" +
            "Ey, ojalá que los mío' nunca se muden" + "\n" +
            "Y si hoy me emborracho, pues que me ayuden"); 
    }
    
    public void setPower(IPower pPower) {
        this.power = pPower;
    }

    public void atacar() {
        this.power.dispararPoder();
      
    }

    public static int getCantidadPersonas() {
        return cantidadPersonas;
    }

}