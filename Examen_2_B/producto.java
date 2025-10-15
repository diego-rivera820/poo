package Examen_2_B;

public class producto {

    // Se crea el método main para probar la clase creatProducto
    public static void main(String[] args) {
        creatProducto producto1 = new creatProducto();
        creatProducto producto2 = new creatProducto("1234", "Laptop", 5, 750.0);

        // Se imprimen los datos del producto1
        System.out.println("Producto 1:");
        System.out.println("Código: " + producto1.getCodigo());
        System.out.println("Descripción: " + producto1.getDescripcion());
        System.out.println("Cantidad: " + producto1.getCantidad());
        System.out.println("Precio Unitario: " + producto1.getPrecioUnitario());
        System.out.println("Precio Total: " + (producto1.getCantidad() * producto1.getPrecioUnitario()));

        // Se imprimen los datos del producto2
        System.out.println("\nProducto 2:");
        System.out.println("Código: " + producto2.getCodigo());
        System.out.println("Descripción: " + producto2.getDescripcion());
        System.out.println("Cantidad: " + producto2.getCantidad());
        System.out.println("Precio unitario: " + producto2.getPrecioUnitario());

        // Calcular y mostrar totales con descuento e IVA
        double subtotal = producto2.subtotal();
        double descuento = 10.0; // Porcentaje de descuento
        double precioConDescuento = producto2.totalConDescuento(descuento);
        double iva = precioConDescuento * 0.08;
        double totalFinal = precioConDescuento + iva;

        System.out.println("Subtotal sin descuento: $" + subtotal);
        System.out.println("Descuento aplicado (" + descuento + "%): $" + (subtotal * descuento / 100));
        System.out.println("Subtotal con descuento: $" + precioConDescuento);
        System.out.println("IVA (8%): $" + iva);
        System.out.println("Total final con IVA: $" + totalFinal);
    }
}
