package Clase14;

public class Demo {

    public static void main(String[] args) {
        // Crear un cliente
        Cliente c1 = new Cliente();
        c1.cedula = "123456";
        c1.nombre = "Juan Pérez";

        // Crear una cámara
        Camara cam1 = new Camara();
        cam1.numero = 1;
        cam1.marca = "Canon";
        cam1.modelo = "EOS R5";

        // Crear una foto
        Foto f1 = new Foto();
        f1.Fichero = "foto1.jpg";

        // Crear una impresión
        Impresion imp1 = new Impresion();
        imp1.numero = 2;
        imp1.color = "Color";
        imp1.Foto = new Foto[]{f1};

        // Crear un pedido con esos productos
        Pedido p1 = new Pedido();
        p1.cliente = c1;
        p1.fecha = "03/11/2025";
        p1.numeroTarjetaCredito = 987654321;
        p1.producto = new Producto[]{cam1, imp1};

        // Mostrar datos básicos
        System.out.println("Cliente: " + p1.cliente.nombre);
        System.out.println("Pedido fecha: " + p1.fecha);
        System.out.println("Productos en el pedido:");

        for (Producto prod : p1.producto) {
            if (prod instanceof Camara) {
                Camara cam = (Camara) prod;
                System.out.println("- Cámara " + cam.marca + " " + cam.modelo);
            } else if (prod instanceof Impresion) {
                Impresion imp = (Impresion) prod;
                System.out.println("- Impresión en " + imp.color);
                for (Foto foto : imp.Foto) {
                    foto.print();
                }
            }
        }
    }
}


