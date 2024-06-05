package visual;

import logica.LogicaDigitos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel que contiene los botones numéricos y de control para la interfaz de ingreso de dígitos.
 */
public class PanelDigitos extends JPanel {

    private final int widthSize;
    private final int heightSize;
    private final int margen = 20;

    private final JLabel textLabel;
    private final JPanelComprador panelComprador;
    private ArrayList<JButton> botones;
    private final LogicaDigitos logica;

    /**
     * Constructor del panel de dígitos.
     *
     * @param pCom El panel del comprador al que pertenece este panel de dígitos.
     * @param wS   Ancho del panel.
     * @param hS   Alto del panel.
     */
    public PanelDigitos(JPanelComprador pCom, int wS, int hS) {
        setBackground(Color.gray);
        widthSize = wS;
        heightSize = hS;

        textLabel = new JLabel("", JLabel.LEFT);
        panelComprador = pCom;
        this.setLayout(null);

        logica = new LogicaDigitos(textLabel, this);
        createBotones(margen, margen * 4, 12);
    }

    /**
     * Crea los botones numéricos y de control en el panel.
     *
     * @param x    Coordenada X de inicio de los botones.
     * @param y    Coordenada Y de inicio de los botones.
     * @param size Cantidad total de botones.
     */
    public void createBotones(int x, int y, int size) {
        botones = new ArrayList<>();

        int yGridCount = 0;
        int xGridCount = 0;
        for (int i = 0; i < size; i++) {

            String buttonLabel = "" + i;

            int width = (widthSize - margen * 2 - 4) / 3;
            int height = width;

            if (i == 0)
                xGridCount = 1;
            if (i == 10) {
                xGridCount = 0;
                yGridCount = 0;
                buttonLabel = "<-";
            }
            if (i == 11) {
                xGridCount = 2;
                yGridCount = 0;
                buttonLabel = "OK";
            }

            JButton b = new JButton(buttonLabel);

            b.setBounds(x + (xGridCount) * width, y + (-yGridCount) * height + height * (size / 3 - 1), width, height);
            b.setActionCommand("" + i);
            b.addActionListener(logica);

            if (i % 3 == 0) {
                yGridCount++;
                xGridCount = 0;
            } else
                xGridCount++;

            botones.add(b);

            this.add(b);
        }
    }

    /**
     * Obtiene el panel del comprador asociado a este panel de dígitos.
     *
     * @return El panel del comprador.
     */
    public JPanelComprador getPanelComprador() {
        return panelComprador;
    }

    /**
     * Método para dibujar los elementos del panel de dígitos.
     *
     * @param g Contexto gráfico utilizado para dibujar.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(margen - 2, margen, widthSize - 2 * margen, margen * 2);

        textLabel.setBounds(0, 20, widthSize, margen * 2 - 5);
        textLabel.setForeground(Color.GREEN);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(textLabel);
    }
}
