package visual;

import logica.Comprador;
import logica.Expendedor;
import logica.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelComprador extends JPanel {
    private Comprador logicaComprador;
    private Expendedor logicaExpendedor;
    private JPanelExpendedor panelExpendedor;
    private PanelMoneda panelMoneda;
    private PanelDigitos panelDigitos;

    private ArrayList<Moneda> m;

    public JPanelComprador(JPanelExpendedor panelExpendedor) {
        int widthDigitos = 200;
        int heightDigitos = 320;
        this.panelExpendedor = panelExpendedor;

        m = new ArrayList<Moneda>();
        logicaComprador = new Comprador(m);

        panelDigitos = new PanelDigitos(this, widthDigitos, heightDigitos);
        panelMoneda = new PanelMoneda(m);


        setLayout(new BorderLayout());
        JLayeredPane layeredPane = new JLayeredPane();


        panelDigitos.setBounds(0, 0, widthDigitos, heightDigitos);
        panelMoneda.setBounds(0, 0, 700, 1000);

        layeredPane.add(panelDigitos, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panelMoneda, JLayeredPane.DEFAULT_LAYER);

        add(layeredPane, BorderLayout.CENTER);
    }

    public void MandarSolicitudCompra(int ID) throws Exception {
        if (logicaComprador.ComprobarSolicitud(ID, logicaExpendedor)) {
            panelExpendedor.cargarPanel();
            repaint();
        }
    }

    public void setExpendedor(Expendedor e) {
        logicaExpendedor = e;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        panelMoneda.paintComponent(g);
        panelDigitos.paintComponent(g);
    }
}
