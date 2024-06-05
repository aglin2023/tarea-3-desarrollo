package logica;
import visual.PanelDigitos;

import javax.swing.*;
import java.awt.event.*;

/**
 * clase que maneja la logica del ingreso de digitos para la compra de un producto
 */
public class LogicaDigitos implements ActionListener{

	private PanelDigitos panelDigitos;
    private int actualPointer = 0;
    private String[] digits_pantalla = {"","","",""};
    private JLabel pantalla;

    boolean procesandoCompra = false;

	/**
	 * constructor de la clase
	 * @param l jlabel que muestra la entrada de digitos
	 * @param p variable que contiene la interfaz de entrada
	 */
	public LogicaDigitos(JLabel l, PanelDigitos p){
		panelDigitos = p;
		pantalla = l;
		l.setText("ID DEL PRODUCTO:");
    }

	/**
	 * metodo que maneja los eventos de accion
	 * @param e evento que se realiza al hacer un clic en un boton
	 */
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

	/**
	 * metodo que maneja la accion de hacer clic sobre un digito
	 * @param i el digito que se presionó
	 */
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

	/**
	 * metodo que permite eliminar los digitos presionados
	 */
    public void DeleteDigit(){

	digits_pantalla[actualPointer] = "";

	if(actualPointer > 0)
	    actualPointer--;
	pantalla.setText(display());
    }

	/**
	 * metodo que permite la accion de un boton de corfirmar los digitos ingresados
	 */
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

	/**
	 * metodo que reinicia la pantalla de los digitos
	 */
    public void resetPantalla(){
	for (int i = 0;i< digits_pantalla.length;i++) {
	    actualPointer = 0;
	    digits_pantalla[i] = "";
	}
    }

	/**
	 * metodo que muestra los digitos ingresados en una pantalla
	 * @return string con los digitos ingresados
	 */
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

	/**
	 * metodo que obtiene el id ingresado actualmente
	 * @return el id ingresado en forma de int
	 */
	public  int getActualID(){
		String aux = "";
		for (int i = 0; i < digits_pantalla.length;i++)
		{
			aux += digits_pantalla[i];
		}
		return Integer.valueOf(aux);
	}
}
	

