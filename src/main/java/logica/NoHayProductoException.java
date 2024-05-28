package logica;

/**
 * clase que representa una excepcion que se lanza cuando no hay un producto disponible al comprar
 * subclase de Exception
 */
public class NoHayProductoException extends Exception {
    /**
     * constructor de la excepcion, utiliza un String
     *
     * @param mensaje mensaje que describe la excepcion
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}
