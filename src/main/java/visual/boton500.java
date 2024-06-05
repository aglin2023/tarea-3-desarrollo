package visual;

import logica.Moneda;
import logica.Moneda500;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * clase que representa un boton que añade una moneda de 500
 */
public class boton500 extends JButton {
    private PanelMoneda p;
    private PanelDigitos pd;
    private JLabel valorLabel;

    /**
     * constructor de la clase
     * @param a texto del boton
     * @param s jlabel que muestra el valor total ingresado
     * @param p panel asociado al boton
     * @param monedas lista de monedas donde se ingresa la moneda de 500
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
     * metodo que ingresa una moneda y actualiza el total ingresado
     * @param moneda la moneda que se ingresa al total
     */
    private void ingresarMoneda(Moneda moneda) {
        int aux = p.getTotalValor() + moneda.getValor();
        p.setValor(aux);
        valorLabel.setText("Valor total: " + aux);
    }
}


