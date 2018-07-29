package com.cenfotec.cryptLord.gui.menus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuOptionReader {

	private int opcionesDisponibles;
	private BufferedReader reader;
	
	protected MenuOptionReader(int opcionesDisponibles) {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.opcionesDisponibles = opcionesDisponibles;	
	}

	public int read() throws Exception {
		
		String optionString = reader.readLine();
		int optionInteger = 0;
		
		if(validarEsNumero(optionString)) {
			
			optionInteger = Integer.parseInt(optionString);
			if(validarEsOpcionValida(optionInteger))
				
				return optionInteger;
			else
				return 0;
		}
		else
			return 0;
	}
	
	private boolean validarEsNumero(String optionString) {
		
		if(optionString.equals("\\d")) 
			return true;
		else
			return false;
	}
	
	private boolean validarEsOpcionValida(int option) {
		
		if(option >= 1 && option <= opcionesDisponibles) 
			return true;
		else
			return false;
	}
}
