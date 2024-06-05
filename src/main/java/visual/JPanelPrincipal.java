package visual;

import logica.Comprador;
import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class JPanelPrincipal extends JPanel {
    private JPanelExpendedor panelExpendedor;
    private JPanelDepositoUnico panelDepositoUnico;
    private JPanelPrecios panelPrecios;
    private JPanelComprador panelComprador;

    public JPanelPrincipal(){
        Expendedor expendedor = new Expendedor(6);

//        this.setLayout(null);
//        this.setPreferredSize(new Dimension(1400,1000));
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(layout);

        // Crea JPanelDepositoUnico y lo agrega a JPanelPrincipal
        panelDepositoUnico = new JPanelDepositoUnico(expendedor);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 700;
        gbc.ipady = 230;
     //   gbc.fill = GridBagConstraints.VERTICAL;
     //   gbc.anchor = GridBagConstraints.WEST;
        this.add(panelDepositoUnico,gbc);


//      panelDepositoUnico.setBounds(0, 750, 700, 250);
//      this.add(panelDepositoUnico);

        // Crea JPanelExpendedor y lo agrega a JPanelPrincipal
        panelExpendedor = new JPanelExpendedor(expendedor, panelDepositoUnico);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.ipadx = 700;
        gbc.ipady = 750;
        gbc.fill = GridBagConstraints.NONE;
     //   gbc.anchor = GridBagConstraints.WEST;
        this.add(panelExpendedor,gbc);

        panelPrecios = new JPanelPrecios();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 350;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(panelPrecios, gbc);


//      panelExpendedor.setBounds(0, 0, 700, 750);
//      this.add(panelExpendedor);

        panelComprador.setExpendedor(expendedor);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipadx = 350;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(panelComprador);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}