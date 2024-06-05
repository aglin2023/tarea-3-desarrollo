package visual;

import logica.ProductList;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JPanelPrecios extends JPanel {
    private final JLabel[] nombreProducto;
    private final JLabel[] precioProducto;
    private final JLabel[] idProducto;
    private final ProductList[] productos;

    public JPanelPrecios() {
        this.setLayout(new GridLayout(5, 3));
        this.productos = new ProductList[]{
                ProductList.COCA,
                ProductList.SPRITE,
                ProductList.FANTA,
                ProductList.SNICKERS,
                ProductList.SUPER8
        };

        Font fuentePersonalizada = null;
        try {
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/java/visual/Models/Fonts/Minecraft.ttf"));
            fuentePersonalizada = fuentePersonalizada.deriveFont(22F);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }


        // Inicializa los arrays de JLabels
        nombreProducto = new JLabel[5];
        precioProducto = new JLabel[5];
        idProducto = new JLabel[5];

        for (int i = 0; i < 5; i++) {
            nombreProducto[i] = new JLabel();
            nombreProducto[i].setPreferredSize(new Dimension(80, 40));
            nombreProducto[i].setFont(fuentePersonalizada);
            this.add(nombreProducto[i]);

            precioProducto[i] = new JLabel();
            precioProducto[i].setPreferredSize(new Dimension(80, 40));
            precioProducto[i].setFont(fuentePersonalizada);
            this.add(precioProducto[i]);

            idProducto[i] = new JLabel();
            idProducto[i].setPreferredSize(new Dimension(40, 40));
            idProducto[i].setFont(fuentePersonalizada);
            this.add(idProducto[i]);
        }
        for (int i = 0; i < 5; i++) {
            nombreProducto[i].setText(productos[i].name());
            precioProducto[i].setText(productos[i].getPrice().getValor() + "$");
            idProducto[i].setText("ID: " + productos[i].getID());
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, 680, 218);

    }

}
