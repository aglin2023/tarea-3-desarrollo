package visual;

import logica.Expendedor;

import javax.swing.*;
import java.awt.*;

public class JVentana extends JFrame {
    private JPanelPrincipal panelPrincipal;

    public JVentana() {
        Expendedor expendedor = new Expendedor(6);
        panelPrincipal = new JPanelPrincipal(expendedor);
        this.setTitle("Expendedor");
        this.setSize(1400, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panelPrincipal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JVentana ventana = new JVentana();
    }

}
