package Momento3;

// implementacion de import java.util.*; para que funcione la lista
import java.util.*;

// implementacion de la clase SistemaControl
public class SistemaControl {

private  Elevador elevador;
private List<Piso> pisos;

    // constructor
    public SistemaControl(int numPisos, Elevador elevador){
        this.elevador = elevador;
        pisos = new ArrayList<>();
        for (int i = 1; i <= numPisos; i++){
            pisos.add(new Piso(i, numPisos));
        }
    }

    // getter para obtener un piso por su número
    public Piso getPiso(int numero){
        return pisos.get(numero - 1);
    }

    // getter para obtener el elevador
    public Elevador getElevador(){
        return elevador;
    }
    
}
