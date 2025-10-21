package TallerHerencia;

public class DemoTransporte {

    public static void main(String[] args) {
        
        Transporte T1 = new Bus(40, 3200);
        Transporte T2 = new Taxi("ABC-123");
        Transporte T3 = new BicicletaElectrica(80);

        T1.mover();
        T2.mover();
        T3.mover();

    }
    
}
