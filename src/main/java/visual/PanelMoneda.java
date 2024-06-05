package visual;

import logica.Moneda;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * clase que representa un panel para realizar acciones relacionadas a ingresar monedas
 */
public class PanelMoneda extends JPanel {
    /**
     * lista de monedas en el panel
     */
    public ArrayList<Moneda> cajitaMonedas;
    /**
     * valor total de las monedas ingresadas
     */
    private int totalValor;
    /**
     * etiqueta para mostrar el valor total
     */
    private JLabel valorLabel;

    /**
     * constructor de la clase que crea el panel
     */
    public PanelMoneda(ArrayList<Moneda> m) {
        cajitaMonedas = m;
        setSize(300, 200);

        setLayout(null);

        totalValor = 0;
        valorLabel = new JLabel("Valor total: " + totalValor);
        valorLabel.setBounds(900, 20, 100, 50);


        boton100 b1= new boton100("moneda de 100", valorLabel, this, cajitaMonedas );
        add(b1);
        boton500 b2= new boton500("moneda de 500", valorLabel, this, cajitaMonedas);
        add(b2);
        boton1000 b3= new boton1000("billete de 1000", valorLabel, this, cajitaMonedas);
        add(b3);
        botonBorrar b4= new botonBorrar("borrar monedas", valorLabel, this, cajitaMonedas);
        add(b4);
        add(valorLabel);


        setVisible(true);
    }

    /**
     *metodo que establece el valor a las monedas
     * @param a el nuevo valor total
     */
    public void setValor(int a){
        totalValor=a;
    }

    /**
     * obtiene el valor total de las monedas
     * @return regresa el valor total
     */
    public int getTotalValor() {
        return totalValor;
    }

    /**
     * metodo que dibujar los componentes del panel
     * @param g el contexto grafico
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        dibujadorMonedas dibu= new dibujadorMonedas(cajitaMonedas);
        dibu.paintComponent(g);
    }

}
