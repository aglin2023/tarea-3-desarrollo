package visual;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class JPanelExpendedor extends JPanel {
    private JLabel expendedorLabel;
    private Map<String, Point> imagenCords;
    private ProductList[] productos;
    private Expendedor expendedor;
    private JButton botonRellenarYsacar;



    public JPanelExpendedor(Expendedor expendedor){
//        super();
        this.setLayout(null);
        this.expendedorLabel = new JLabel();
        this.expendedor = expendedor;
        this.setPreferredSize(new Dimension(700, 1000));
        imagenCords = new HashMap<>();
        this.productos = new ProductList[]{
                ProductList.COCA,
                ProductList.SPRITE,
                ProductList.FANTA,
                ProductList.SNICKERS,
                ProductList.SUPER8
        };

       //Logica botones

        botonRellenarYsacar = new JButton();
        botonRellenarYsacar.setBounds(0,0,700,1000);
        botonRellenarYsacar.setOpaque(false);
        botonRellenarYsacar.setContentAreaFilled(false);
        botonRellenarYsacar.setBorderPainted(false);
        botonRellenarYsacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expendedor.rellenarDepositos();
                cargarPanel();
            }
        });

        cargarPanel();
    }

    public void cargarPanel(){
        // La idea aqui es cargar el panel cuando se aplique algun boton, cambio en ventana, etc...
        this.removeAll();


        Deposito <Producto> deposito = expendedor.getDepositoUnitarioProductoComprado();
        Producto comprado = null;
        if(deposito.tieneProductos()){
            comprado = deposito.getObject();
        }

        if(comprado != null) {
            if(comprado instanceof CocaCola) {
                crearImagen(productos[0].name().toLowerCase() + ".png", 300,790, 80, 80);
            } else if (comprado instanceof  Sprite) {
                crearImagen(productos[1].name().toLowerCase() + ".png", 300,790, 80, 80);
            } else if (comprado instanceof Fanta) {
                crearImagen(productos[2].name().toLowerCase() + ".png", 300,790, 80, 80);
            } else if (comprado instanceof Snickers) {
                crearImagen(productos[3].name().toLowerCase() + ".png", 300,790, 80, 80);
            } else if (comprado instanceof Super8) {
                crearImagen(productos[4].name().toLowerCase() + ".png", 300,790, 80, 80);
            }
        }

        cargarImagenes();
        agregarImagenExpendedor();
        this.add(botonRellenarYsacar);
        this.repaint();
    }

    public void agregarImagenExpendedor(){
        ImageIcon imagenExpendedor = new ImageIcon("src/main/java/visual/Models/expendedor.png");
        ImageIcon nuevaImagen = JPanelExpendedor.nuevoTamañoImagen(imagenExpendedor, 700, 1000);
        expendedorLabel = new JLabel(nuevaImagen);
        expendedorLabel.setBounds(0,0, nuevaImagen.getIconWidth(), nuevaImagen.getIconHeight());
        add(expendedorLabel);
    }

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
                for(int j = 0; j < llenaDeposito && j < 8 && j < tamañoDeposito; j++) {
                    //Agregar un aunmento en x para ir metiendo mas objetos segun la cantidad de productos
                    crearImagen(productos[i].name().toLowerCase() + ".png", coordenadas[i][0] + x, coordenadas[i][1], coordenadas[i][2], coordenadas[i][3]);
                    x += 81;
                }
            }
        }
    }

    public void crearImagen(String imagen, int x, int y, int ancho, int alto) {
        ImageIcon icon = new ImageIcon("src/main/java/visual/Models/" + imagen);
        ImageIcon nuevaIcon = nuevoTamañoImagen(icon, ancho, alto);
        JLabel label = new JLabel(nuevaIcon);
        label.setBounds(x, y, nuevaIcon.getIconWidth(), nuevaIcon.getIconHeight()); // Establece las coordenadas y tamaño
        add(label); // Agrega el JLabel al JPanel

        // Elimina los últimos 4 caracteres (la extensión del archivo)
        String nombreSinExtension = imagen.substring(0, imagen.length() - 4);
        imagenCords.put(nombreSinExtension, new Point(x, y)); // Guarda las coordenadas de la imagen
    }

    public static ImageIcon nuevoTamañoImagen(ImageIcon icon, int ancho, int alto) {
        Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
