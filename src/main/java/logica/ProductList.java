package logica;

/**
 * Enumeración que representa una lista de productos con sus precios.
 */
public enum ProductList {
    /**
     * Representa el producto COCA con precio de 1000.
     */
    COCA(1000, 1001),
    /**
     * Representa el producto SPRITE con precio de 300.
     */
    SPRITE(300, 1002),
    /**
     * Representa el producto FANTA con precio de 1200.
     */
    FANTA(1200, 1003),
    /**
     * Representa el producto SNICKERS con precio de 100.
     */
    SNICKERS(100, 1004),
    /**
     * Representa el producto SUPER8 con precio de 100.
     */
    SUPER8(100, 1005);

    private final int ID;

    ProductList(final int price, int ID) {
        m = new Moneda() {
            /**
             * Obtiene el valor del precio del producto.
             *
             * @return Precio del producto.
             */
            public int getValor() {
                return price;
            }
        };
        this.ID = ID;
    }

    /** Variable que representa una moneda. */
    private final Moneda m;

    /**
     * Obtiene una moneda con el precio del producto.
     *
     * @return Moneda con el precio del producto.
     */
    public Moneda getPrice() {
        return m;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return Identificador del producto.
     */
    public int getID() {
        return ID;
    }
}
