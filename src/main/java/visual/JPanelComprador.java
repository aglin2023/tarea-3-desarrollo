package visual;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelComprador extends JPanel {
    private PanelDigitos panelDigitos;
    private Comprador logicaComprador;
    private Expendedor logicaExpendedor;

    public JPanelComprador() {

        logicaComprador = new Comprador();
        panelDigitos = new PanelDigitos(this);

        setLayout(new GridLayout(1,2));
        this.add(panelDigitos);
        this.add(new JPanel());
    }

    public void MandarSolicitudCompra(int ID) throws Exception{
        ArrayList<Moneda> m = new ArrayList<Moneda>();
        m.add(new Moneda500());

        logicaExpendedor = new Expendedor(4);
        logicaComprador.ComprobarSolicitud(ID,m,logicaExpendedor);
    }

    public void SetExpendedor(Expendedor e) {
        logicaExpendedor = e;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        panelDigitos.paintComponent(g);
    }
}
