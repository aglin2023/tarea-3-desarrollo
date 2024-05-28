package logica;

/**
 * Enumeracion que representa una lista de productos con sus precios
 */

public enum ProductList {
    /**
     * Representa el producto COCA con precio de 1000
     */
    COCA(1000),
    /**
     * Representa el producto SPRITE con precio de 300
     */
    SPRITE(300),
    /**
     * Representa el producto FANTA con precio de 1200
     */
    FANTA(1200),
    /**
     * Representa el producto SNICKERS con precio de 100
     */
    SNICKERS(100),
    /**
     * Representa el producto SUPER8 con precio de 100
     */
    SUPER8(100);

    /**
     * constructor privado que asigna un precio a un producto
     *
     * @param price precio del producto, entero constante
     */
    private ProductList(final int price) {
        m = new Moneda() {
            /**@return regresa el valor del precio de un producto */
            public int getValor() {
                return price;
            }
        };
    }

    /**
     * variable que representa una moneda
     */
    private Moneda m;

    /**
     * metodo que regresa una moneda con el precio del producto
     *
     * @return una moneda con el precio de un producto
     */
    public Moneda getPrice() {
        return m;
    }
}
