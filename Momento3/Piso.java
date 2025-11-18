package Momento3;

// implementacion de la clase Piso
public class Piso {
    private int numero;
    private BotonPiso botonSubir;
    private BotonPiso botonBajar;

    // constructor
    public Piso(int numero, int maxPisos){
        this.numero = numero;
        if (numero < maxPisos){
            botonSubir = new BotonPiso(numero, Direccion.SUBIR);
        }
        // crear boton para bajar si no es el primer piso
        if (numero > 1){
            botonBajar = new BotonPiso(numero, Direccion.BAJAR);
        }

    }

    // getter para el número del piso
    public int getNumero(){
        return numero;
    }

    // getter para el boton de subir y bajar
    public BotonPiso getBotonSubir(){
        return botonSubir;
    }

    public BotonPiso getBotonBajar(){
        return botonBajar;
    }
    
}
