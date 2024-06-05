package logica;

/**
 * clase que representa una de las distintas bebidas, subclase de Bebida
 */
public class Sprite extends Bebida {
    /**
     * constructor de sprite, no devuelve nada
     */
    public Sprite(int serie) {
        super(serie);
    }

    /**
     * metodo que devuelve un string que representa el nombre de la bebida
     */
    public String consumido() {
        return "sprite";
    }

    /**
     * metodo para regresar el precio de la sprite
     * @return regresa el valor del producto
     */
    public static int getPrice() {
        return ProductList.SPRITE.getPrice().getValor();
    }

}
