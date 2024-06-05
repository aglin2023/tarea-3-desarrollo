package visual;

import logica.Expendedor;

import javax.swing.*;

public class botonMonederoExpendedor extends JButton {
    private Expendedor expendedor;
    private JPanelExpendedor panelExpendedor;
    private PanelMoneda panelMoneda;

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
