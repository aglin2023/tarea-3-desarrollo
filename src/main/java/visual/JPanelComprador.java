package visual;

import logica.Comprador;
import logica.Moneda;
import logica.Moneda1000;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelComprador extends JPanel {
    private PanelDigitos panelDigitos;
    private Comprador logicaComprador;

    public JPanelComprador() {

        logicaComprador = new Comprador();
        panelDigitos = new PanelDigitos(this);

        setLayout(new GridLayout(1,2));
        this.add(panelDigitos);
        this.add(new JPanel());
    }

    public void MandarSolicitudCompra(int ID) throws Exception{
        ArrayList<Moneda> m = new ArrayList<Moneda>();
        m.add(new Moneda1000());

        logicaComprador.ComprobarSolicitud(ID,m);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        panelDigitos.paintComponent(g);
    }
}
