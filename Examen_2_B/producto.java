package Examen_2_B;

public class producto {
    
    //se crea el metodo main para probar la clase creatProducto
    public static void main(String[] args) {
        creatProducto producto1 = new creatProducto();
        creatProducto producto2 = new creatProducto("1234", "Laptop", 5, 750.0);

        //se imprimen los datos del producto1
        System.out.println("Producto 1:");
        System.out.println("Codigo: " + producto1.getCodigo());
        System.out.println("Descripcion: " + producto1.getDescripcion());
        System.out.println("Cantidad: " + producto1.getCantidad());
        System.out.println("Precio Unitario: " + producto1.getPrecioUnitario());
        System.out.println("Precio Total: " + (producto1.getCantidad() * producto1.getPrecioUnitario()));

        //se imprimen los datos del producto2
        System.out.println("\nProducto 2:");
        System.out.println("Código: " + producto2.getCodigo());
        System.out.println("Descripción: " + producto2.getDescripcion());
        System.out.println("Cantidad: " + producto2.getCantidad());
        System.out.println("Precio unitario: " + producto2.getPrecioUnitario());
        double total2 = producto2.subtotal();
        System.out.println("Total sin descuento: " + total2);
        System.out.println("Total con 10% descuento: " + producto2.totalConDescuento(10.0));
    }
}


