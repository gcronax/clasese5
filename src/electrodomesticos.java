import java.lang.reflect.Array;
import java.util.ArrayList;

class electrodomesticos {
    public static final int precio_default = 100;
    public static final String color_default = "blanco";
    public static final char consumo_default = 'F';
    int precio;
    String color;
    char consumo;


    public electrodomesticos() {
        this.precio = precio_default;
        this.color = color_default;
        this.consumo = consumo_default;
        precioFinal();
    }

    public electrodomesticos(int precio, String color) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo_default;
        comprobarLetraConsumo(consumo);
        precioFinal();
    }

    public electrodomesticos(int precio, String color, char consumo) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        comprobarColor(color);
        comprobarLetraConsumo(consumo);
        precioFinal();
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
        this.color = color;
        comprobarColor(color);
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
        comprobarLetraConsumo(consumo);
    }

    public void setPrecio(int precio) {
        this.precio = precio;
        precioFinal();
    }

    public void comprobarLetraConsumo(char letra) {

        if (letra != 'A' && letra != 'F' && letra != 'B' && letra != 'D' && letra != 'E') {
            consumo = consumo_default;
        }

    }

    public void comprobarColor(String color) {
        if (color != "blanco" && color != "negro" && color != "gris") {
            color = color_default;
        }

    }

    public void precioFinal() {

        switch (this.consumo) {
            case 'A':
                precio = precio + 60;
                break;
            case 'B':
                precio = precio + 50;
                break;
            case 'C':
                precio = precio + 40;
                break;
            case 'D':
                precio = precio + 30;
                break;
            case 'E':
                precio = precio + 20;
                break;
            case 'F':
                precio = precio + 10;
                break;
            default:
                break;

        }
    }

    @Override
    public String toString() {
        return "electrodomesticos{" +
                "precio=" + precio +
                ", color='" + color + '\'' +
                ", consumo=" + consumo +
                '}';
    }
}
class microondas extends electrodomesticos {

    public static final int n_programas = 4;
    int aux_n;

    public microondas() {
        super();
        aux_n = n_programas;
    }

    public microondas(int precio, String color) {
        super(precio,color);
        aux_n = n_programas;
    }

    public microondas(int num, int precio, String color, char consumo) {
        super(precio, color, consumo);
        aux_n = num;
    }

    public int getAux_n() {
        return aux_n;
    }

    public void setAux_n(int aux_n) {
        this.aux_n = aux_n;
    }

    @Override
    public void precioFinal() {
        super.precioFinal();
        if (aux_n > 5) {
            super.setPrecio(precio + 40);
        }
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "microndas{" +
                ", aux_n=" + aux_n +
                '}';
    }

}


 class lavavajillas extends electrodomesticos{

        public static final int n_programas=12;
        
        int aux_n;

        public lavavajillas(){
            super();
            aux_n=n_programas;
        }
        public lavavajillas(int precio, String color){
            super(precio,color);
            aux_n=n_programas;
        }
        public lavavajillas(int num, int precio, String color, char consumo){
            super(precio,color,consumo);
            aux_n=num;
        }

        public int getAux_n() {
            return aux_n;
        }

        public void setAux_n(int aux_n) {
            this.aux_n = aux_n;
        }

        @Override
        public void precioFinal() {
            if (aux_n>12){
            } else if (aux_n<12) {
            }

        }

        @Override
        public String toString() {
            System.out.println(super.toString());
            return "lavavajillas{" +
                    ", aux_n=" + aux_n +
                    '}';
        }
        

    }
   

    class main{
        public static void main(String[] args) {

            electrodomesticos[] a = new electrodomesticos[10];
            
            for (int i = 1; i < 10; i++) {
                if(i<5){
                   a[i]=new lavavajillas(16,400,"negro",'F');
                }else{
                    a[i]=new microondas(16,400,"negro",'F');
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(a[i]);
            }
       

        }
    }





