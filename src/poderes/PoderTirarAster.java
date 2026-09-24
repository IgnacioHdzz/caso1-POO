package poderes;

public class PoderTirarAster extends PoderMutante {
    public PoderTirarAster() {
        super(); // llama al constructor de PoderMutante, que asigna el daño
    }

    @Override
    public void dispararPoder() {
        System.out.println(">>>>> **** *********** ********************* >>>>>>> ");

    }

}
