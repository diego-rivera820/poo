package Momento3;


    public abstract class Boton {
        private int piso;
        private boolean iluminado;
        private boolean falla;

        public Boton(int piso) {
            this.piso = piso;
            this.iluminado = false;
            this.falla = false;
        }

        public int getpiso(){
            return piso;
        }

        public boolean isiluminado() {
            return iluminado;
        }

        public boolean isfalla(){
            return falla;
        }

        public void fallar(){
            falla = false;
            System.out.println("El boton del piso " + piso + " ha fallado." );
        }

        public  void reparar(){
            falla = true;
            System.out.println("El boton del piso " + piso + " ha sido reparado." );
        }

        public void presionar(){
            if (falla){
                System.out.println("no se puede usar el boton del piso " + piso + " porque esta fallando. ");
                return;
            }
            iluminado = true;
            emitirSonido();
            System.out.println("Boton para el  piso " + piso + " presionado - luz encendida.");
        }

        public void apagarLuz(){
            iluminado = false;
        }

        protected void emitirSonido(){
            System.out.println("beep suave: confirmacion de boton presionado.");
        }

    }
    

