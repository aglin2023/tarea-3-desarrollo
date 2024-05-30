package logica;

import java.awt.*;

/**
 * clase que representa una de las distintas bebidas, subclase de Bebida
 */
public class CocaCola extends Bebida {
    /**
     * constructor de CocaCola, no devuelve nada
     */
    public CocaCola(int h) {
        super(h);
    }

    @Override
    public void paintComponent(Graphics g, int x, int y) {

    }

    /**
     * metodo que devuelve un string que representa el nombre de la bebida
     */
    public String consumido() {
        return "CocaCola";
    }
}
