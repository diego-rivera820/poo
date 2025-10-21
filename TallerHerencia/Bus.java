package TallerHerencia;

public class Bus extends Transporte {
    
    private double Tarifa;


    public Bus (int Capacidad, double Tarifa) {

        super ("bus", Capacidad);
        this.Tarifa = Tarifa;
    }

    @Override
    public void mover() {
        System.out.println("El bus esta avanzando  por su  ruta urbana.");
    }
    

}
