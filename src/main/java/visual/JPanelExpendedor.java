package visual;

import logica.Deposito;
import logica.Expendedor;
import logica.ProductList;
import logica.Producto;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el panel del expendedor en la interfaz gráfica.
 */
public class JPanelExpendedor extends JPanel {
    private JLabel expendedorLabel;
    private final ProductList[] productos;
    private final Expendedor expendedor;
    private final JPanelDepositoUnico depositoUnico;
    private final JButton botonRellenar;
    private final JButton botonSacar;

    /**
     * Constructor del panel del expendedor.
     *
     * @param expendedor       la instancia del expendedor
     * @param panelDepositoUnico el panel del depósito único
     */
    public JPanelExpendedor(Expendedor expendedor, JPanelDepositoUnico panelDepositoUnico) {
        this.setLayout(null);
        this.expendedorLabel = new JLabel();
        this.expendedor = expendedor;
        this.depositoUnico = panelDepositoUnico;
        this.productos = new ProductList[]{
                ProductList.COCA,
                ProductList.SPRITE,
                ProductList.FANTA,
                ProductList.SNICKERS,
                ProductList.SUPER8
        };

        //Agrego botones
        botonRellenar = new BotonRellenar(expendedor, this);
        botonRellenar.setBounds(0, 0, 700, 750);

        botonSacar = new BotonSacar(expendedor, panelDepositoUnico);
        botonSacar.setBounds(0, 0, 700, 250);
        cargarPanel();
    }

    /**
     * Método para cargar el panel del expendedor.
     */
    public void cargarPanel() {
        // La idea aquí es cargar el panel cuando se aplique algún botón, cambio en ventana, etc...
        this.removeAll();
        cargarImagenes();
        depositoUnico.actualizarImagen();
        agregarImagenExpendedor();
        this.add(botonRellenar);
        depositoUnico.add(botonSacar);
        this.repaint();
    }

    /**
     * Método para agregar la imagen del expendedor al panel.
     */
    public void agregarImagenExpendedor() {
        ImageIcon imagenExpendedor = new ImageIcon("src/main/java/visual/Models/expendedor.png");
        ImageIcon nuevaImagen = this.nuevoTamañoImagen(imagenExpendedor, 700, 1000);
        expendedorLabel = new JLabel(nuevaImagen);
        expendedorLabel.setBounds(0, 0, nuevaImagen.getIconWidth(), nuevaImagen.getIconHeight());
        add(expendedorLabel);
    }

    /**
     * Método para cargar las imágenes de los productos en el panel del expendedor.
     */
    public void cargarImagenes() {
        int[][] coordenadas = {
                {25, 25, 80, 80},
                {35, 160, 60, 80},
                {10, 290, 120, 80},
                {40, 400, 120, 120},
                {36, 530, 120, 120}
        };

        for (int i = 0; i < productos.length; i++) {
            Deposito<Producto> deposito = expendedor.getDeposito(productos[i]);
            if (deposito != null && deposito.tieneProductos()) {
                int llenaDeposito = expendedor.getLlenaDeposito();
                int tamañoDeposito = expendedor.getDeposito(productos[i]).getArrayList().size();
                int x = 0;
                for (int j = 0; j < llenaDeposito && j < 8 && j < tamañoDeposito; j++) {
                    //Agregar un aumento en x para ir metiendo más objetos según la cantidad de productos
                    crearImagen(productos[i].name().toLowerCase() + ".png", coordenadas[i][0] + x, coordenadas[i][1], coordenadas[i][2], coordenadas[i][3]);
                    x += 81;
                }
            }
        }
    }

    /**
     * Método para crear una imagen en el panel del expendedor.
     *
     * @param imagen la imagen a crear
     * @param x      la posición X de la imagen en el panel
     * @param y      la posición Y de la imagen en el panel
     * @param ancho  el ancho de la imagen
     * @param alto   el alto de la imagen
     */
    public void crearImagen(String imagen, int x, int y, int ancho, int alto) {
        ImageIcon icon = new ImageIcon("src/main/java/visual/Models/" + imagen);
        ImageIcon nuevaIcon = this.nuevoTamañoImagen(icon, ancho, alto);
        JLabel label = new JLabel(nuevaIcon);
        label.setBounds(x, y, nuevaIcon.getIconWidth(), nuevaIcon.getIconHeight()); // Establece las coordenadas y tamaño
        add(label); // Agrega el JLabel al JPanel
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
