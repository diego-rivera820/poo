package TallerHerencia;

public class BicicletaElectrica extends Transporte {

    private int nivelBateria;

    public BicicletaElectrica(int nivelBateria) {

        super ("BicicletaElectrica", 1 );
        this.nivelBateria = nivelBateria;

    }

    @Override
    public void mover(){
        System.out.println("La bicicleta avanza por el carril de la ciclovia");
    }

    
}
