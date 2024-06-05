package visual;

import logica.Expendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonSacar extends JButton {
    private Expendedor expendedor;
    private JPanelDepositoUnico panelDepositoUnico;

    public BotonSacar(Expendedor expendedor, JPanelDepositoUnico panelDepositoUnico) {
        this.expendedor = expendedor;
        this.panelDepositoUnico = panelDepositoUnico;
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BotonSacar.this.panelDepositoUnico.actualizarImagen();
            }
        });
    }
}


