package visual;

import logica.Moneda;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.ArrayList;

/**
 * clase que permite dibujar las monedas en la interfaz grafica
 */
public class dibujadorMonedas extends JPanel {

    /**
     * lista de las monedas que se van a dibujar
     */
    private ArrayList<Moneda> m;

    /**
     * constructor de la clase
     *
     * @param m lista de monedas
     */
    public dibujadorMonedas(ArrayList<Moneda> m) {
        this.m = m;
    }

    /**
     * imagen para la moneda de 100
     */
    Image moneda1;
    /**
     * imagen para la moneda de 500
     */
    Image moneda2;
    /**
     * imagen para el billete de 1000
     */
    Image moneda3;
    /**
     * limite vertical para dibujar las monedas
     */
    int limiteY = 1;
    /**
     * limite horizontal para dibujar las monedas
     */
    int limiteX = 1;

    /**
     * metodo para dibujar las monedas
     *
     * @param g contexto grafico
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offsetX = 80;
        int offsetY = 250;

        try {
            moneda1 = ImageIO.read(new File("src/main/java/visual/Models/100-anverso.png"));
            moneda2 = ImageIO.read(new File("src/main/java/visual/Models/moneda de 500.png"));
            moneda3 = ImageIO.read(new File("src/main/java/visual/Models/1000-anverso.jpg"));
            for (int i = 0; i <= m.size(); i++) {

                if (m.get(i).getValor() == 100) {
                    g.drawImage(moneda1, (limiteX * 50) + offsetX, (100 * limiteY) + offsetY, 50, 50, new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                            return false;
                        }
                    });
                }
                if (m.get(i).getValor() == 500) {
                    g.drawImage(moneda2, limiteX * 50 + offsetX, 100 * limiteY + offsetY, 50, 50, new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                            return false;
                        }
                    });
                }
                if (m.get(i).getValor() == 1000) {
                    g.drawImage(moneda3, limiteX * 50 + offsetX, 100 * limiteY + offsetY, 50, 50, new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                            return false;
                        }
                    });
                }
                if ((i + 1) % 10 == 0) {
                    limiteY += 1;
                    limiteX = 1;

                } else {
                    limiteX++;
                }
            }
        } catch (Exception e) {
        }

    }
}
