package com.cenfotec.cryptLord.gui.forms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class FormTemplate {

	private FormsContent content;
	private FormStringObjectTemplate formObject;
	private int stageOfCompletion;
	
	public FormTemplate(FormsContent content, FormStringObjectTemplate objectTemplate) {
		this.content = content;
		this.formObject = objectTemplate;
		this.stageOfCompletion = 1;
	}
	
	public void showItself() throws Exception {
		System.out.println(content.getTitle());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int completion = content.getCompletion();
		String answers = "";
		
		do {
			
			do {
				
				answers = "";
				showNextModule();
				answers = reader.readLine();
				
				
			} while (answers.isEmpty());
			
			formObject.loadString(answers);;
			++stageOfCompletion;
			
		} while (stageOfCompletion <= completion);
		
		reader.close();
	}
	
	private void showNextModule() {
		
		String line = content.getModule(stageOfCompletion);
		System.out.println(line);
		System.out.println();
	}
	
	public FormStringObjectTemplate getData() {
		return formObject;
	}
	
}
