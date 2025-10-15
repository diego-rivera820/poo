package Libro;

class Biblioteca {
    
    public static void main ( String [] args ) {

        // Creacion del primer objeto ( Instancia )
        System.out.println (" --- Anadiendo ’Cien Anos de Soledad ’ ---");
        Libro libro1 = new Libro (" Cien Anos de Soledad ", " Gabriel Garcia Marquez ", 1967 , 496);

        // Uso del toString () y un getter
        System . out . println (" Datos iniciales : " + libro1 ) ;
        System . out . println (" Autor : " + libro1.getAutor() ) ;

         // Uso de un setter y un metodo de negocio
         libro1 . setAnioPublicacion (1970) ;
         libro1 . prestar () ;

        // Verificar estado con toString ()
        System . out . println (" Estado final : " + libro1 );

        // Creacion de un segundo objeto
        System . out . println ("\n--- Anadiendo ’El Senor de los Anillos ’ ---") ;
        Libro libro2 = new Libro ("El Senor de los Anillos ", "J.R.R. Tolkien ", 1954 ,1216) ;
         libro2 . prestar () ; 
   }
}


