package logica;

import java.util.ArrayList;

/**
 * clase que realiza la compra usando las clases Moneda, la lista de productos y el expendedor
 */
public class Comprador {

    private ArrayList<Moneda> bolsillo;
    /**
     * variable que permite mostrar en un string el producto consumido
     */
    private String sonido;
    /**
     * variable que representa el vuelto total que se entrega con la compra
     */
    private int vueltoTotal;

    /**
     * constructor que utiliza la lista de monedas
     */
    public Comprador(ArrayList<Moneda> m){
        bolsillo = m;
    }

    /**
     * metodo que comprueba la solicitud de la compra
     * @param ID id del producto
     * @param e expendedor
     * @return true si se realiza la compra correctamente
     * @throws Exception Puede lanzar varias excepciones relacionadas con el pago y la disponibilidad del producto.
     */
    public boolean ComprobarSolicitud(int ID,Expendedor e) throws Exception{
        ProductList tipoProducto = ComprobarID(ID);
        ArrayList<Moneda> pago = ComprobarDinero(tipoProducto);
        if(pago == null)
            throw new PagoInsuficienteException("Falta Dinero");

        Comprar(pago,tipoProducto,e);
        return true;
    }

    /**
     * metodo para comprobar la id del producto
     * @param ID id del producto
     * @return el tipo de producto que corresponde a la id
     * @throws Exception lanzar mensaje si no existe la id
     */
    ProductList ComprobarID(int ID) throws Exception{
        for (ProductList p:ProductList.values()) {
            if(p.getID() == ID)
                return p;
        }
        throw new NoExisteID("No existe el ID: " +ID);
    }

    /**
     * metodo que comprueba si el dinero que se tiene permite compprar el producto
     * @param p tipo de producto que se quiere comprar
     * @return lista de monedas para pagar el producto
     */
    ArrayList<Moneda> ComprobarDinero(ProductList p){
        ArrayList<Moneda> pago = new ArrayList<Moneda>();
        int precioProducto = p.getPrice().getValor();
        int sumMon = 0;

        for(Moneda m : bolsillo) {
            sumMon += m.getValor();
            pago.add(m);
            if(sumMon >= precioProducto){
                bolsillo.removeAll(pago);
                return pago;
            }
            else
                System.out.println(sumMon);
        }
        return null;
    }

    /**
     *metodo que realiza la compra del producto
     * @param m lista de monedas para pagar
     * @param c tipo de producto que se quiera comprar
     * @param e expendedor
     * @throws PagoIncorrectoException lanza un error si el pago es incorrecto
     * @throws PagoInsuficienteException lanza un error si el pago es insuficiente
     * @throws NoHayProductoException lanza un error si no hay producto para comprar
     */
    public void Comprar(ArrayList<Moneda> m, ProductList c, Expendedor e) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        e.comprarProducto(m,c,bolsillo);
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
