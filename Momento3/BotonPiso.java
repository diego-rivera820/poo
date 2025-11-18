package Momento3;

// implementacion de la clase BotonPiso que hereda de Boton
public class BotonPiso extends Boton {

    private Direccion direccion;

    // constructor
    public BotonPiso (int piso, Direccion direccion){
        super(piso);
        this.direccion = direccion;
    }
    
    // getter para la direccion
    public Direccion getDireccion(){
        return direccion;
    }
   
}
