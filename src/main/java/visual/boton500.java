package visual;
import logica.Moneda;
import logica.Moneda100;
import logica.Moneda500;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class boton500 extends JButton{
    private PanelMoneda p;
    private JLabel valorLabel;
    public boton500(String a, JLabel s, PanelMoneda p, ArrayList<Moneda> monedas){
        super(a);
        setBounds(220,10, 200,80);
        valorLabel= s;
        this.p= p;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(monedas.size()>=50)
                    return;
                Moneda500 m500= new Moneda500();
                ingresarMoneda(m500);
                monedas.add(m500);
                p.repaint();
            }
        });
    }

    private void ingresarMoneda(Moneda moneda) {
        int aux= p.getTotalValor() + moneda.getValor();
        p.setValor(aux );
        valorLabel.setText("Valor total: " + aux);
    }
}


