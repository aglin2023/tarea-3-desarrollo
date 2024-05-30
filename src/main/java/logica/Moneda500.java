package logica;

import java.awt.*;

/**
 * clase que representa una de las distintas monedas, es una subclase de Moneda
 */
public class Moneda500 extends Moneda {
    /**
     * metodo de tipo int que entrega el valor que posee esta moneda
     *
     * @return int valor de moneda
     */
    public int getValor() {
        return 500;
    }
    public void paintComponent(Graphics g, int x, int y){}
}
