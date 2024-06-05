package visual;
import logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.*;

public class PanelDigitos extends JPanel{

	private int widthSize;
	private int heightSize;
	private int margen = 20;

	private JLabel textLabel;
	private JPanelComprador panelComprador;
    private ArrayList<JButton> botones;
    private LogicaDigitos logica;

    public PanelDigitos(JPanelComprador pCom, int wS,int hS){
		setBackground(Color.gray);
		widthSize = wS;
		heightSize = hS;

		textLabel = new JLabel("",JLabel.LEFT);
		panelComprador = pCom;
		this.setLayout(null);

		logica = new LogicaDigitos(textLabel,this);
		CreateBotones(margen,margen*4,12);
    }
    
    public void CreateBotones(int x, int y,int size){
		botones = new ArrayList<JButton>();

		int yGridCount = 0;
		int xGridCount = 0;
		for(int i = 0; i < size ; i++){

			String ButtonLabel = ""+i;

			int width = (widthSize-margen*2-4)/3;
			int height = width;

			if(i == 0)
				xGridCount = 1;
			if(i == 10){
				xGridCount = 0;
				yGridCount = 0;
				ButtonLabel = "<-";
			}
			if(i == 11){
				xGridCount = 2;
				yGridCount = 0;
				ButtonLabel = "OK";
			}

			JButton b = new JButton(ButtonLabel);

			b.setBounds(x+(xGridCount)*width,y+(-yGridCount)*height +height*(size/3-1),width,height);
			b.setActionCommand(""+i);
			b.addActionListener(logica);

			if(i % 3 ==  0){
				yGridCount++;
				xGridCount = 0;
			}
			else
				xGridCount++;

			botones.add(b);


			this.add(b);
		}
    }

	public JPanelComprador getPanelComprador() {
		return panelComprador;
	}
	
    public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.fillRect(margen-2,margen,widthSize - 2*margen,margen*2);

		textLabel.setBounds(0,20,widthSize,margen*2-5);
		textLabel.setForeground(Color.GREEN);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(textLabel);

    }
}
