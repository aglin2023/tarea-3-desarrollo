package visual;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase que maneja los eventos de acción para el monedero del expendedor.
 */
public class ActionListenerMonederoExpendedor implements ActionListener {
    private final JPanelExpendedor panelExpendedor;
    private final Expendedor expendedor;
    private final PanelMoneda panelMoneda;

    /**
     * Constructor para inicializar el ActionListenerMonederoExpendedor.
     *
     * @param expendedor     la instancia del expendedor
     * @param panelExpendedor el panel del expendedor
     * @param panelMoneda    el panel de las monedas
     */
    public ActionListenerMonederoExpendedor(Expendedor expendedor, JPanelExpendedor panelExpendedor, PanelMoneda panelMoneda) {
        this.expendedor = expendedor;
        this.panelExpendedor = panelExpendedor;
        this.panelMoneda = panelMoneda;
    }

    /**
     * Maneja el evento de acción cuando se activa.
     *
     * @param e el evento de acción
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame nuevaVentana = new JFrame("Monedero Expendedor");
        nuevaVentana.setSize(700, 750);
        nuevaVentana.setResizable(false);
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            ArrayList monedasExpendedor = expendedor.getMonederoExpendedor().getArrayList();
            JPanel panel = new JPanel();
            panel.setLayout(null);

            dibujadorMonedas dibujadorMonedas = new dibujadorMonedas(monedasExpendedor, 10, 10);
            dibujadorMonedas.setBounds(0, 0, 700, 750);
            dibujadorMonedas.setBackground(Color.LIGHT_GRAY);
            panel.add(dibujadorMonedas);
            panelMoneda.repaint();

            nuevaVentana.getContentPane().add(panel);
            nuevaVentana.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
