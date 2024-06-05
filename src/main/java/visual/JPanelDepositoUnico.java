package visual;

import logica.Deposito;
import logica.Expendedor;
import logica.Producto;

import javax.swing.*;
import java.awt.*;

public class JPanelDepositoUnico extends JPanel {
    private Expendedor expendedor;

    public JPanelDepositoUnico(Expendedor expendedor) {
        this.expendedor = expendedor;
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
    }

    public void agregarImagen(String rutaImagen, int x, int y, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon(rutaImagen);
        ImageIcon nuevaImagen = nuevoTamañoImagen(imagen, ancho, alto);
        JLabel label = new JLabel(nuevaImagen);
        label.setBounds(x, y, ancho, alto);
        this.add(label);
        this.repaint();
    }

    public void actualizarImagen() {
        this.removeAll();
        Deposito<Producto> depositoUnitario = expendedor.getDepositoUnitarioProductoComprado();
        if (!depositoUnitario.getArrayList().isEmpty()) {
            Producto producto = depositoUnitario.getArrayList().get(0);
            String rutaImagen = "src/main/java/visual/Models/" + producto.consumido().toLowerCase() + ".png";
            agregarImagen(rutaImagen, 280, 35, 120, 150);
        }
        revalidate();
        repaint();
    }

    public ImageIcon nuevoTamañoImagen(ImageIcon icon, int ancho, int alto) {
        Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(280, 40, 115, 140);
    }
}