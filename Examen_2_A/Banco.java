package Examen_2_A;

public class Banco {

  //se crea el main para probar la clase cuentaBancaria
    public static void main(String[] args) {
        cuentaBancaria cuenta1 = new cuentaBancaria("Juan Perez", "123456789", 1000.0);
        cuentaBancaria cuenta2 = new cuentaBancaria("Maria Gomez", "987654321", 500.0);
        
        //se imprimen las cuentas
        System.out.println(cuenta1);
        System.out.println(cuenta2);

        cuenta1.depositar(200.0);
        cuenta2.retirar(550.0);
        
        System.out.println(cuenta1);
        System.out.println(cuenta2);
    }
}
