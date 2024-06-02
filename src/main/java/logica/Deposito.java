package logica;

import java.awt.*;
import java.util.ArrayList;

/**
 * clase que representa un deposito de tipo generico para almacenar objetos de cualquier tipo
 *
 * @param <T> un objeto de cualquier tipo para almacenar
 */
public class Deposito<T > {

    private ArrayList<T> deposito;

    /**
     * constructor que inicia un nuevo deposito
     */
    public Deposito() {
        deposito = new ArrayList<T>();
    }

    /**
     * metodo de tipo void que permite que un producto se almacene en un deposito
     *
     * @param producto el objeto que se va a almacenar dentro de un deposito
     */
    public void addObject(T producto) {
        deposito.add(producto);
    }

    /**
     * metodo que obtiene y borra el un objeto del deposito si este aun no está vacio
     *
     * @return el objeto que está primero actualmente en el deposito, si está vacio, devuelve null
     */
    public T getObject() {
        if (deposito.size() != 0)
            return deposito.remove(0);
        return null;
    }

    public ArrayList<T> getArrayList() {
        return deposito;
    }

    public boolean tieneProductos() {
        return !deposito.isEmpty();
    }
}
