package visual;

import logica.Comprador;

import javax.swing.*;
import java.awt.*;

public class JPanelComprador extends JPanel {
    private PanelDigitos panelDigitos;

    public JPanelComprador() {
        panelDigitos = new PanelDigitos();

        setLayout(new GridLayout(1,2));
        this.add(panelDigitos);
        this.add(new JPanel());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        panelDigitos.paintComponent(g);
    }
}
