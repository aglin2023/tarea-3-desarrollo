package logica;

import java.awt.*;

/**
 * clase que representa uno de los distintos dulces, subclase de Dulce
 */
public class Snickers extends Dulce {
    /**
     * constructor de Snickers, no devuelve nada
     */
    public Snickers(int h) {
        super(h);
    }

    @Override
    public void paintComponent(Graphics g, int x, int y) {

    }

    /**
     * metodo que devuelve un string que representa el nombre del dulce
     */
    public String consumido() {
        return "snickers";
    }
}
