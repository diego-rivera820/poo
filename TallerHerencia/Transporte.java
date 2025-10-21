package TallerHerencia;

public class Transporte {
    
    protected String Tipo;
    protected int Capacidad;

    public Transporte (String tipo, int Capacidad ) {

        this.Tipo = tipo;
        this.Capacidad = Capacidad;

    }

    public void mover() {

        System.out.println("El transporte se esta moviendo");

    }

    public void mostrarInfo() {

        System.out.println("tipo:" + Tipo +  "capacidad:" + Capacidad);

    }

    

}
