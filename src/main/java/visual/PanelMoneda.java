package visual;

import logica.Moneda;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMoneda extends JPanel {
    public ArrayList<Moneda> cajitaMonedas;
    private int totalValor;
    private JLabel valorLabel;

    public PanelMoneda() {
        cajitaMonedas= new ArrayList<Moneda>();
        setSize(300, 200);

        setLayout(null);

        totalValor = 0;
        valorLabel = new JLabel("Valor total: " + totalValor);

        boton100 b1= new boton100("moneda de 100", valorLabel, this, cajitaMonedas );
        add(b1);
        boton500 b2= new boton500("moneda de 500", valorLabel, this, cajitaMonedas);
        add(b2);
        boton1000 b3= new boton1000("moneda de 1000", valorLabel, this, cajitaMonedas);
        add(b3);
        botonBorrar b4= new botonBorrar("borrar monedas", valorLabel, this, cajitaMonedas);
        add(b4);
        add(valorLabel);

        setVisible(true);
    }
    public void setValor(int a){
        totalValor=a;
    }

    public int getTotalValor() {
        return totalValor;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujadorMonedas dibu= new dibujadorMonedas(cajitaMonedas);
        dibu.paintComponent(g);
    }

}
