package Libro;

public class Libro {
    
    
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int numeroPaginas;
    private boolean prestado;

    public Libro(String titulo, String autor, int anioPublicacion, int numeroPaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.prestado = false;
        }

        public String getTitulo(){
            return titulo;

        }
        public String getAutor(){
            return autor;
        }
        public void setAnioPublicacion(int anio){
            if (anio <= 2025 && anio > 0) {
                this.anioPublicacion = anio;
            }else {
                System.out.println("Error: ano de publicacion invalido.");
            }
                
        }

        public boolean prestar() {
            if (!this.prestado) {
                this.prestado = true;
                System.out.println("El libro '" + this.titulo + "' ha sido prestado exitosamente.");
                return true;
            }else {
                System.out.println("El libro'" + this.titulo + "' ya esta prestado.");
               return false;
            }
        }

        @Override
        public String toString(){

            String estado = this.prestado ? "PRESTADO" : "DISPONIBLE";

            return "Libro [Titulo: " + titulo +
            ", Autor: " + autor +
            ", Ano: " + anioPublicacion +
            ", Paginas: " + numeroPaginas +
            ", Estado: " + estado + 
            "]"; 
        }
        
    }

