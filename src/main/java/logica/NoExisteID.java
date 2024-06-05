package logica;

/**
 * Excepción lanzada cuando se intenta buscar un ID que no existe.
 */
public class NoExisteID extends Exception {
    /**
     * Constructor que toma un mensaje de error como parámetro.
     *
     * @param mensaje Mensaje de error que describe la excepción.
     */
    public NoExisteID(String mensaje) {
        super(mensaje);
    }
}

