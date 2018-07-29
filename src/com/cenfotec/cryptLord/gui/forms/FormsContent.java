package com.cenfotec.cryptLord.gui.forms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum FormsContent {

	WRITE_KEY ("New Key Form",
		new ArrayList<String>(Arrays.asList(
			"Key name: "))),
	
	WRITE_MESSAGE ("New Message Form",
		new ArrayList<String>(Arrays.asList(
			"Key name:",
			"Message name:",
			"Message:"))),
	
	READMESSAGE ("Read Message Form",
		new ArrayList<String>(Arrays.asList(
			"Key name:",
			"Message name:")));
	
	private final String title;
	private final List<String> modules;
	
	private FormsContent(String title, List<String> modules) {
		this.title= title;
		this.modules = modules;
	}

	public String getTitle() {
		return title;
	}

	public String getModule(int vector) {
		return modules.get(vector);
	}
	
	public int getCompletion() {
		return modules.size();
	}
}
