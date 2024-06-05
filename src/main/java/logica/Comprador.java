package logica;

import java.util.ArrayList;

/**
 * Clase que representa al comprador y gestiona el proceso de compra.
 */
public class Comprador {

    private ArrayList<Moneda> bolsillo;
    /** Variable que representa el sonido del producto consumido. */
    private String sonido;
    /** Variable que representa el vuelto total que se entrega con la compra. */
    private int vueltoTotal;

    /**
     * Constructor de la clase Comprador.
     *
     * @param m Lista de monedas en el bolsillo del comprador.
     */
    public Comprador(ArrayList<Moneda> m){
        bolsillo = m;
    }

    /**
     * Verifica la solicitud de compra y procesa la transacción.
     *
     * @param ID Identificador del producto a comprar.
     * @param e Expendedor asociado.
     * @return true si la compra fue exitosa, de lo contrario false.
     * @throws Exception Excepción que puede ser lanzada durante el proceso de compra.
     */
    public boolean ComprobarSolicitud(int ID, Expendedor e) throws Exception{
        ProductList tipoProducto = ComprobarID(ID);
        ArrayList<Moneda> pago = ComprobarDinero(tipoProducto);
        if(pago == null)
            throw new PagoInsuficienteException("Falta Dinero");

        Comprar(pago, tipoProducto, e);
        return true;
    }

    /**
     * Comprueba si el ID del producto existe.
     *
     * @param ID Identificador del producto.
     * @return Tipo de producto.
     * @throws Exception Excepción lanzada si el ID no existe.
     */
    ProductList ComprobarID(int ID) throws Exception{
        for (ProductList p : ProductList.values()) {
            if(p.getID() == ID)
                return p;
        }
        throw new NoExisteID("No existe el ID: " +ID);
    }

    /**
     * Comprueba si hay suficiente dinero para comprar el producto.
     *
     * @param p Producto a comprar.
     * @return Lista de monedas para el pago si el dinero es suficiente, de lo contrario null.
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
     * Realiza la compra del producto.
     *
     * @param m Lista de monedas para el pago.
     * @param c Producto a comprar.
     * @param e Expendedor asociado.
     * @throws PagoIncorrectoException Excepción lanzada si el pago es incorrecto.
     * @throws PagoInsuficienteException Excepción lanzada si el pago es insuficiente.
     * @throws NoHayProductoException Excepción lanzada si no hay producto disponible.
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
     * Obtiene el vuelto total en valor entero.
     *
     * @return Vuelto total.
     */
    public int cuantoVuelto() {
        return vueltoTotal;
    }

    /**
     * Obtiene el sonido del producto consumido.
     *
     * @return String que representa el producto consumido.
     */
    public String QueConsumiste() {
        return sonido;
    }
}
