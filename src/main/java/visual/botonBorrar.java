package visual;

import logica.Moneda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class botonBorrar extends JButton {
    private final JLabel valorLabel;
    private final PanelMoneda p;


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

    private void borrarTotal() {
        p.setValor(0);
        valorLabel.setText("Valor total: " + 0);
    }
}
