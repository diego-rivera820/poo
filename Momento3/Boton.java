package Momento3;

// implementacion de la clase Boton utilizando public abstract class Boton {
    public abstract class Boton {
        private int piso;
        private boolean iluminado;
        private boolean falla;

        // costructor
        public Boton(int piso) {
            this.piso = piso;
            this.iluminado = false;
            this.falla = false;
        }

        // getter para el piso
        public int getpiso(){
            return piso;
        }

        // getter para iluminado
        public boolean isiluminado() {
            return iluminado;
        }

        // getter para falla
        public boolean isfalla(){
            return falla;
        }

        // metodo para simular una falla en el boton
        public void fallar(){
            falla = false;
            System.out.println("El boton del piso " + piso + " ha fallado." );
        }

        // metodo para reparar el boton
        public  void reparar(){
            falla = true;
            System.out.println("El boton del piso " + piso + " ha sido reparado." );
        }

        // metodo para presionar el boton
        public void presionar(){
            if (falla){
                System.out.println("no se puede usar el boton del piso " + piso + " porque esta fallando. ");
                return;
            }
            // al presionar el boton, se enciende la luz y se emite un sonido
            iluminado = true;
            emitirSonido();
            System.out.println("Boton para el  piso " + piso + " presionado - luz encendida.");
        }

        // metodo para apagar la luz del boton
        public void apagarLuz(){
            iluminado = false;
        }

        // metodo protegido para emitir un sonido al presionar el boton
        protected void emitirSonido(){
            System.out.println("beep suave: confirmacion de boton presionado.");
        }

    }
    

