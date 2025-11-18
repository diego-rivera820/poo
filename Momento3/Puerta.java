package Momento3;

// implementacion de la clase Puerta
public class Puerta {

    private boolean abierta;

    // constructor
    public Puerta() {
        abierta = true;
    }

    // getter para saber si la puerta está abierta
    public boolean isAbierta(){
        return abierta;
    }

    // metodo para cerrar la puerta considerando posibles objetos obstructores
    public boolean cerrar(double anchoObstaculo, double altoObstaculo, double anchoMax, double altoMax){
        
        // verificar si el objeto obstructor es demasiado grande
        if (anchoObstaculo > anchoMax || altoObstaculo > altoMax){
            System.out.printf("obstaculo (%.2fx%.2f) demasiado grande: la puerta no puede cerrarse.%n", anchoObstaculo, altoObstaculo);
            return false;
        }
    
        // cerrar la puerta si no hay obstaculos grandes que lleven los usuarios
        abierta = false;
        System.out.println("Puerta cerrada exitosamente.");
        return true;
    }

    // metodo para abrir la puerta
    public void abrir(){
        abierta = true;
        System.out.println("Puerta abierta.");
    }
    
}
