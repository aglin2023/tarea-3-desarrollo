package visual;

import logica.Moneda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        // setSize(100, 100);
        setOpaque(false);
        setLayout(null);


        totalValor = 0;
        valorLabel = new JLabel("Valor total: " + totalValor);
        valorLabel.setBounds(0, 310, 700, 50);


        boton100 b1 = new boton100("100$", valorLabel, this, cajitaMonedas);
        b1.setBounds(0, 350, 100, 100);
        add(b1);

        boton500 b2 = new boton500("500$", valorLabel, this, cajitaMonedas);
        b2.setBounds(0, 450, 100, 100);
        add(b2);

        boton1000 b3 = new boton1000("1000$", valorLabel, this, cajitaMonedas);
        b3.setBounds(0, 550, 100, 100);
        add(b3);

        botonBorrar b4 = new botonBorrar("borrar monedas", valorLabel, this, cajitaMonedas);
        b4.setBounds(0, 650, 100, 100);
        add(b4);

        add(valorLabel);
        setVisible(true);
    }

    /**
     * metodo que establece el valor a las monedas
     *
     * @param a el nuevo valor total
     */
    public void setValor(int a) {
        totalValor = a;
    }

    /**
     * obtiene el valor total de las monedas
     *
     * @return regresa el valor total
     */
    public int getTotalValor() {
        return totalValor;
    }

    /**
     * metodo que dibujar los componentes del panel
     *
     * @param g el contexto grafico
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujadorMonedas dibu = new dibujadorMonedas(cajitaMonedas);
        dibu.paintComponent(g);
        int valorTotal = 0;
        for (Moneda m : cajitaMonedas) {
            valorTotal += m.getValor();
        }
        valorLabel.setText("Dinero restante: " + valorTotal);
    }

}
