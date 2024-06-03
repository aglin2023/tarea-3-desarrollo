package visual;

import logica.Moneda;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class botonBorrar extends JButton {
    private JLabel valorLabel;
    private PanelMoneda p;

    public botonBorrar(String a, JLabel s, PanelMoneda p, ArrayList<Moneda>monedas){
        super(a);
        setBounds(600,10, 200,80);
        this.p= p;
        valorLabel=s;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarTotal();
                p.repaint();
                monedas.clear();
            }
        });
    }
    private void borrarTotal(){
        p.setValor(0);
        valorLabel.setText("Valor total: " + 0);
    }
}
