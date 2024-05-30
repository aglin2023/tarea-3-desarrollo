package visual;

import logica.Moneda;
import logica.Moneda100;
import logica.Moneda500;
import logica.Moneda1000;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMoneda extends JFrame {
    private int totalValor;
    private JLabel valorLabel;

    public PanelMoneda() {
        setTitle("Expendedor de Monedas");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        totalValor = 0;
        valorLabel = new JLabel("Valor total: " + totalValor);

        JButton boton100 = new JButton("Moneda de 100");
        JButton boton500 = new JButton("Moneda de 500");
        JButton boton1000 = new JButton("Moneda de 1000");
        JButton botonborrar= new JButton("quitar monedas");

        boton100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarMoneda(new Moneda100());
            }
        });

        boton500.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarMoneda(new Moneda500());
            }
        });

        boton1000.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresarMoneda(new Moneda1000());
            }
        });

        botonborrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarTotal();

            }
        });

        add(boton100);
        add(boton500);
        add(boton1000);
        add(botonborrar);
        add(valorLabel);

        setVisible(true);
    }

    private void borrarTotal(){
        totalValor= 0;
        valorLabel.setText("Valor total: " + totalValor);
    }

    private void ingresarMoneda(Moneda moneda) {
        totalValor += moneda.getValor();
        valorLabel.setText("Valor total: " + totalValor);
    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
    }

}
