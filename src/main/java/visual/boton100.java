package visual;

import logica.Moneda;
import logica.Moneda100;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * clase que representa un boton que introduce una moneda de 100
 */
public class boton100 extends JButton {
    /**
     * panel donde se muestra las monedas y donde se ingresa
     */
    private final PanelMoneda p;
    /**
     * variable que representa una etiqueta
     */
    private final JLabel valorLabel;

    /**
     *constructor de la clase para crear un boton
     *
     * @param a el texto del boton
     * @param s la etiqueta que muestra el valor total ingresado
     * @param p el panel donde se muestra las monedas y donde se ingresa
     * @param monedas lista de monedas en arraylist
     */

    public boton100(String a, JLabel s, PanelMoneda p, ArrayList<Moneda> monedas) {
        super(a);
        valorLabel = s;
        this.p = p;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monedas.size() >= 40)
                    return;
                Moneda100 m100 = new Moneda100();
                ingresarMoneda(m100);
                monedas.add(m100);
                p.repaint();
            }
        });
    }

    /**
     * metodo que permite ingresar el valor de la moneda al total
     *
     * @param moneda moneda de tipo moneda
     */

    private void ingresarMoneda(Moneda moneda) {
        int aux = p.getTotalValor() + moneda.getValor();
        p.setValor(aux);
        valorLabel.setText("Valor total: " + aux);
    }
}
