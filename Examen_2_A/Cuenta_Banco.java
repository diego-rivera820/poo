package Examen_2_A;

public class Cuenta_Banco {

    private String titular;
    private String numeroCuenta;
    private double saldo;

    // Constructor vacío (valores por defecto)
    public Cuenta_Banco() {
        this.titular = "Desconocido";
        this.numeroCuenta = "000000000";
        this.saldo = 0.0;
    }

    // Constructor con parámetros (con validaciones)
    public Cuenta_Banco(String titular, String numeroCuenta, double saldo) {
        if (numeroCuenta == null || !numeroCuenta.matches("\\d{9}")) {
            throw new IllegalArgumentException("Número de cuenta inválido. Debe contener exactamente 9 dígitos.");
        }
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del titular no puede estar vacío.");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }

        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    // Getters
    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setters con validaciones

    public void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("Error: el nombre del titular no puede estar vacío.");
        }
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta != null && numeroCuenta.matches("\\d{9}")) {
            this.numeroCuenta = numeroCuenta;
        } else {
            System.out.println("Error: número de cuenta inválido. Debe contener exactamente 9 dígitos.");
        }
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Error: el saldo no puede ser negativo.");
        }
    }

    // Métodos de negocio
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Cantidad inválida para depósito.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && saldo - cantidad >= -50) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Cantidad inválida para retiro o saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta_Banco{" +
                "titular='" + titular + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}


    
    

    