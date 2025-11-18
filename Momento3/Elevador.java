package Momento3;

import java.util.*;

// implementacion de la clase Elevador
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

    // constructor
    public Elevador(double pesoMaximo, double anchoInterior, double altoInterior, double largoInterior) {
        this.pesoMaximo = pesoMaximo;
        this.anchoInterior = anchoInterior;
        this.altoInterior = altoInterior;
        this.largoInterior = largoInterior;

        // estado inicial del elevador
        this.pisoActual = 1;
        this.direccion = Direccion.INACTIVO;
        this.pesoActual = 0;

        // inicializacion de la puerta y emergencia
        this.puerta = new Puerta();
        this.emergencia = new Emergencia();

        // arreglo de botones de cabina
        this.botonesCabina = new BotonCabina[5];
        for (int i = 0; i < 5; i++) {
            this.botonesCabina[i] = new BotonCabina(i + 1);
        }

        // listas para solicitudes de subir y bajar
        this.solicitudesSubir = new ArrayList<>();
        this.solicitudesBajar = new ArrayList<>();

        // generador de numeros aleatorios para simular fallas
        this.random = new Random();
    }

    // getter para el peso máximo
    public double getPesoMaximo() {
        return pesoMaximo;
    }

    // getter para el piso actual
    public int getPisoActual() {
        return pisoActual;
    }
    // getter para el peso actual
    public double getPesoActual() {
        return pesoActual;
    }

    // metodo para verificar si la emergencia esta activa
    public boolean emergenciaActiva() {
        return emergencia.isActivada();
    }

    // metodo para presionar un boton de cabina
    public void presionarBotonCabina(int piso) {
        BotonCabina boton = botonesCabina[piso - 1];
        if (random.nextDouble() < 0.1) {
            boton.fallar();
        }
        boton.presionar();
        solicitudesSubir.add(new BotonPiso(piso, Direccion.SUBIR));
        System.out.println("Solicitud de cabina registrada para ir al piso " + piso);
    }

    // metodo para solicitar el elevador desde un piso
    public void solicitarDesdePiso(BotonPiso boton) {
        if (random.nextDouble() < 0.05) {
            boton.fallar();
        }
        boton.presionar();
        if (boton.getDireccion() == Direccion.SUBIR) {
            solicitudesSubir.add(boton);
        } else {
            solicitudesBajar.add(boton);
        }
        System.out.println("Solicitud en piso " + boton.getpiso() + " para " + boton.getDireccion());
    }

    // metodo para subir peso al elevador en caso  de llevar un objeto pesado
    public void subirPeso(double peso) {
        pesoActual += peso;
        System.out.printf("Se ha subido %.2f kg. Peso total: %.2f kg.%n", peso, pesoActual);
    }

    // metodo para bajar peso del elevador
    public void bajarPeso(double peso) {
        pesoActual = Math.max(0, pesoActual - peso);
        System.out.printf("Se ha bajado %.2f kg. Peso total: %.2f kg.%n", peso, pesoActual);
    }

    // metodo para activar la emergencia
    public void activarEmergencia() {
        emergencia.activar(puerta);
    }

    // metodo para resetear la emergencia
    public void resetearEmergencia() {
        emergencia.resetear();
    }

    // metodo para mantener las puertas abiertas
    public void mantenerPuertasAbiertas() {
        puerta.abrir();
        System.out.println("Manteniendo puertas abiertas...");
    }

    // metodo para mover el elevador
    public void mover(double anchoObs, double altoObs, double anchoMaxObs, double altoMaxObs) {
        if (emergencia.isActivada()) {
            System.out.println("No se puede mover: la emergencia está activa.");
            return;
        }

        // verificar peso
        if (pesoActual >= pesoMaximo) {
            System.out.printf("Peso al límite (%.2f kg) o excedido (máx = %.2f kg) - movimiento denegado.%n",
                    pesoActual, pesoMaximo);
            return;
        }

        // intentar cerrar puertas
        System.out.println("DEBUG: Intentando cerrar puertas...");
        boolean cerrado = puerta.cerrar(anchoObs, altoObs, anchoMaxObs, altoMaxObs);
        System.out.println("DEBUG: Resultado de cerrar = " + cerrado);
        if (!cerrado) {
            return;
        }

        // procesar solicitudes para determinar dirección
        System.out.println("DEBUG: Calculando dirección según solicitudes...");
        procesarSolicitudes();
        System.out.println("DEBUG: Dirección después de procesar solicitudes = " + direccion);

        // determinar destino basado en la dirección
        if (direccion == Direccion.INACTIVO) {
            System.out.println("No hay solicitudes pendientes, el elevador permanece en el piso " + pisoActual);
        } else {
            System.out.println("DEBUG: solicitudesSubir = " + solicitudesSubir);
            System.out.println("DEBUG: solicitudesBajar = " + solicitudesBajar);

            // escoger el siguiente destino
            BotonPiso destinoBoton = escogerDestino();
            System.out.println("DEBUG: Botón destino escogido = " + destinoBoton);
            if (destinoBoton == null) {
                System.out.println("No hay destino válido en la dirección actual.");
            } else {
                int destino = destinoBoton.getpiso();
                if (destino == pisoActual) {
                    System.out.println("Destino igual al piso actual. No se realiza movimiento.");
                } else {
                    System.out.printf("Moviendo del piso %d al piso %d...%n", pisoActual, destino);
                    pisoActual = destino;
                    System.out.println("DEBUG: pisoActual cambiado a " + pisoActual);
                    destinoBoton.apagarLuz();
                }
            }
        }

        // abrir puertas al llegar
        System.out.println("DEBUG: Abriendo puertas...");
        puerta.abrir();
        direccion = Direccion.INACTIVO;
        System.out.println("DEBUG: Dirección restablecida a INACTIVO.");
    }

    // metodo para procesar solicitudes y determinar la dirección
    private void procesarSolicitudes() {
        if (!solicitudesSubir.isEmpty()) {
            direccion = Direccion.SUBIR;
        } else if (!solicitudesBajar.isEmpty()) {
            direccion = Direccion.BAJAR;
        } else {
            direccion = Direccion.INACTIVO;
        }
        System.out.println("DEBUG: Dirección decidida = " + direccion);
    }

    // metodo para escoger el siguiente destino basado en la dirección
    private BotonPiso escogerDestino() {
        BotonPiso elegido = null;
        if (direccion == Direccion.SUBIR) {
            int minPisoMayor = Integer.MAX_VALUE;
            for (BotonPiso b : solicitudesSubir) {
                int p = b.getpiso();
                if (p > pisoActual && p < minPisoMayor) {
                    minPisoMayor = p;
                    elegido = b;
                }
            }
            // eliminar destino escogido de solicitudesSubir
            if (elegido != null) {
                solicitudesSubir.remove(elegido);
            }
            // si no hay destino mayor, buscar el menor
        } else if (direccion == Direccion.BAJAR) {
            int maxPisoMenor = Integer.MIN_VALUE;
            for (BotonPiso b : solicitudesBajar) {
                int p = b.getpiso();
                if (p < pisoActual && p > maxPisoMenor) {
                    maxPisoMenor = p;
                    elegido = b;
                }
            }
            if (elegido != null) {
                solicitudesBajar.remove(elegido);
            }
        }
        return elegido;
    }
}