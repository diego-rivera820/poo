package Momento3;

// implementacion de la clase Emergencia
public class Emergencia {

    private boolean activada;

    // constructor
    public Emergencia(){
        activada = false;
    }

    // getter para saber si la emergencia está activada
    public boolean isActivada(){
        return activada;
    }
    // metodo para activar la emergencia y abrir las puertas
    public void activar(Puerta puerta){
        activada = true;
        System.out.println("!!! EMERGENCIA ACTIVADA !!!");
        puerta.abrir();
    }

    // metodo para resetear la emergencia
    public void resetear(){
        activada = false;
        System.out.println("Emergencia desactivada.");
    }
    
}
