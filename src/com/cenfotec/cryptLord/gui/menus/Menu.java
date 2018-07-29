package com.cenfotec.cryptLord.gui.menus;

public abstract class Menu {

	private MenusContent content;
	private MenuOptionReader reader;
	
	public Menu(MenusContent contenido) {
		this.content = contenido;
		reader = new MenuOptionReader(contenido.getOptions().size());
	}
	
	public void showItself() throws Exception {
		int option = 0;
		do {
			
			printOptions();
			option = reader.read();
			hookExecAction(option);
			
		} while(option != content.getOpcionSalida());
	}
	
	private void hookExecAction(int option) throws Exception {
		
		if(option == 0)
			System.out.println("La opcion no es valida");
		else
			execAction(option);
	}
	
	protected abstract void execAction(int option) throws Exception;
	
	private void printOptions() {
		for(String opcionMenu : content.getOptions()) 
			System.out.println(opcionMenu);
	}	
}
