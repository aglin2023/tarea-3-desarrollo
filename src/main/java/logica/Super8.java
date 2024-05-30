package logica;

import java.awt.*;

/**
 * clase que representa uno de los distintos dulces, subclase de Dulce
 */
public class Super8 extends Dulce {
    /**
     * constructor de Super8, no devuelve nada
     */
    public Super8(int h) {
        super(h);
    }

    @Override
    public void paintComponent(Graphics g, int x, int y) {

    }

    /**
     * metodo que devuelve un string que representa el nombre del dulce
     */
    public String consumido() {
        return "super 8";
    }
}
