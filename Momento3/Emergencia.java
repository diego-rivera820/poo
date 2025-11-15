package Momento3;

public class Emergencia {

    private boolean activada;

    public Emergencia(){
        activada = false;
    }

    public boolean isActivada(){
        return activada;
    }

    public void activar(Puerta puerta){
        activada = true;
        System.out.println("!!! EMERGENCIA ACTIVADA !!!");
        puerta.abrir();
    }

    public void resetear(){
        activada = false;
        System.out.println("Emergencia desactivada.");
    }
    
}
