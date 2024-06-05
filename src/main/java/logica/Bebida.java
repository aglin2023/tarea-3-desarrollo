package logica;

/**
 * clase de tipo abstracto que le otorga las caracteristicas a las bebidas, es una subclase de Producto
 */
public abstract class Bebida extends Producto {
    /**
     * constructor de la clase
     * @param serie serie de la bebida
     */
    public Bebida(int serie) {
        super(serie);
    }


}
