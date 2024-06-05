package visual;

import logica.Expendedor;

import javax.swing.*;

/**
 * Clase que representa un botón para abrir la ventana del monedero del expendedor.
 */
public class botonMonederoExpendedor extends JButton {
    private final Expendedor expendedor;
    private final JPanelExpendedor panelExpendedor;
    private final PanelMoneda panelMoneda;

    /**
     * Constructor del botón para el monedero del expendedor.
     *
     * @param expendedor      la instancia del expendedor
     * @param panelExpendedor el panel del expendedor
     * @param panelMoneda     el panel de las monedas
     */
    public botonMonederoExpendedor(Expendedor expendedor, JPanelExpendedor panelExpendedor, PanelMoneda panelMoneda) {
        super("Monedero \nExpendedor");
        this.expendedor = expendedor;
        this.panelMoneda = panelMoneda;
        this.panelExpendedor = panelExpendedor;

        ActionListenerMonederoExpendedor actionListener = new ActionListenerMonederoExpendedor(expendedor, panelExpendedor, panelMoneda);
        this.addActionListener(actionListener);
    }
}
