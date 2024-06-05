package visual;

import logica.Moneda;
import logica.Moneda500;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase que representa un botón que agrega monedas de 500.
 */
public class boton500 extends JButton {
    private final PanelMoneda p;
    private final JLabel valorLabel;

    /**
     * Constructor del botón que agrega monedas de 500.
     *
     * @param a      el texto del botón
     * @param s      la etiqueta que muestra el valor total
     * @param p      el panel de las monedas
     * @param monedas la lista de monedas
     */
    public boton500(String a, JLabel s, PanelMoneda p, ArrayList<Moneda> monedas) {
        super(a);
        valorLabel = s;
        this.p = p;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monedas.size() >= 40)
                    return;
                Moneda500 m500 = new Moneda500();
                ingresarMoneda(m500);
                monedas.add(m500);
                p.repaint();
            }
        });
    }

    /**
     * Ingresa una moneda al panel y actualiza el valor total.
     *
     * @param moneda la moneda a ingresar
     */
    private void ingresarMoneda(Moneda moneda) {
        int aux = p.getTotalValor() + moneda.getValor();
        p.setValor(aux);
        valorLabel.setText("Valor total: " + aux);
    }
}
