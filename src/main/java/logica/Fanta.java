package logica;

/**
 * clase que representa una de las distintas bebidas, subclase de Bebida
 */
public class Fanta extends Bebida {

    /**
     * constructor de Fanta, no devuelve nada
     */
    public Fanta(int serie) {
        super(serie);
    }

    /**
     * metodo que devuelve un string que representa el nombre de la bebida
     */
    public String consumido() {
        return "fanta";
    }


    public static int getPrice() {
        return ProductList.FANTA.getPrice().getValor();
    }

    @Override
    public int getSerie() {
        return ProductList.FANTA.serie;
    }
}
