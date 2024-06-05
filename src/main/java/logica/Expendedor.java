package logica;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Clase que representa el funcionamiento de un expendedor de productos.
 */
public class Expendedor {

    /**
     * Variable que representa el monto del vuelto de la compra del producto.
     */
    private Deposito<Moneda> monVu;

    /**
     * Variable que hace referencia a un depósito de coca.
     */
    private Deposito<Producto> coca;

    /**
     * Variable que hace referencia a un depósito de sprite.
     */
    private Deposito<Producto> sprite;

    /**
     * Variable que hace referencia a un depósito de fanta.
     */
    private Deposito<Producto> fanta;

    /**
     * Variable que hace referencia a un depósito de snickers.
     */
    private Deposito<Producto> snickers;

    /**
     * Variable que hace referencia a un depósito de super8.
     */
    private Deposito<Producto> super8;

    /**
     * Depósito unitario para el producto comprado.
     */
    private Deposito depositoUnitarioProductoComprado;

    /**
     * Depósito de monedas.
     */
    private Deposito<Moneda> monederoExpendedor;

    /**
     * Producto comprado.
     */
    private Producto productoComprado;

    /**
     * Cantidad para llenar el depósito.
     */
    private static int llenaDeposito;

    /**
     * Constructor de Expendedor en el que se llenan los depósitos de cada producto.
     *
     * @param llenaDeposito valor que representa cuánto de cada producto se llena cada depósito
     */
    public Expendedor(int llenaDeposito) {
        monVu = new Deposito<Moneda>();
        monederoExpendedor = new Deposito<Moneda>();
        this.depositoUnitarioProductoComprado = new Deposito<Producto>();
        this.llenaDeposito = llenaDeposito;

        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();

        for (int i = 0; i < llenaDeposito; i++) {
            coca.addObject(new CocaCola(100 + i));
            sprite.addObject(new Sprite(200 + i));
            fanta.addObject(new Fanta(300 + i));
            snickers.addObject(new Snickers(400 + i));
            super8.addObject(new Super8(500 + i));
        }
    }

    /**
     * Obtiene la cantidad para llenar el depósito.
     *
     * @return la cantidad para llenar el depósito
     */
    public int getLlenaDeposito() {
        return llenaDeposito;
    }

    /**
     * Obtiene el monedero del expendedor.
     *
     * @return el depósito de monedas del expendedor
     */
    public Deposito getMonederoExpendedor() {
        return monederoExpendedor;
    }

    /**
     * Rellena los depósitos de productos si están vacíos.
     */
    public void rellenarDepositos() {
        if (coca.getArrayList().isEmpty()) {
            for (int i = 0; i < llenaDeposito; i++) {
                coca.addObject(new CocaCola(100 + i));
            }
        }
        if (sprite.getArrayList().isEmpty()) {
            for (int i = 0; i < llenaDeposito; i++) {
                sprite.addObject(new Sprite(200 + i));
            }
        }
        if (fanta.getArrayList().isEmpty()) {
            for (int i = 0; i < llenaDeposito; i++) {
                fanta.addObject(new Fanta(300 + i));
            }
        }
        if (super8.getArrayList().isEmpty()) {
            for (int i = 0; i < llenaDeposito; i++) {
                super8.addObject(new Super8(400 + i));
            }
        }
        if (snickers.getArrayList().isEmpty()) {
            for (int i = 0; i < llenaDeposito; i++) {
                snickers.addObject(new Snickers(500 + i));
            }
        }
    }

    /**
     * Obtiene el depósito correspondiente al tipo de producto.
     *
     * @param producto el tipo de producto
     * @return el depósito del producto
     */
    public Deposito<Producto> getDeposito(ProductList producto) {
        switch (producto) {
            case COCA:
                return coca;
            case SPRITE:
                return sprite;
            case FANTA:
                return fanta;
            case SNICKERS:
                return snickers;
            case SUPER8:
                return super8;
            default:
                throw new IllegalArgumentException("Producto no válido");
        }
    }

    /**
     * Obtiene el depósito unitario del producto comprado.
     *
     * @return el depósito unitario del producto comprado
     */
    public Deposito getDepositoUnitarioProductoComprado() {
        return depositoUnitarioProductoComprado;
    }

    /**
     * Método que permite la compra de un producto con monedas.
     *
     * @param m la lista de monedas ingresadas
     * @param l el producto que se quiere comprar
     * @param total la lista de monedas que se sumarán al total
     * @throws PagoInsuficienteException si el valor de las monedas no es suficiente para comprar el producto
     * @throws PagoIncorrectoException   si no se entrega una moneda o la moneda es null
     * @throws NoHayProductoException    si el producto que se quiere comprar no está disponible
     */
    public void comprarProducto(ArrayList<Moneda> m, ProductList l, ArrayList<Moneda> total) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        if (m == null) {
            throw new PagoIncorrectoException("No ingresaste moneda");
        }

        Producto p = null;

        if (l.equals(ProductList.COCA)) {
            p = coca.getObject();
        }
        if (l.equals(ProductList.SPRITE)) {
            p = sprite.getObject();
        }
        if (l.equals(ProductList.FANTA)) {
            p = fanta.getObject();
        }
        if (l.equals(ProductList.SNICKERS)) {
            p = snickers.getObject();
        }
        if (l.equals(ProductList.SUPER8)) {
            p = super8.getObject();
        }

        if (p == null) {
            for (int i = 0; i < m.size(); i++) {
                monVu.addObject(m.get(i));
                total.add(i, m.get(i));
            }
            throw new NoHayProductoException("No hay " + l);
        }

        int vuelto = 0;
        for (int i = 0; i < m.size(); i++) {
            monederoExpendedor.addObject(m.get(i));
            vuelto += m.get(i).getValor();
        }
        vuelto -= l.getPrice().getValor();

        if (vuelto < 0) {
            for (int i = 0; i < m.size(); i++) {
                monVu.addObject(m.get(i));
            }
            throw new PagoInsuficienteException("Le faltan: " + -1 * vuelto + " monedas");
        }

        int cant_monedas100 = vuelto / 100;
        for (int i = 0; i < cant_monedas100; i++) {
            Moneda aux = new Moneda100();
            monVu.addObject(aux);
            total.add(aux);
        }

        productoComprado = p;
        depositoUnitarioProductoComprado.addObject(productoComprado);
    }

    /**
     * Método que regresa el vuelto al comprar un producto.
     *
     * @return el valor del vuelto de la compra
     */
    public Moneda getVuelto() {
        return monVu.getObject();
    }
}
