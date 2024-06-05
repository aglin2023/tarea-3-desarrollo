package visual;

import logica.Deposito;
import logica.Expendedor;
import logica.Producto;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el panel de un único depósito en la interfaz gráfica.
 */
public class JPanelDepositoUnico extends JPanel {
    private final Expendedor expendedor;

    /**
     * Constructor del panel del depósito único.
     *
     * @param expendedor la instancia del expendedor
     */
    public JPanelDepositoUnico(Expendedor expendedor) {
        this.expendedor = expendedor;
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
    }

    /**
     * Método para agregar una imagen al panel.
     *
     * @param rutaImagen la ruta de la imagen
     * @param x          la posición X de la imagen en el panel
     * @param y          la posición Y de la imagen en el panel
     * @param ancho      el ancho de la imagen
     * @param alto       el alto de la imagen
     */
    public void agregarImagen(String rutaImagen, int x, int y, int ancho, int alto) {
        ImageIcon imagen = new ImageIcon(rutaImagen);
        ImageIcon nuevaImagen = nuevoTamañoImagen(imagen, ancho, alto);
        JLabel label = new JLabel(nuevaImagen);
        label.setBounds(x, y, ancho, alto);
        this.add(label);
        this.repaint();
    }

    /**
     * Método para actualizar la imagen en el depósito único.
     */
    public void actualizarImagen() {
        this.removeAll();
        Deposito<Producto> depositoUnitario = expendedor.getDepositoUnitarioProductoComprado();
        if (!depositoUnitario.getArrayList().isEmpty()) {
            agregarImagen("src/main/java/visual/Models/PuertaAbierta.png", 230, 15, 250, 250);
            Producto producto = depositoUnitario.getArrayList().get(0);
            String rutaImagen = "src/main/java/visual/Models/" + producto.consumido().toLowerCase() + ".png";
            agregarImagen(rutaImagen, 280, 35, 120, 120);
            agregarImagen("src/main/java/visual/Models/DetrasProductoZona.png", 230, 15, 250, 250);
        }
        revalidate();
        repaint();
    }

    /**
     * Método para cambiar el tamaño de una imagen.
     *
     * @param icon  el icono de la imagen
     * @param ancho el nuevo ancho de la imagen
     * @param alto  el nuevo alto de la imagen
     * @return el nuevo icono con el tamaño cambiado
     */
    public ImageIcon nuevoTamañoImagen(ImageIcon icon, int ancho, int alto) {
        Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        agregarImagen("src/main/java/visual/Models/PuertaCerrada.png", 230, 15, 250, 250);
    }
}
