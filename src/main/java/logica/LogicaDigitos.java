package logica;
import visual.PanelDigitos;

import javax.swing.*;
import java.awt.event.*;

public class LogicaDigitos implements ActionListener{

	private PanelDigitos panelDigitos;
    private int actualPointer = 0;
    private String[] digits_pantalla = {"","","",""};
    private JLabel pantalla;

    boolean procesandoCompra = false;
    
    public LogicaDigitos(JLabel l, PanelDigitos p){
		panelDigitos = p;
		pantalla = l;
		l.setText("ID DEL PRODUCTO:");
    }

    public void actionPerformed(ActionEvent e){
	if(procesandoCompra)
	    return;

	for(int i = 0; i < 10; i++){
	    String aux = i + "";
	    if(aux.equals(e.getActionCommand())){
		DigitoClickeado(aux);
	    }
	}

	if("10".equals(e.getActionCommand())){
	    DeleteDigit();
	}
	if("11".equals(e.getActionCommand())){
	    OkButton();
	}
    }

    public void DigitoClickeado(String i)
    {
	if(actualPointer >= digits_pantalla.length){
	    actualPointer--;
	    return;
	}

	if(!digits_pantalla[actualPointer].equals("")){
	    actualPointer++;
	    DigitoClickeado(i);
	    return;
	}

	digits_pantalla[actualPointer] = i;
	pantalla.setText(display());
    }

    public void DeleteDigit(){

	digits_pantalla[actualPointer] = "";

	if(actualPointer > 0)
	    actualPointer--;
	pantalla.setText(display());
    }

    public void OkButton() {
		for (int i = 0; i < digits_pantalla.length; i++) {
			if (digits_pantalla[i].equals("")) {
				pantalla.setText("ERROR... REINGRESAR:");
				resetPantalla();
				return;
			}
		}
			/*
			   TRY HACIA COMPRADOR
			*/
			try {
				panelDigitos.getPanelComprador().MandarSolicitudCompra(getActualID());
			}
			catch (NoExisteID e) {
				pantalla.setText("NO EXISTE ID");
				resetPantalla();
				return;
			}
			catch (PagoInsuficienteException e)
			{
				pantalla.setText("PAGO INSUFICIENTE");
				resetPantalla();
				return;
			}
			catch (NoHayProductoException e) {
				pantalla.setText("NO HAY PRODUCTO");
				resetPantalla();
				return;
			}
			catch (Exception e) {
				System.out.println(e);
			}

			procesandoCompra = false;
			resetPantalla();
			pantalla.setText("COMPRADO!");
    }

    public void resetPantalla(){
	for (int i = 0;i< digits_pantalla.length;i++) {
	    actualPointer = 0;
	    digits_pantalla[i] = "";
	}
    }

    public String display(){
	String aux = "";
	int margen = 4;

	for(int i = 0;i<digits_pantalla.length; i++){
	    aux += digits_pantalla[i];
	    for (int j = 0;j < margen ; j++) {
		aux += " ";
	    }
	}

	return aux;
    }
	public  int getActualID(){
		String aux = "";
		for (int i = 0; i < digits_pantalla.length;i++)
		{
			aux += digits_pantalla[i];
		}
		return Integer.valueOf(aux);
	}
}
	

