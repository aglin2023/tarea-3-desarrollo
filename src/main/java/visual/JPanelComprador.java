package visual;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JPanelComprador extends JPanel {
    private Comprador logicaComprador;
    private Expendedor logicaExpendedor;

    private PanelMoneda panelMoneda;
    private PanelDigitos panelDigitos;

    public JPanelComprador() {
        int widthDigitos = 200;
        int heightDigitos = 320;

        logicaComprador = new Comprador();
        panelDigitos = new PanelDigitos(this,widthDigitos,heightDigitos);
        panelMoneda = new PanelMoneda();

        setLayout(null);
        panelDigitos.setBounds(0,0,widthDigitos,heightDigitos);
        panelMoneda.setBounds(widthDigitos,0,500,1000);

        this.add(panelDigitos);
        this.add(panelMoneda);
    }

    public void MandarSolicitudCompra(int ID) throws Exception{
        logicaComprador.ComprobarSolicitud(ID,panelMoneda.cajitaMonedas,logicaExpendedor);
    }

    public void SetExpendedor(Expendedor e) {
        logicaExpendedor = e;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        panelMoneda.paintComponent(g);
        panelDigitos.paintComponent(g);
    }
}
