package visual;

import logica.Expendedor;
import logica.LogicaDigitos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa un botón para sacar un producto del expendedor.
 */
public class BotonSacar extends JButton {
    private final Expendedor expendedor;
    private final JPanelDepositoUnico panelDepositoUnico;

    /**
     * Constructor del botón para sacar un producto del expendedor.
     *
     * @param expendedor          la instancia del expendedor
     * @param panelDepositoUnico  el panel del depósito único
     */
    public BotonSacar(Expendedor expendedor, JPanelDepositoUnico panelDepositoUnico) {
        this.expendedor = expendedor;
        this.panelDepositoUnico = panelDepositoUnico;
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expendedor.getDepositoUnitarioProductoComprado().getArrayList().size() > 0) {
                    expendedor.getDepositoUnitarioProductoComprado().getArrayList().remove(0);
                    LogicaDigitos.procesandoCompra = false;
                }
                BotonSacar.this.panelDepositoUnico.actualizarImagen();
            }
        });
    }
}
