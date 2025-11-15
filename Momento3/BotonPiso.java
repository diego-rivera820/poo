package Momento3;

public class BotonPiso extends Boton {

    private Direccion direccion;

    public BotonPiso (int piso, Direccion direccion){
        super(piso);
        this.direccion = direccion;
    }

    public Direccion getDireccion(){
        return direccion;
    }
   
}
