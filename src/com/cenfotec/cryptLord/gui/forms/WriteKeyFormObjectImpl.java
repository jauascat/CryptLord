package com.cenfotec.cryptLord.gui.forms;

public class WriteKeyFormObjectImpl extends FormStringObjectTemplate {

	private String key;

	@Override
	void loadStringField(final int loadPhase,final String fieldContent) {
		key = fieldContent;
	}

	public String getKey() {
		return key;
	}
}
