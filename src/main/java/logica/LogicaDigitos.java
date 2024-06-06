package logica;

import visual.PanelDigitos;

import javax.swing.*;
import java.awt.event.*;

/**
 * Clase que gestiona la lógica detrás de la interacción con los dígitos en la interfaz.
 */
public class LogicaDigitos implements ActionListener{

	private PanelDigitos panelDigitos;
	private int actualPointer = 0;
	private String[] digits_pantalla = {"","","",""};
	private JLabel pantalla;

	/** Variable que indica si se está procesando una compra actualmente. */
	public static boolean  procesandoCompra = false;

	/**
	 * Constructor de la clase LogicaDigitos.
	 *
	 * @param l Etiqueta de la pantalla de dígitos.
	 * @param p Panel de dígitos asociado.
	 */
	public LogicaDigitos(JLabel l, PanelDigitos p){
		panelDigitos = p;
		pantalla = l;
		l.setText("ID DEL PRODUCTO:");
	}

	/**
	 * Maneja los eventos de clic en los botones de dígitos.
	 *
	 * @param e Evento de acción generado.
	 */
	public void actionPerformed(ActionEvent e){
		if(procesandoCompra)
			return;

		for(int i = 0; i < 10; i++){
			String aux = i + "";
			if(aux.equals(e.getActionCommand())){
				digitoClickeado(aux);
			}
		}

		if("10".equals(e.getActionCommand())){
			deleteDigit();
		}
		if("11".equals(e.getActionCommand())){
			okButton();
		}
	}

	/**
	 * Maneja un clic en un dígito.
	 *
	 * @param i Dígito clickeado.
	 */
	public void digitoClickeado(String i)
	{
		if(actualPointer >= digits_pantalla.length){
			actualPointer--;
			return;
		}

		if(!digits_pantalla[actualPointer].equals("")){
			actualPointer++;
			digitoClickeado(i);
			return;
		}

		digits_pantalla[actualPointer] = i;
		pantalla.setText(display());
	}

	/** Elimina el último dígito ingresado. */
	public void deleteDigit(){

		digits_pantalla[actualPointer] = "";

		if(actualPointer > 0)
			actualPointer--;
		pantalla.setText(display());
	}

	/** Procesa la solicitud cuando se presiona el botón OK. */
	public void okButton() {
		for (int i = 0; i < digits_pantalla.length; i++) {
			if (digits_pantalla[i].equals("")) {
				pantalla.setText("ERROR... REINGRESAR:");
				resetPantalla();
				return;
			}
		}

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
			if(e.getMessage().equals("Primero saque el producto anterior"))
			{
				pantalla.setText("RETIRE EL PRODUCTO");
				procesandoCompra = true;
				resetPantalla();
				return;
			}

			return;
		}

		procesandoCompra = false;
		resetPantalla();
		pantalla.setText("COMPRADO!");
	}

	/** Reinicia la pantalla de dígitos. */
	public void resetPantalla(){
		for (int i = 0;i< digits_pantalla.length;i++) {
			actualPointer = 0;
			digits_pantalla[i] = "";
		}
	}

	/**
	 * Genera la cadena de texto a mostrar en la pantalla de dígitos.
	 *
	 * @return Cadena de texto formateada.
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
	 * Obtiene el ID actual formado por los dígitos ingresados.
	 *
	 * @return ID actual.
	 */
	public int getActualID(){
		String aux = "";
		for (int i = 0; i < digits_pantalla.length;i++)
		{
			aux += digits_pantalla[i];
		}
		return Integer.valueOf(aux);
	}
}
