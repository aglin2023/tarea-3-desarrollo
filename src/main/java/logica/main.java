package logica;

/**
 * clase principal del programa que contiene el metodo para ejecutarlo
 */
import javax.swing.*;
import java.awt.*;

public class main {
    public static void main (String[] args) {

        JFrame frame = new JFrame();
        PanelPrincipal p = new PanelPrincipal();
        frame.setLayout(new BorderLayout());

        int alturaVentana = 1000;
        int anchoVentana = 1200;
        frame.setSize(anchoVentana,alturaVentana);
        frame.add(p);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

