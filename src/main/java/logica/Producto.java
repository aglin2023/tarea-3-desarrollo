package logica;

/**
 * clase de tipo abstract que le otorga las caracteristicas a los productos
 */
public abstract class Producto {
    private int serie;
    /**
     * constructor de Producto, no devuelve nada
     */
    public Producto(int serie) {
        this.serie = serie;
    }

    /**
     * método que permite que las subclases puedan utilizar ese método
     */
    public abstract String consumido();

    public abstract int getSerie();
}
