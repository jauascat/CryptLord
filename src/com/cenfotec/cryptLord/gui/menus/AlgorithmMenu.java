package com.cenfotec.cryptLord.gui.menus;

import com.cenfotec.cryptLord.gui.Props;

public class AlgorithmMenu extends Menu {

	public AlgorithmMenu() {
		super(MenusContent.ALGORITHM_TYPE);
	}

	@Override
	protected void execAction(int option) throws Exception {

		switch(option) {
		
		case 1:
			Props.algorithmName = "RSA";
			subMenu();
			break;
		case 2:
			Props.algorithmName = "ESA";
			subMenu();
			break;
		case 3:
			Props.algorithmName = "ESA";
			subMenu();
			break;
		default: 
			break;
		}
	}
	
	private void subMenu() throws Exception {
		CriptMenu subMenu = new CriptMenu();
		subMenu.showItself();
	}
}
