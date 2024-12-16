class electrodomesticos {
    protected final static int precio_default = 100;
    protected final static String color_default = "blanco";
    protected final static char consumo_default = 'F';
    protected int precio;
    protected String color;
    protected char consumo;


    public electrodomesticos() {
        this.precio = precio_default;
        this.color = color_default;
        this.consumo = consumo_default;

    }

    public electrodomesticos(int precio, String color) {
        this.precio = precio;
        this.color = comprobarColor(color);
        this.consumo = consumo_default;
    }

    public electrodomesticos(int precio, String color, char consumo) {
        this.precio = precio;
        this.color = comprobarColor(color);
        this.consumo = comprobarLetraConsumo(consumo);
    }

    public String getColor() {
        return color;
    }

    public char getConsumo() {
        return consumo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setColor(String color) {
        this.color = comprobarColor(color);
        ;
    }

    public void setConsumo(char consumo) {
        this.consumo = comprobarLetraConsumo(consumo);
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public char comprobarLetraConsumo(char letra) {

        char[] aux = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char n : aux) {
            if (Character.toUpperCase(letra) == n) {
                return n;
            }
        }
        return consumo_default;

    }

    public String comprobarColor(String color) {
        if (color != "blanco" && color != "negro" && color != "gris") {
            return color_default;
        } else {return color;}

    }

    public int precioFinal() {
        int n=0;
        switch (consumo) {
            case 'A':
                n = 60;
                break;
            case 'B':
                n = 50;
                break;
            case 'C':
                n = 40;
                break;
            case 'D':
                n = 30;
                break;
            case 'E':
                n = 20;
                break;
            case 'F':
                n = 10;
                break;
        }
        return precio+n;
    }

    @Override
    public String toString() {
        return "Color: " + color + "\nConsumo energético: " + consumo + "\nPrecio final: " + precioFinal();
    }
}

class microondas extends electrodomesticos {

    public final static int n_programas = 4;
    private int aux_n;

    public microondas() {
        super();
        this.aux_n = n_programas;
    }

    public microondas(int precio, String color) {
        this.precio=precio;
        this.color=super.comprobarColor(color);
        this.consumo=consumo_default;
        this.aux_n= n_programas;
    }

    public microondas(int num, int precio, String color, char consumo) {
        super(precio, color, consumo);
        this.aux_n= n_programas;
    }

    public int getAux_n() {
        return aux_n;
    }

    public void setAux_n(int aux_n) {
        this.aux_n = aux_n;
    }

    @Override
    public int precioFinal() {
        int n=super.precioFinal();
        if (aux_n > 5) {
            n=n + 40;
        }
        return n;
    }

    @Override
    public String toString() {
        String s1 = "\n**********************";
        s1+= "\nINFORMACIÓN DEL MICROONDAS";
        s1+= "\n**********************\n";
        String s2 = "\nProgramas: " + aux_n;

        return s1 + super.toString() + s2;
    }

}


 class lavavajillas extends electrodomesticos{

        public static final int n_programas=12;
        
        private int aux_nl;

        public lavavajillas(){
            super();
            this.aux_nl =n_programas;
        }
        public lavavajillas(int precio, String color){
            this.precio=precio;
            this.color=super.comprobarColor(color);
            this.consumo=consumo_default;
            this.aux_nl =n_programas;
        }
        public lavavajillas(int num, int precio, String color, char consumo){
            super(precio,color,consumo);
            this.aux_nl =num;
        }

        public int getAux_nl() {
            return aux_nl;
        }

        public void setAux_nl(int aux_nl) {
            this.aux_nl = aux_nl;
        }

        @Override
        public int precioFinal(){
            int n=super.precioFinal();
    
            if (aux_nl>12){
                n+=40;
            } else if (aux_nl<12){
                n+=-10;
            }
            return n;
        }

        @Override
        public String toString() {
            String s1 = "\n**********************";
            s1+= "\nINFORMACIÓN DEL LAVAVAJILLAS";
            s1+= "\n**********************\n";
            String s2 = "\nServicios: " + aux_nl;
    
            return s1 + super.toString() + s2;
        }
        

    }
   

    class main{
        public static void main(String[] args) {

            electrodomesticos[] a = new electrodomesticos[10];
            
            for (int i = 0; i < 10; i++) {
                if(i<5){
                   a[i]=new lavavajillas(13,0,"nero",'O');
                }else{
                    a[i]=new microondas(6,0,"negro",'A');
                }


            }
            for (int i = 0; i < 10; i++) { 
                System.out.println(i+1);
                System.out.println(a[i]);

            }
       

        }
    }





