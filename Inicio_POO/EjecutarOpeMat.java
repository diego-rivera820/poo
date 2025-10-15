import java.util.Scanner;

public class EjecutarOpeMat {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el primer numero entero...");
        int n1 = sc.nextInt();
        System.out.println("Digite el segundo numero");
        int n2 = sc.nextInt();


        // Crear el objeto:es una llave para acceder a los atributos y a los metodos de la clase 
        OperacionMatematica objOpe = new OperacionMatematica(n1,n2);

        //crear valores por teclado
       // num1 = objOpe.LeerEnteros();
        //num2 = objOpe.LeerEnteros();

        //Acceder al metodo sumar 
        System.out.println("La suma es: " + objOpe.sumar());

        
         //Acceder al metodo restar
        System.out.println("La resta es: " + objOpe.restar());


         //Acceder al metodo multiplicacion 
        System.out.println("La multiplicacion es: " + objOpe.multiplicar());


         //Acceder al metodo division
        System.out.println("La division es: " + objOpe.dividir());


        //Acceder al metodo raiz
        System.out.println("La raiz cuadrada de; " + n1 +" es:" + objOpe.raizA());
        System.out.println("La raiz cuadrada de: " + n2 +" es:" + objOpe.raizB());


        //Acceder al metodo potencia 
        System.out.println("La potencia de: "+ n1 +" a la: " + n2 +" es:" + objOpe.potencia());



        //acceder al metodo modulo
        System.out.println("El modulo es: " + objOpe.modulo());


        //acceder al metodo maxnum
        System.out.println("El maximo entre los dos numeros es: " + objOpe.maxnum());


        //Acceder al metodo minnum
        System.out.println("El minimo entre los dos numeros es: " + objOpe.minnum());

        // Cerrar el Scanner para evitar fugas de recursos
        sc.close();

    }

}