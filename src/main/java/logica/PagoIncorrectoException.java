package logica;

/**
 * clase que representa una excepcion que se lanza cuando se entrega una moneda null
 * subclase de Exception
 */

public class PagoIncorrectoException extends Exception {
    /**
     * constructor de la excepcion, utiliza un String
     *
     * @param mensaje mensaje que describe la excepcion
     */
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}


