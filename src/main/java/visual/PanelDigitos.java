package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.*;

public class PanelDigitos extends JPanel implements ActionListener{

    private ArrayList<JButton> botones;

    public PanelDigitos(){
	this.setLayout(null);

	JLabel l = new JLabel("Text de Prueba",JLabel.LEFT);
	l.setText("Ejemplo Text");
	l.setBounds(0,0,100,10);
	this.add(l);

	CreateBotones(0,40,12);
    }
    
    public void CreateBotones(int x, int y,int size){
	botones = new ArrayList<JButton>();

	int yGridCount = 0;
	int xGridCount = 0;
	for(int i = 0; i < size ; i++){

	    String ButtonLabel = ""+i;

	    int width = 55;
	    int height = 55;

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
	    b.addActionListener(this);

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
	
    public void paintComponent(Graphics g){
	super.paintComponent(g);
    }
    public void actionPerformed(ActionEvent e){
	for(int i = 0; i < 10; i++){
	    String aux = i + "";
	    if(aux.equals(e.getActionCommand())){
		System.out.print(i);
	    }
	}
    }
}
