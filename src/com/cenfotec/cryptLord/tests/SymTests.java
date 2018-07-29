package com.cenfotec.cryptLord.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cenfotec.cryptLord.services.CryptLordFactory;
import com.cenfotec.cryptLord.services.CryptManager;
import com.cenfotec.cryptLord.services.keys.implementations.sym.SymKeyGenImpl;
import com.cenfotec.cryptLord.services.keys.implementations.sym.SymKeyReadImpl;
import com.cenfotec.cryptLord.services.keys.implementations.sym.SymKeyWriteImpl;
import com.cenfotec.cryptLord.services.messages.implementations.MssgReadImpl;
import com.cenfotec.cryptLord.services.messages.implementations.MssgWriteImpl;

public class SymTests {
	
	@Test
	public void SymetricMessageIO() throws Exception {
		
		String keyVector = "ArriGaLLaveSymetrica";
		String messageVector = "galapagos";
		String message = "mensaje de prueba con galapagos arrivederchi.";
		
		CryptManager manager = CryptLordFactory.symetric(
				new SymKeyGenImpl(new SymKeyWriteImpl()), 
				new MssgReadImpl(),
				new MssgWriteImpl(),
				new SymKeyReadImpl());
		
		manager.createKey(keyVector);
		manager.encryptMessage(messageVector, message, keyVector);
		
		assertEquals(message, manager.decryptMessage(messageVector, keyVector));
	}

}
