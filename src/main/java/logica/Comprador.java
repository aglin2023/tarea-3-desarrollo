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
     * constructor que utiliza de parametros monedas, la lista de productos y el expendedor
     *
     * @throws PagoIncorrectoException   puede lanzar esta excepcion si se paga con una moneda con valor menor a 0
     * @throws PagoInsuficienteException puede lanzar esta excepcion si se paga con una moneda de valor menor al producto
     * @throws NoHayProductoException    puede lanzar esta excepcion si no hay producto disponible en el deposito al comprar
     */
    public Comprador(ArrayList<Moneda> m){
        bolsillo = m;
    }
    public boolean ComprobarSolicitud(int ID,Expendedor e) throws Exception{
        ProductList tipoProducto = ComprobarID(ID);
        ArrayList<Moneda> pago = ComprobarDinero(tipoProducto);
        if(pago == null)
            throw new PagoInsuficienteException("Falta Dinero");

        Comprar(pago,tipoProducto,e);
        return true;
    }
    ProductList ComprobarID(int ID) throws Exception{
        for (ProductList p:ProductList.values()) {
            if(p.getID() == ID)
                return p;
        }
        throw new NoExisteID("No existe el ID: " +ID);
    }

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
