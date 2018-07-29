package com.cenfotec.cryptLord.gui.forms;

public abstract class FormStringObjectTemplate {

	private int loadPhase;
	
	public FormStringObjectTemplate() {
		loadPhase = 1;
	}
	
	public void loadString(String fieldContent) {
		
		loadStringField(loadPhase, fieldContent);
		++loadPhase;
	}

	abstract void loadStringField(final int loadPhase, final String fieldContent);
}
