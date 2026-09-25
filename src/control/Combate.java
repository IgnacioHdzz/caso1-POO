package control;

import personas.Persona;

// Resuelve el encuentro entre dos mutantes enemigos.
public class Combate {

    public static synchronized void resolver(Persona pA, Persona pB) {
        if (!pA.estaVivo() || !pB.estaVivo()) { // si A no está vivo, o B no está vivo, entonces sale. ! = not  
            return;
        }
        if (!pA.puedeCombatir() || !pB.puedeCombatir()) {
            return;
        }

        boolean aAtaca = pA.decidirAtacar();
        boolean bAtaca = pB.decidirAtacar();

        if (aAtaca) {
            aplicarAtaque(pA, pB, !bAtaca); //si bAtaca = false, entonces entra en el parámetro del método como true. 
        }
        if (bAtaca) {
            aplicarAtaque(pB, pA, !aAtaca);
        }

        pA.iniciarEnfriamiento();
        pB.iniciarEnfriamiento();
    }

    private static void aplicarAtaque(Persona pAtacante, Persona pDefensor, boolean pDefensorDefiende) {
        double danio = calcularDanio(pAtacante, pDefensor, pDefensorDefiende);
        if (danio > 0) {
            pDefensor.recibirDanio(danio);
            pAtacante.getPower().aumentarDanio();
        }
    }

    private static double calcularDanio(Persona pAtacante, Persona pDefensor, boolean pDefensorDefiende) {
        if (!pAtacante.tienePoder()) { // Un mutante sin poder no hace daño.
            return 0;
        }
        double danio = pAtacante.getPower().getDanio();
        if (pDefensorDefiende) {
            danio = danio / pDefensor.getDefensa();
        }
        return danio;
    }
}