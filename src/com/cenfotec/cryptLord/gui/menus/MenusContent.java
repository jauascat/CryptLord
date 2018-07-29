package com.cenfotec.cryptLord.gui.menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MenusContent {

	CRYPT_TYPE(
		"Escoger tipo de encriptacion",
		new ArrayList<String>(
			Arrays.asList(
			"1. Symetric",
			"2. Asymetric",
			"3. salir")),
		3
	),
	
	ALGORITHM_TYPE(
		"Escoger tipo algoritmo de encriptacion",
		new ArrayList<String>(
			Arrays.asList(
			"1. RSA",
			"2. ESA",
			"3. OTRO",
			"4. Salir")),
		4
	),
	
	
	MAIN_MENU(
		"Encriptar o desencriptar",
		new ArrayList<String>(
			Arrays.asList(
			"1. Create key",
			"2. Encript Message",
			"3. Decrypt Message",
			"4. Salir ")),
		4
	);
	
	private final String title;
	private final List<String>  options;
	private final int opcionSalida;
	
	private MenusContent(String title, List<String> options, int opcionSalida) {
		this.title= title;
		this.options= options;
		this.opcionSalida = opcionSalida;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}
	
	public int getOpcionSalida() {
		return opcionSalida;
	}
}
