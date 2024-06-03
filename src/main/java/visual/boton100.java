package visual;
import logica.Moneda;
import logica.Moneda100;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class boton100 extends JButton{

   private PanelMoneda p;
    private JLabel valorLabel;
    public boton100(String a, JLabel s, PanelMoneda p, ArrayList<Moneda> monedas){
        super(a);
        setBounds(10,10, 200,80);
        valorLabel= s;
        this.p= p;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(monedas.size()>=50)
                    return;
                Moneda100 m100= new Moneda100();
                ingresarMoneda(m100);
                monedas.add(m100);
                p.repaint();
            }
        });
    }

    private void ingresarMoneda(Moneda moneda) {
        int aux= p.getTotalValor() + moneda.getValor();
        p.setValor(aux);
        valorLabel.setText("Valor total: " + aux);
    }
}
