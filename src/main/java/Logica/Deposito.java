import java.util.ArrayList;

/**clase que representa un deposito de tipo generico para almacenar objetos de cualquier tipo
 * @param <T> un objeto de cualquier tipo para almacenar */
public class    Deposito<T>{

    private ArrayList<T> arrayList;

    /**constructor que inicia un nuevo deposito */
    public Deposito(){
        arrayList = new ArrayList<T>();
    }

    /**metodo de tipo void que permite que un producto se almacene en un deposito
     * @param producto el objeto que se va a almacenar dentro de un deposito */
    public void addObject(T producto) {
        arrayList.add(producto);
    }

    /**metodo que obtiene y borra el un objeto del deposito si este aun no está vacio
     * @return el objeto que está primero actualmente en el deposito, si está vacio, devuelve null */
    public T getObject() {
        if (arrayList.size() != 0)
            return arrayList.remove(0);
        return null;
    }
}
