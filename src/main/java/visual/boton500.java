package visual;

import logica.Moneda;
import logica.Moneda500;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class boton500 extends JButton {
    private final PanelMoneda p;
    private final JLabel valorLabel;

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

    private void ingresarMoneda(Moneda moneda) {
        int aux = p.getTotalValor() + moneda.getValor();
        p.setValor(aux);
        valorLabel.setText("Valor total: " + aux);
    }
}


