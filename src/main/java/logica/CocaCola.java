package logica;

/**
 * Clase que representa una de las distintas bebidas, subclase de Bebida
 */
public class CocaCola extends Bebida {
    /**
     * constructor de CocaCola, no devuelve nada
     */
    public CocaCola(int serie) {
        super(serie);
    }

    /**
     * metodo que devuelve un string que representa el nombre de la bebida
     */
    public String consumido() {
        return "Coca";
    }

    /**
     * metodo estatico que regresa el precio del producto cocacola
     * @return precio de la cocacola
     */
    public static int getPrice() {
        return ProductList.COCA.getPrice().getValor();
    }

}
