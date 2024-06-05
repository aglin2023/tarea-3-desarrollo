package logica;

import java.awt.*;

/**
 * Enumeracion que representa una lista de productos con sus precios
 */

public enum ProductList {
    /**
     * Representa el producto COCA con precio de 1000
     */
    COCA(1000, 1001),
    /**
     * Representa el producto SPRITE con precio de 300
     */
    SPRITE(300, 1002),
    /**
     * Representa el producto FANTA con precio de 1200
     */
    FANTA(1200,1003),
    /**
     * Representa el producto SNICKERS con precio de 100
     */
    SNICKERS(100,1004),
    /**
     * Representa el producto SUPER8 con precio de 100
     */
    SUPER8(100, 1005);

    /**
     * constructor privado que asigna un precio a un producto
     *
     * @param price precio del producto, entero constante
     */
    final int serie;

    ProductList(final int price, int serie) {
        m = new Moneda() {
            /**@return regresa el valor del precio de un producto */
            public int getValor() {
                return price;
            }

            @Override
            public void paintComponent(Graphics g, int x, int y) {

            }
        };
        this.serie = serie;
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

    public int getSerie() {
        return serie;
    }
}
