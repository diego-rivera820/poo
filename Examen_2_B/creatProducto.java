package Examen_2_B;

public class creatProducto {
    
    // Atributos privados
    private String codigo;
    private String descripcion;
    private int cantidad = 0;
    private double precioUnitario = 0.0;

    // Constructor vacío (valores por defecto)
    public creatProducto() {
        this.codigo = "0000";
        this.descripcion = "Sin descripcion";
        this.cantidad = 0;
        this.precioUnitario = 0.0;
    }

    // Constructor con parámetros
    public creatProducto(String codigo, String descripcion, int cantidad, double precioUnitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        // Se usan los setters para aplicar las validaciones
        setCantidad(cantidad);
        setPrecioUnitario(precioUnitario);
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    // Setters

    // No requiere validación estricta, pero se evita un valor vacío
    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty()) {
            this.codigo = codigo;
        } else {
            System.out.println("Advertencia: código vacío. Se mantiene el valor anterior.");
        }
    }

    // Si la descripción está vacía, se asigna una por defecto
    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.isEmpty()) {
            this.descripcion = descripcion;
        } else {
            this.descripcion = "Sin descripcion";
        }
    }

    // Validación: la cantidad no puede ser negativa
    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("Error: la cantidad no puede ser negativa.");
        }
    }

    // Validación: el precio no puede ser negativo
    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario >= 0) {
            this.precioUnitario = precioUnitario;
        } else {
            System.out.println("Error: el precio unitario no puede ser negativo.");
        }
    }

    // Calcula el subtotal
    public double subtotal() {
        return this.cantidad * this.precioUnitario;
    }

    // Calcula el total con descuento sin modificar el objeto
    public double totalConDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            System.out.println("Porcentaje inválido. Retornando subtotal sin descuento.");
            return subtotal();
        }
        double descuento = (porcentaje / 100.0) * subtotal();
        return subtotal() - descuento;
    }

    // Incrementa la cantidad de productos de forma segura
    public void incrementarCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
            System.out.println("Cantidad incrementada. Nueva cantidad: " + this.cantidad);
        } else {
            System.out.println("Cantidad inválida para incrementar.");
        }
    }

    // aplica descuento e impuesto sobre el subtotal completo
    public double calcularPrecioFinal(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            System.out.println("Porcentaje de descuento inválido. Se usará 0%.");
            porcentajeDescuento = 0;
        }

        // Descuento aplicado al subtotal
        double precioConDescuento = subtotal() - (subtotal() * porcentajeDescuento / 100);

        // Impuesto del 8% aplicado al precio con descuento
        double impuesto = precioConDescuento * 0.08;

        // Total final con impuesto
        double precioFinal = precioConDescuento + impuesto;

        return precioFinal;
    }

    // Representación en texto del objeto
    @Override
    public String toString() {
        return "creatProducto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
