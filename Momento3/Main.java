package Momento3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String edificio = "Torre centinela";
        Display.bienvenida(edificio);

        Elevador elevador = new Elevador(
                500.0, // peso maximo
                3.0, // ancho interior
                2.5, // alto interior
                2.5 // largo interior

        );

        SistemaControl sistema = new SistemaControl(5, elevador);

        double anchoMaxObs = 3.0;
        double altoMaxObs = 3.0;

        boolean salir = false;
        while (!salir) {
            Display.mostrarEstado(sistema);
            System.out.println("Opciones:");
            System.out.println("1) Añadir peso");
            System.out.println("2) quitar peso");
            System.out.println("3) Presionar boton interno (cabina)");
            System.out.println("4) Presionar boton de piso (Subir/Bajar)");
            System.out.println("5) Mantener puertas abiertas");
            System.out.println("6) Activar emergencia");
            System.out.println("7) resetear emergencia");
            System.out.println("8) Mover elevador");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese peso (kg) a subir: ");
                    double p1 = scanner.nextDouble();
                    elevador.subirPeso(p1);
                    break;
                case 2:
                    System.out.println("Ingrese peso (kg) a quitar: ");
                    double p2 = scanner.nextDouble();
                    elevador.bajarPeso(p2);
                    break;
                case 3:
                    System.out.println("Ingrese piso destino (1-5): ");
                    int pisoDestino = scanner.nextInt();
                    elevador.presionarBotonCabina(pisoDestino);
                    break;
                case 4:
                    System.out.println("ingrese piso para llamar (1-5): ");
                    int pisoLlamar = scanner.nextInt();
                    System.out.println("¿Subir (1) o bajar (2)?: ");
                    int dir = scanner.nextInt();
                    BotonPiso boton;
                    if (dir == 1) {
                        boton = sistema.getPiso(pisoLlamar).getBotonSubir();
                    } else {
                        boton = sistema.getPiso(pisoLlamar).getBotonBajar();
                    }
                    if (boton != null) {
                        sistema.getElevador().solicitarDesdePiso(boton);
                    } else {
                        System.out.println("Boton no valido para esa direccion en ese piso.");
                    }
                    break;
                case 5:
                    elevador.mantenerPuertasAbiertas();
                    break;
                case 6:
                    elevador.activarEmergencia();
                    break;
                case 7:
                    elevador.resetearEmergencia();
                    break;
                case 8:
                    System.out.println("¿Objeto ostructor? (s/n): ");
                    boolean tiene = scanner.nextBoolean();
                    double anchoO = 0, altoO = 0;
                    if (tiene) {
                        System.out.println("Ancho del objeto (m): ");
                        anchoO = scanner.nextDouble();
                        System.out.println("alto del objeto (m): ");
                        altoO = scanner.nextDouble();

                    }

                    elevador.mover(anchoO, altoO, anchoMaxObs, altoMaxObs);
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");

            }

        }

        scanner.close();
    }

}
