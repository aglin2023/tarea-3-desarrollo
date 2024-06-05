package visual;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class JPanelPrincipal extends JPanel {
    private JPanelExpendedor panelExpendedor;
    private JPanelDepositoUnico panelDepositoUnico;
    private JPanelPrecios panelPrecios;
    private JPanelComprador panelComprador;

    public JPanelPrincipal() {
        Expendedor expendedor = new Expendedor(6);

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

        this.add(panelDepositoUnico, gbc);


        // Crea JPanelExpendedor y lo agrega a JPanelPrincipal
        panelExpendedor = new JPanelExpendedor(expendedor, panelDepositoUnico);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.ipadx = 700;
        gbc.ipady = 750;
        gbc.fill = GridBagConstraints.NONE;

        this.add(panelExpendedor, gbc);

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


        panelComprador = new JPanelComprador(panelExpendedor);
        panelComprador.setExpendedor(expendedor);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.ipadx = 350;
        gbc.ipady = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(panelComprador, gbc);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}