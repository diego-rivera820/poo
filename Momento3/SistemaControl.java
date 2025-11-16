package Momento3;

import java.util.*;

public class SistemaControl {

private  Elevador elevador;
private List<Piso> pisos;

    public SistemaControl(int numPisos, Elevador elevador){
        this.elevador = elevador;
        pisos = new ArrayList<>();
        for (int i = 1; i <= numPisos; i++){
            pisos.add(new Piso(i, numPisos));
        }
    }

    public Piso getPiso(int numero){
        return pisos.get(numero - 1);
    }

    public Elevador getElevador(){
        return elevador;
    }
    
}
