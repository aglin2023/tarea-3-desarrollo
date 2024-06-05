package visual;

import logica.Moneda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Clase que representa un botón para borrar el valor total de las monedas ingresadas.
 */
public class botonBorrar extends JButton {
    private final JLabel valorLabel;
    private final PanelMoneda p;

    /**
     * Constructor del botón para borrar el valor total.
     *
     * @param a      el texto del botón
     * @param s      la etiqueta que muestra el valor total
     * @param p      el panel de las monedas
     * @param monedas la lista de monedas
     */
    public botonBorrar(String a, JLabel s, PanelMoneda p, ArrayList<Moneda> monedas) {
        super(a);
        this.p = p;
        valorLabel = s;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarTotal();
                p.repaint();
                monedas.clear();
            }
        });
    }

    /**
     * Borra el valor total de las monedas ingresadas y actualiza la etiqueta de valor total.
     */
    private void borrarTotal() {
        p.setValor(0);
        valorLabel.setText("Valor total: " + 0);
    }
}
