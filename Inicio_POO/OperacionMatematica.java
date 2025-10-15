//import java.util.Scanner;

public class OperacionMatematica {

    //Atributos de la clase
    private int a;
    private int b;

    //cronstructor: Permite inicializar la clase 
    public OperacionMatematica (int a, int b){

        this.a = a;
        this.b = b;

    }

    // Metodos
    public int sumar(){
        return a + b;
    }

      public int restar(){
        return a - b;
}
public int multiplicar(){
        return a * b;
}

public double dividir(){
    double resultado;
    if (b == 0){
        resultado = 0.0;
    }else{        //double significa hacer una conversion de entero a real o viceversa (CAST)

        resultado = (double)a / (double)b;
    
    }return resultado;}

    public double raizA(){
        return Math.sqrt(a);
    }
    
    public double raizB(){
        return Math.sqrt(b);
    }

    public double potencia (){
        return Math.pow(a, b);
    }

    public double modulo(){
        return a % b;
    }

    public int maxnum(){
        return Math.max(a, b);
    }

    public int minnum(){
        return Math.min(a, b);
}


//metodo para recibir numeros emterospor teclado
//public int LeerEnteros(){
    //Scanner sc = new Scanner(System.in);
    //System.out.println("digite el numero entero...");
    //int n = sc.nextInt();
    //sc.close();
    //return n;

    /*
     * para numeros enteros nextint() -> ej: sc.nextint()
     * para numeros reales nextDouble() -> ej: sc.nextDouble()
     * para booleanos nextBoolean() -> ej: sc.nextDouble()
     * para cadenas (String) next() -> ej: sc.nextDouble()
     */
}

