package com.cenfotec.cryptLord.gui;

import com.cenfotec.cryptLord.gui.menus.AlgorithmMenu;
import com.cenfotec.cryptLord.services.CryptLord;

public class App {
	
	public static CryptLord manager;
	
	public static void main(String[] args) throws Exception {
		
		AlgorithmMenu primerMenu = new AlgorithmMenu();
		primerMenu.showItself();
    }
}
