package visual;

import logica.Expendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonRellenar extends JButton {
    private final Expendedor expendedor;
    private final JPanelExpendedor panelExpendedor;

    public BotonRellenar(Expendedor expendedor, JPanelExpendedor panelExpendedor) {
        this.expendedor = expendedor;
        this.panelExpendedor = panelExpendedor;
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BotonRellenar.this.expendedor.rellenarDepositos();
                BotonRellenar.this.panelExpendedor.cargarPanel();
            }
        });
    }
}


