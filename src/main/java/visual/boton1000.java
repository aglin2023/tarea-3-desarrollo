package visual;

import logica.Moneda;
import logica.Moneda1000;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class boton1000 extends JButton {
    private final PanelMoneda p;

    private final JLabel valorLabel;

    public boton1000(String a, JLabel s, PanelMoneda p, ArrayList<Moneda> monedas) {
        super(a);
        valorLabel = s;
        this.p = p;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monedas.size() >= 40)
                    return;
                Moneda1000 m1000 = new Moneda1000();
                ingresarMoneda(m1000);
                monedas.add(m1000);
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
