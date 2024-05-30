package logica;
import visual.PanelMoneda;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelMoneda com;
    //private PanelExpendedor exp;

    public PanelPrincipal(){
		com = new PanelMoneda();
		//exp = new PanelExpendedor();

		this.setLayout(new GridLayout(1,2));
		this.add(com);
		//this.add(exp);
    }
    
    public void paintComponent(Graphics g){
		super.paintComponent(g);
		com.paintComponents(g);
		//exp.paintComponent(g);
	}
}	

