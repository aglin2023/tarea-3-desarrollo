package logica;

/**
 * clase que representa una excepcion que se lanza cuando se entrega una moneda de un valor menor al producto
 * subclase de Exception
 */
public class PagoInsuficienteException extends Exception {
    /**
     * constructor de la excepcion, utiliza un String
     *
     * @param mensaje mensaje que describe la excepcion
     */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
