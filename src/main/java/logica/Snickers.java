package logica;

/**
 * clase que representa uno de los distintos dulces, subclase de Dulce
 */
public class Snickers extends Dulce {
    /**
     * constructor de Snickers, no devuelve nada
     */
    public Snickers(int serie) {
        super(serie);
    }

    /**
     * metodo que devuelve un string que representa el nombre del dulce
     */
    public String consumido() {
        return "snickers";
    }


    public static int getPrice() {
        return ProductList.SNICKERS.getPrice().getValor();
    }

    @Override
    public int getSerie() {
        return ProductList.SNICKERS.serie;
    }
}
