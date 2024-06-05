package logica;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * clase que representa el funcionamiento de un expendedor de productos
 */
public class Expendedor {

    /**
     * variable que representa el monto del vuelto de la compra del producto
     */
    private Deposito<Moneda> monVu;

    /**
     * variable que hace referencia a un deposito de coca
     */
    private Deposito<Producto> coca;

    /**
     * variable que hace referencia a un deposito de sprite
     */
    private Deposito<Producto> sprite;

    /**
     * variable que hace referencia a un deposito de fanta
     */
    private Deposito<Producto> fanta;

    /**
     * variable que hace referencia a un deposito de snickers
     */
    private Deposito<Producto> snickers;

    /**
     * variable que hace referencia a un deposito de super8
     */
    private Deposito<Producto> super8;

    /**
     * Deposito unitario
     */
    private Deposito depositoUnitarioProductoComprado;
    /**
     * Deposito de monedas
     */
    private Deposito<Moneda> monederoExpendedor;
    /**
     * Producto comprado
     */
    private Producto productoComprado;
    private static int llenaDeposito;

    /**
     * constructor de expendedor en el que se llena los depositos de cada producto con un int
     *
     * @param llenaDeposito valor que representa cuanto de cada producto se llena cada deposito
     */
    public Expendedor(int llenaDeposito) {
        monVu = new Deposito<Moneda>();
        monederoExpendedor = new Deposito<Moneda>();
        this.depositoUnitarioProductoComprado = new Deposito<Producto>();
        this.llenaDeposito = llenaDeposito;

        //prueba
        productoComprado = new Snickers(106);
        depositoUnitarioProductoComprado.addObject(productoComprado);

        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();

        for (int i = 0; i < llenaDeposito; i++) {
            coca.addObject(new CocaCola(100 + i));
            sprite.addObject(new Sprite(200 + i));
            fanta.addObject(new Fanta(300 + i));
            // snickers.addObject(new Snickers(400 + i));
            super8.addObject(new Super8(500 + i));
        }

    }

    public int getLlenaDeposito() {
        return llenaDeposito;
    }

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

    public Deposito getDepositoUnitarioProductoComprado() {
        return depositoUnitarioProductoComprado;
    }


    /**
     * metodo que permite la compra de un producto con una moneda
     *
     * @param m la moneda ingresada
     * @param l el producto que se quiere comprar
     * @throws PagoInsuficienteException si el valor de la moneda no es suficiente para comprar el producto
     * @throws PagoIncorrectoException   si no se entrega una moneda o moneda es un null
     * @throws NoHayProductoException    si el producto que se quiere comprar, no está disponible
     */
    public void comprarProducto(ArrayList<Moneda> m, ProductList l) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        if (m == null) {
            throw new PagoIncorrectoException("No ingresaste moneda");
        }

        int vuelto = 0;
        for (int i = 0; i< m.size();i++) {
            monederoExpendedor.addObject(m.get(i));
            vuelto += m.get(i).getValor();
        }
        vuelto -= l.getPrice().getValor();

        if (vuelto < 0) {
            for (int i = 0; i< m.size();i++) {
                monVu.addObject(m.get(i));
            }
            throw new PagoInsuficienteException("Le faltan: " + -1 * vuelto + " monedas");
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
            for (int i = 0; i< m.size();i++) {
                monVu.addObject(m.get(i));
            }
            throw new NoHayProductoException("No hay " + l);
        }


        int cant_monedas100 = vuelto / 100;
        for (int i = 0; i < cant_monedas100; i++) {
            monVu.addObject(new Moneda100());
        }

        productoComprado = p;
        depositoUnitarioProductoComprado.addObject(productoComprado);

    }

    /**
     * metodo que regresa el vuelto al comprar un producto
     *
     * @return valor del vuelto de la compra
     */
    public Moneda getVuelto() {
        return monVu.getObject();
    }
}
