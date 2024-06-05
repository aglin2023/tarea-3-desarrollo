package logica;

/**
 * clase de tipo abstracto que le otorga las caractaristicas a las diferentes monedas
 * en la que se utilizo la interfaz Comparable<moneda> para utilizar el compareTo
 */
public abstract class Moneda implements Comparable<Moneda> {
    /**
     * constructor de moneda, no devuelve nada
     */
    public Moneda() {
    }

    /**
     * metodo abstracto que permite a las subclases de moneda utilizar este metodo de tipo int para obtener el valor
     */
    public abstract int getValor();

    /**
     * metodo que devuelve la diferencia de los valores de 2 objetos Moneda
     *
     * @param v valor de la moneda que quieres comprarar
     * @return int la diferencia de los valores
     */
    public int compareTo(Moneda v) {
        return this.getValor() - v.getValor();
    }
}
