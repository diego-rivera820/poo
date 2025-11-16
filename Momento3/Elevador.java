package Momento3;

import java.util.*;

public class Elevador {

    private int pisoActual;
    private Direccion direccion;
    private double pesoActual;
    private final double pesoMaximo;

    private double anchoInterior, altoInterior, largoInterior;

    private Puerta puerta; 
    private Emergencia emergencia;
    private BotonCabina[] botonesCabina;

    private List<BotonPiso> solicitudesSubir;
    private List<BotonPiso> solicitudesBajar;

    private Random random; // para simular fallas

    public Elevador(double pesoMaximo, double anchoInterior, double altoInterior, double largoInterior) {

        this.pesoMaximo = pesoMaximo;
        this.anchoInterior = anchoInterior;
        this.altoInterior = altoInterior;
        this.largoInterior = largoInterior;

        this.pisoActual = 1;
        this.direccion = Direccion.INACTIVO;
        this.pesoActual = 0;

        this.puerta = new Puerta();
        this.emergencia = new Emergencia();

        this.botonesCabina = new BotonCabina[5]; // Suponiendo un edificio de 5 pisos
        for (int i = 0; i < 5; i++) {
            this.botonesCabina[i] = new BotonCabina(i + 1);
        }

        this.solicitudesSubir = new ArrayList<>();
        this.solicitudesBajar = new ArrayList<>();

        this.random = new Random();
    }

    public double getPesoMaximo(){
        return pesoMaximo;
    }
    
    public int getPisoActual(){
        return pisoActual;
    }

    public double getPesoActual(){
        return pesoActual;
    }

    public boolean emergenciaActiva(){
        return emergencia.isActivada();
    }

    public void presionarBotonCabina(int piso){
        BotonCabina boton = botonesCabina[piso - 1];
        //simulamos que el boton puede fallar aleatoriamente 
        if (random.nextDouble() < 0.1) { // 10% de probabilidad de falla
           boton.fallar();
        }

        boton.presionar();
        solicitudesSubir.add(new BotonPiso(piso, Direccion.SUBIR)); // Lo agregue como solicitud
        System.out.println("Solicitud de de cabina registrada para ir al piso" + piso);
   }

   public void solicitarDesdePiso(BotonPiso boton){
        if (random.nextDouble() < 0.05) { // 5% de probabilidad de falla
            boton.fallar();
        }
   
        boton.presionar();
        if (boton.getDireccion() == Direccion.SUBIR) {
            solicitudesSubir.add(boton);
            
        } else {
            solicitudesBajar.add(boton);
        }
        System.out.println("Solicitud de piso" + boton.getpiso() + " para " + boton.getDireccion());
 
    } 
    
    public void subirPeso(double peso){
        pesoActual += peso;
        System.out.printf("Se ha subido %, .2f kg. Peso total: %,.2f kg.%n", peso, pesoActual);
    }

    public void bajarPeso(double peso){
        pesoActual =Math.max(0, pesoActual - peso); 
        System.out.printf("Se ha bajado %, .2f kg. Peso total: %,.2f kg.%n", peso, pesoActual);
    }

    public void activarEmergencia(){
        emergencia.activar(puerta);
    }

    public void resetearEmergencia(){
        emergencia.resetear();
    }

    public void mantenerPuertasAbiertas(){
        puerta.abrir();
        System.out.println("Manteniendo puertas abiertas...");
    }

    public void mover(double anchoObs, double altoObs, double anchoMaxObs, double altoMaxObs){
        if (emergencia.isActivada()){
            System.out.println("No se puede mover: la emergencia esta activa.");
            return;
        }
        
        if (pesoActual >= pesoMaximo){
            System.out.printf("Peso al limite (%.2f kg) o exedido (max = %.2f kg) - movimiento denegado.%n", pesoActual, pesoMaximo);
            return;
        }

        boolean cerrado = puerta.cerrar(anchoObs, altoObs, anchoMaxObs, altoMaxObs);
        if (!cerrado){
            return;
        }

        // Optimizacion de direccion, primero se atiende las solicitudes en la dirreccion actual
        procesarSolicitudes();

        if (direccion == Direccion.INACTIVO){
            System.out.println("No hay solicitudes pendientes, el elevador permanece en el piso" + pisoActual);

        } else {
            //Decidimos un destino segun la lista de solicitudes 
            BotonPiso destinoBoton = escogerDestino();
            if (destinoBoton == null) {
                System.out.println("No hay destino valido en la direccion actual.");

            } else {
                int destino = destinoBoton.getpiso();
                System.out.printf("Moviendo de piso %d a %d...%n", pisoActual, destino);
                pisoActual = destino;
                System.out.println("Elevador ha llegado a piso" + pisoActual);
                destinoBoton.apagarLuz();
            }
        }

        puerta.abrir();
        direccion = Direccion.INACTIVO;
        

    }

    private void procesarSolicitudes(){
        //Si hay solicitudes para subir y estamos en una direccion adecuada
        if (!solicitudesSubir.isEmpty()){
            direccion = Direccion.SUBIR;
        
        } else if (!solicitudesBajar.isEmpty()){
            direccion = Direccion.BAJAR;
        
        } else {
            direccion = Direccion.INACTIVO;
        }

        System.out.println("Direccion decidida:" + direccion);
    }

    private BotonPiso escogerDestino(){
        BotonPiso elegido = null;
        if (direccion == Direccion.SUBIR){
            int minPiso = Integer.MAX_VALUE;
            for (BotonPiso b : solicitudesSubir){
                if (b.getpiso() >= pisoActual && b.getpiso() < minPiso){
                    minPiso = b.getpiso();
                    elegido = b;
                }
            }
        } else if (direccion == Direccion.BAJAR){
            int maxPiso = Integer.MIN_VALUE;
            for (BotonPiso b : solicitudesBajar){
                if (b.getpiso() <= pisoActual && b.getpiso() > maxPiso){
                    maxPiso = b.getpiso();
                    elegido = b;
                }
            }
            solicitudesBajar.remove(elegido);
        }
        return elegido;
    }
}
