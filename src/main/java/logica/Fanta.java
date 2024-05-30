package logica;

import java.awt.*;

/**
 * clase que representa una de las distintas bebidas, subclase de Bebida
 */
public class Fanta extends Bebida {

    /**
     * constructor de Fanta, no devuelve nada
     */
    public Fanta(int h) {
    super(h);
    }

    @Override
    public void paintComponent(Graphics g, int x, int y) {

    }

    /**
     * metodo que devuelve un string que representa el nombre de la bebida
     */
    public String consumido() {
        return "fanta";
    }
}
