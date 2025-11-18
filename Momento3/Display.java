package Momento3;

public class Display {    //  aqui estaria el estado del elevador 
                          // que se actualizara mediante el uso al ejecutarlo
    public static void bienvenida(String nombre){
        System.out.println("======================================");
        System.out.println(" Bienvenido al edificio ¨" + nombre + "¨ ");
        System.out.println("======================================");
    }

    // metodo para mostrar el estado del elevador
    public static void mostrarEstado(SistemaControl sistema){ 
        Elevador e = sistema.getElevador(); 
        System.out.println("\n--- Estado del Elevador ---");
        System.out.println("Piso actual:" + e.getPisoActual()); 
        System.out.printf("Peso actual: %.2f kg / Máximo: %.2f kg%n", e.getPesoActual(), e.getPesoMaximo());
        System.out.println("Emergencia activada: " + e.emergenciaActiva());
        System.out.println("-----------------------------"); 
    }
    
}
