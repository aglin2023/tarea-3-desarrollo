package logica;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador com;
    private PanelExpendedor exp;

    public PanelPrincipal(){
		com = new PanelComprador();
		exp = new PanelExpendedor();

		this.setLayout(new GridLayout(1,2));
		this.add(com);
		this.add(exp);
    }
    
    public void paintComponent(Graphics g){
		super.paintComponent(g);
		com.paintComponent(g);
		exp.paintComponent(g);
	}
}	

