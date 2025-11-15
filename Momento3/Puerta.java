package Momento3;

public class Puerta {

    private boolean abierta;

    public Puerta() {
        abierta = true;
    }

    public boolean isAbierta(){
        return abierta;
    }

    public boolean cerrar(double anchoObstaculo, double altoObstaculo, double anchoMax, double altoMax){
        
        if (anchoObstaculo > anchoMax || altoObstaculo > altoMax){
            System.out.printf("obstaculo (%.2fx%.2f) demasiado grande: la puerta no puede cerrarse.%n", anchoObstaculo, altoObstaculo);
            return false;
        }
    

        abierta = false;
        System.out.println("Puerta cerrada exitosamente.");
        return true;
    }

    public void abrir(){
        abierta = true;
        System.out.println("Puerta abierta.");
    }
    
}
