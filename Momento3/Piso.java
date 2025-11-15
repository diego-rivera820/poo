package Momento3;

public class Piso {
    private int numero;
    private BotonPiso botonSubir;
    private BotonPiso botonBajar;

    public Piso(int numero, maxPisos){
        this.numero = numero;
        if (numero < maxPisos){
            botonSubir = new BotonPiso(numero, Direccion.SUBIR);
        }
        if (numero > 1){
            botonBajar = new BotonPiso(numero, Direccion.BAJAR);
        }

    }

    public int getNumero(){
        return numero;
    }

    public BotonPiso getBotonSubir(){
        return botonSubir;
    }

    public BotonPiso getBotonBajar(){
        return botonBajar;
    }
    
}
