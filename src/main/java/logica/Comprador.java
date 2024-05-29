package logica;

/**
 * clase que realiza la compra usando las clases Moneda, la lista de productos y el expendedor
 */
public class Comprador {

    /**
     * variable que permite mostrar en un string el producto consumido
     */
    private String sonido;
    /**
     * variable que representa el vuelto total que se entrega con la compra
     */
    private int vueltoTotal;

    /**
     * constructor que utiliza de parametros monedas, la lista de productos y el expendedor
     *
     * @param m moneda a utilizar
     * @param c lista de productos
     * @param e expendedor
     * @throws PagoIncorrectoException   puede lanzar esta excepcion si se paga con una moneda con valor menor a 0
     * @throws PagoInsuficienteException puede lanzar esta excepcion si se paga con una moneda de valor menor al producto
     * @throws NoHayProductoException    puede lanzar esta excepcion si no hay producto disponible en el deposito al comprar
     */
    public Comprador(Moneda m, ProductList c, Expendedor e) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        Moneda aux = e.getVuelto();
        while (aux != null) {
            vueltoTotal += aux.getValor();
            aux = e.getVuelto();
        }
    }

    /**
     * metodo que devuelve el vuelto total en valor entero
     *
     * @return entero Vuelto total
     */
    public int cuantoVuelto() {

        return vueltoTotal;
    }

    /**
     * metodo que devuelve que producto se consumió
     *
     * @return String que representa el producto consumido
     */
    public String QueConsumiste() {

        return sonido;

    }
}
