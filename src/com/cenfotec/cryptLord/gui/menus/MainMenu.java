package com.cenfotec.cryptLord.gui.menus;

import com.cenfotec.cryptLord.gui.App;
import com.cenfotec.cryptLord.gui.forms.FormTemplate;
import com.cenfotec.cryptLord.gui.forms.ReadMssgForm;
import com.cenfotec.cryptLord.gui.forms.ReadMssgFormObjectImpl;
import com.cenfotec.cryptLord.gui.forms.WriteKeyForm;
import com.cenfotec.cryptLord.gui.forms.WriteKeyFormObjectImpl;
import com.cenfotec.cryptLord.gui.forms.WriteMssgForm;
import com.cenfotec.cryptLord.gui.forms.WriteMssgFormObjectImpl;

public class MainMenu extends Menu {

	public MainMenu() {
		super(MenusContent.MAIN_MENU);
	}

	@Override
	protected void execAction(int option) throws Exception {
		
		// every case:
		// 1. generates form
		// 2. captures form data
		// 3. manager acts accordingly
		switch(option) {
			
			case 1:
				readkey();
				break;
				
			case 2:
				readMessage();
				break;
				
			case 3:
				writeMessasge();
				break;

			default: break;
		}
	}

	private void writeMessasge() throws Exception {
		
		FormTemplate form = new WriteMssgForm();
		form.showItself();
		
		WriteMssgFormObjectImpl data = (WriteMssgFormObjectImpl) form.getData();
		
		if(data != null)
			App.manager.encryptMessage(
				data.getMessageName(),
				data.getMessage(),
				data.getKey());		
	}

	private void readMessage() throws Exception {
		
		FormTemplate form = new ReadMssgForm();
		form.showItself();
		
		ReadMssgFormObjectImpl data = (ReadMssgFormObjectImpl)form.getData();
		
		if(data != null)
			App.manager.decryptMessage(
				data.getMessageName(),
				data.getKey());		
	}

	private void readkey() throws Exception {
		
		FormTemplate form = new WriteKeyForm();
		form.showItself();
		
		WriteKeyFormObjectImpl data = (WriteKeyFormObjectImpl)form.getData();
		
		if(data != null)
			App.manager.createKey(data.getKey());
	}
}
