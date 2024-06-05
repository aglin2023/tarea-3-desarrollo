package visual;

import logica.Expendedor;

import javax.swing.*;

public class botonMonederoExpendedor extends JButton {
    private final Expendedor expendedor;
    private final JPanelExpendedor panelExpendedor;
    private final PanelMoneda panelMoneda;

    public botonMonederoExpendedor(Expendedor expendedor, JPanelExpendedor panelExpendedor, PanelMoneda panelMoneda) {
        super("Monedero \n" +
                "Expendedor");
        this.expendedor = expendedor;
        this.panelMoneda = panelMoneda;
        this.panelExpendedor = panelExpendedor;

        ActionListenerMonederoExpendedor actionListener = new ActionListenerMonederoExpendedor(expendedor, panelExpendedor, panelMoneda);
        this.addActionListener(actionListener);
    }
}
