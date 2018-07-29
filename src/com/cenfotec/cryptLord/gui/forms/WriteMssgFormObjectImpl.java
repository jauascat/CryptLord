package com.cenfotec.cryptLord.gui.forms;

public class WriteMssgFormObjectImpl 
extends FormStringObjectTemplate {

	private String key;
	private String messageName;
	private String message;
	
	@Override
	void loadStringField(int loadPhase, String fieldContent) {
		
		switch(loadPhase) {
			
		case 1: key 		= fieldContent; break;
		case 2: messageName = fieldContent; break;
		case 3: message 	= fieldContent; break;
		default: break;
		
		}
	}

	public String getKey() {
		return key;
	}

	public String getMessageName() {
		return messageName;
	}

	public String getMessage() {
		return message;
	}
}
