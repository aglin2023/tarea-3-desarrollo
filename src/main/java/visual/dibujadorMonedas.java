package visual;
import logica.Moneda;
import logica.Moneda100;

import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.math.*;
public class dibujadorMonedas extends JPanel {
    private ArrayList<Moneda> m;
    public dibujadorMonedas(ArrayList<Moneda> m){
        this.m=m;
    }
    Image moneda1;
    Image moneda2;
    Image moneda3;
    int limiteY=1;
    int limiteX=1;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        try{
            moneda1= ImageIO.read(new File("src/main/java/visual/100-anverso.png"));
            moneda2= ImageIO.read(new File("src/main/java/visual/pngtree-happy-face-png-image_8663365.png"));
            moneda3= ImageIO.read(new File("src/main/java/visual/Eo_circle_green_checkmark.svg.png"));
            for(int i=0; i<=m.size(); i++){

                if(m.get(i).getValor()==100){
                    g.drawImage(moneda1, limiteX*50, 52*limiteY, 50, 50, new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                            return false;
                        }
                    });
                }
                if(m.get(i).getValor()==500){
                    g.drawImage(moneda2, limiteX*50, 52*limiteY, 50, 50, new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                            return false;
                        }
                    });
                }
                if(m.get(i).getValor()==1000){
                    g.drawImage(moneda3, limiteX*50,52*limiteY, 50, 50, new ImageObserver() {
                        @Override
                        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                            return false;
                        }
                    });
                }
                if((i+1)%10==0){
                    limiteY+=1;
                    limiteX=1;

                }else {
                    limiteX++;
                }
            }
        }catch (Exception e){}

    }
}
