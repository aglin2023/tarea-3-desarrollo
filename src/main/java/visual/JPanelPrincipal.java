package visual;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class JPanelPrincipal extends JPanel {
    private JPanelExpendedor exp;
    //private JPanelComprador com;

    public JPanelPrincipal(){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1400,1000));
        exp = new JPanelExpendedor(new Expendedor(5));
        exp.setBounds(0, 0, 700, 1000);
        // com = new JPanelComprador(exp);
        this.add(exp);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
