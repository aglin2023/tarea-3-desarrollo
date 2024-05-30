package logica;

import java.awt.*;
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

    private Producto productoComprado;
    private Deposito<Moneda> monederoExpendedor;
    private ArrayList<Deposito> depositos;

    /**
     * constructor de expendedor en el que se llena los depositos de cada producto con un int
     *
     * @param llenaDeposito valor que representa cuanto de cada producto se llena cada deposito
     */
    public Expendedor(int llenaDeposito) {
        monVu = new Deposito<Moneda>();
        monederoExpendedor = new Deposito<Moneda>();


//        coca = new Deposito<Producto>();
//        sprite = new Deposito<Producto>();
//        fanta = new Deposito<Producto>();
//        snickers = new Deposito<Producto>();
//        super8 = new Deposito<Producto>();

        for(int i = 0; i < 5; i++){
            depositos.add(new Deposito());
        }

        coca = depositos.get(0);
        sprite = depositos.get(1);
        fanta = depositos.get(2);
        snickers = depositos.get(3);
        super8 = depositos.get(4);


        for (int i = 0; i < llenaDeposito; i++) {
            coca.addObject(new CocaCola(i));
            sprite.addObject(new Sprite(i));
            fanta.addObject(new Fanta(i));
            snickers.addObject(new Snickers(i));
            super8.addObject(new Super8(i));
        }
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
    public void comprar(Moneda m, ProductList l) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        if (m == null) {
            throw new PagoIncorrectoException("No ingresaste moneda");
        }

        monederoExpendedor.addObject(m);
        int vuelto = m.compareTo(l.getPrice());


        if (vuelto < 0) {
            monVu.addObject(m);
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
            monVu.addObject(m);
            throw new NoHayProductoException("No hay " + l);
        }


        int cant_monedas100 = vuelto / 100;
        for (int i = 0; i < cant_monedas100; i++) {
            monVu.addObject(new Moneda100());
        }

        productoComprado = p;
    }

    /**
     * metodo que regresa el vuelto al comprar un producto
     *
     * @return valor del vuelto de la compra
     */
    public Moneda getVuelto() {
        return monVu.getObject();
    }

    public void paintComponent(Graphics g){
        int x = 10;
        int y = 10;
        for(Deposito deposito : depositos) {
            deposito.paintComponent(g,x,y);
            y += 100;
        }
    }

}
