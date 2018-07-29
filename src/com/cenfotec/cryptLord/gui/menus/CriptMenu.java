package com.cenfotec.cryptLord.gui.menus;

import com.cenfotec.cryptLord.gui.App;
import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.CryptLordFactory;
import com.cenfotec.cryptLord.services.keys.implementations.asym.AsymKeyGenImpl;
import com.cenfotec.cryptLord.services.keys.implementations.asym.AsymPrivateKeyReadImpl;
import com.cenfotec.cryptLord.services.keys.implementations.asym.AsymPublicKeyReadImpl;
import com.cenfotec.cryptLord.services.keys.implementations.sym.SymKeyGenImpl;
import com.cenfotec.cryptLord.services.keys.implementations.sym.SymKeyReadImpl;
import com.cenfotec.cryptLord.services.keys.implementations.sym.SymKeyWriteImpl;
import com.cenfotec.cryptLord.services.messages.implementations.MssgReadImpl;
import com.cenfotec.cryptLord.services.messages.implementations.MssgWriteImpl;

public class CriptMenu extends Menu {

	public CriptMenu() {
		super(MenusContent.CRYPT_TYPE);
	}

	@Override
	protected void execAction(int option) throws Exception {
		
		// instantiates main encription manager with 
		// 		combination of implementations of interfaces for:
		//
		// 1. key generation
		// 2. key IO (for asymetric encription key IO is somewhat coupled with key generation)
		// 3. message IO
		switch(option) {
			
			case 1:
				Props.currentPath = Props.symetricPath();
				App.manager = CryptLordFactory.symetric(
						new SymKeyGenImpl(new SymKeyWriteImpl()),
						new MssgReadImpl(),
						new MssgWriteImpl(),
						new SymKeyReadImpl());
				subMenu();
				break;
				
			case 2:
				Props.currentPath = Props.asymetricPath();
				App.manager = CryptLordFactory.aSymetric(
						new AsymKeyGenImpl(), 
						new MssgReadImpl(),
						new MssgWriteImpl(),
						new AsymPublicKeyReadImpl(),
						new AsymPrivateKeyReadImpl());
				subMenu();
				break;

			default: break;
		}
	}

	private void subMenu() throws Exception {
		MainMenu subMenu = new MainMenu();
		subMenu.showItself();
	}
}
