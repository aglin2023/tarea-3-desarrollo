package visual;

import logica.Comprador;
import logica.Expendedor;
import logica.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase que representa el panel del comprador en la interfaz gráfica.
 */
public class JPanelComprador extends JPanel {
    private final Comprador logicaComprador;
    private final Expendedor logicaExpendedor;
    private final JPanelExpendedor panelExpendedor;
    private final PanelMoneda panelMoneda;
    private final PanelDigitos panelDigitos;

    private final ArrayList<Moneda> m;

    /**
     * Constructor del panel del comprador.
     *
     * @param panelExpendedor el panel del expendedor
     * @param expendedor      la instancia del expendedor
     */
    public JPanelComprador(JPanelExpendedor panelExpendedor, Expendedor expendedor) {
        int widthDigitos = 200;
        int heightDigitos = 320;
        this.panelExpendedor = panelExpendedor;
        this.logicaExpendedor = expendedor;

        m = new ArrayList<Moneda>();
        logicaComprador = new Comprador(m);

        panelDigitos = new PanelDigitos(this, widthDigitos, heightDigitos);
        panelMoneda = new PanelMoneda(m);

        setLayout(new BorderLayout());
        JLayeredPane layeredPane = new JLayeredPane();

        botonMonederoExpendedor botonMonederoExpendedor = new botonMonederoExpendedor(logicaExpendedor, panelExpendedor, panelMoneda);
        botonMonederoExpendedor.setBounds(210, 0, 200, 100);

        panelDigitos.setBounds(0, 0, widthDigitos, heightDigitos);
        panelMoneda.setBounds(0, 0, 700, 1000);

        layeredPane.add(panelDigitos, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panelMoneda, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(botonMonederoExpendedor, JLayeredPane.DEFAULT_LAYER);

        add(layeredPane, BorderLayout.CENTER);
    }

    /**
     * Método para enviar una solicitud de compra al expendedor.
     *
     * @param ID el ID del producto a comprar
     * @throws Exception si ocurre un error durante la compra
     */
    public void MandarSolicitudCompra(int ID) throws Exception {
        if (logicaExpendedor.getDepositoUnitarioProductoComprado().getArrayList().size() > 0) {
            throw new Exception("Primero saque el producto anterior");
        }
        if (logicaComprador.ComprobarSolicitud(ID, logicaExpendedor)) {
            panelExpendedor.cargarPanel();
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        panelMoneda.paintComponent(g);
        panelDigitos.paintComponent(g);
    }
}
