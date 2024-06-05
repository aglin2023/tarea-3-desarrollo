package logica;

/**
 * clase que representa un excepcion que se lanza cuando no existe la id ingresada
 */
public class NoExisteID extends Exception{

    /**
     * constructor de la clase
     * @param mensaje mensaje de error de la excepcion
     */
    public NoExisteID(String mensaje) {
        super(mensaje);
    }
}
