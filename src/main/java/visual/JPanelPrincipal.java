package visual;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class JPanelPrincipal extends JPanel {
    private JPanelExpendedor panelExpendedor;
    private JPanelDepositoUnico panelDepositoUnico;

    public JPanelPrincipal(Expendedor expendedor){
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1400,1000));

        // Crea JPanelDepositoUnico y lo agrega a JPanelPrincipal
        panelDepositoUnico = new JPanelDepositoUnico(expendedor);
        panelDepositoUnico.setBounds(0, 750, 700, 250);
        this.add(panelDepositoUnico);

        // Crea JPanelExpendedor y lo agrega a JPanelPrincipal
        panelExpendedor = new JPanelExpendedor(expendedor, panelDepositoUnico);
        panelExpendedor.setBounds(0, 0, 700, 750);
        this.add(panelExpendedor);


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}