package com.cenfotec.cryptLord.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cenfotec.cryptLord.services.CryptLordFactory;
import com.cenfotec.cryptLord.services.CryptManager;
import com.cenfotec.cryptLord.services.keys.implementations.asym.AsymKeyGenImpl;
import com.cenfotec.cryptLord.services.keys.implementations.asym.AsymPrivateKeyReadImpl;
import com.cenfotec.cryptLord.services.keys.implementations.asym.AsymPublicKeyReadImpl;
import com.cenfotec.cryptLord.services.messages.implementations.MssgReadImpl;
import com.cenfotec.cryptLord.services.messages.implementations.MssgWriteImpl;

public class AsymTests {

	@Test
	public void AsymetricMessageIO() throws Exception {
		
		String keyVector = "larvaLLaveAsymetrica";
		String messageVector = "larvaleim";
		String message = "cluster bork party raid on the horizon";
		
		CryptManager manager = CryptLordFactory.aSymetric(
				new AsymKeyGenImpl(), 
				new MssgReadImpl(),
				new MssgWriteImpl(),
				new AsymPublicKeyReadImpl(),
				new AsymPrivateKeyReadImpl());
		
		manager.createKey(keyVector);
		manager.encryptMessage(messageVector, message, keyVector);
		
		assertEquals(message, manager.decryptMessage(messageVector, keyVector));
	}

}
