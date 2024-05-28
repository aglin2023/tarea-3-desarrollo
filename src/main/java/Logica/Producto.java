/**clase de tipo abstract que le otorga las caracteristicas a los productos */
public abstract class Producto {
    /**constructor de Producto, no devuelve nada */
    public Producto(){}

    /**método que permite que las subclases puedan utilizar ese método */
    public abstract String consumido();
}
