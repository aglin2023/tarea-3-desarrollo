package logica;

/**
 * clase que representa uno de los distintos dulces, subclase de Dulce
 */
public class Super8 extends Dulce {
    /**
     * constructor de Super8, no devuelve nada
     */
    public Super8(int serie) {
        super(serie);
    }

    /**
     * metodo que devuelve un string que representa el nombre del dulce
     */
    public String consumido() {
        return "super8";
    }

    /**
     * metodo para regresar el precio del super 8
     * @return regresa el valor del producto
     */
    public static int getPrice() {
        return ProductList.SUPER8.getPrice().getValor();
    }

}
