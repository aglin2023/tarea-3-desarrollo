package visual;

import javax.swing.*;
import java.awt.*;

public class JVentana extends JFrame {
    private JPanelPrincipal panelPrincipal;

    public JVentana() {
        panelPrincipal = new JPanelPrincipal();
        this.setTitle("Expendedor");
        this.setSize(1400, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);

        this.add(panelPrincipal);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JVentana ventana = new JVentana();
    }

}
