package TallerHerencia;

public class Taxi extends Transporte{

    private String Placa;

    public Taxi (String Placa ) {

        super("Taxi", 4);
        this.Placa = Placa;

    }

    @Override
    public void mover() {
        System.out.println("El taxi recoge a un pasajero y arranca a su destino");
    }
    
}
