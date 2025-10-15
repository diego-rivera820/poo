public class El_Comienzo {

    // Atributos de la clase
    private String nombre;
    private String apellido;
    private int edad;
    private int cedula;
    private double peso;

    // Constructor de la clase
    public El_Comienzo(String nombre, String apellido, int edad, int cedula, double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.peso = peso;
    }
//el metodo toString sirve para visualizar los objetos
public String toString(){
    return "El_Comienzo [Nombre: " + nombre + " Apellido: " + apellido + " Edad: " + edad + " Cedula: " + cedula + " Peso: " + peso + "]";
}

}
