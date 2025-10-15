package Examen_2_A;

public class Banco {

    //se crea el main para probar la clase Cuenta_Banco
    public static void main(String[] args) {
        Cuenta_Banco cuenta1 = new Cuenta_Banco("Juan Perez", "123456789", 1000.0);
        Cuenta_Banco cuenta2 = new Cuenta_Banco("Maria Gomez", "987654321", 500.0);
        
        //se imprimen las cuentas
        System.out.println(cuenta1);
        System.out.println(cuenta2);

        cuenta1.depositar(200.0);
        cuenta2.retirar(550.0);
        
        System.out.println(cuenta1);
        System.out.println(cuenta2);
    }
    
}
