package com.cenfotec.cryptLord.gui.forms;

public class ReadMssgFormObjectImpl extends FormStringObjectTemplate {

	private String key;
	private String messageName;
	
	@Override
	void loadStringField(int loadPhase, String fieldContent) {
		
		switch(loadPhase) {
		
		case 1: key 		= fieldContent; break;
		case 2: messageName = fieldContent; break;
		default: break;
		
		}
	}
	
	public String getKey() {
		return key;
	}

	public String getMessageName() {
		return messageName;
	}
}
