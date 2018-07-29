package com.cenfotec.cryptLord.services;

import com.cenfotec.cryptLord.services.cyphers.ReadBuilder;
import com.cenfotec.cryptLord.services.cyphers.ReadCypher;
import com.cenfotec.cryptLord.services.cyphers.WriteBuilder;
import com.cenfotec.cryptLord.services.cyphers.WriteCypher;
import com.cenfotec.cryptLord.services.keys.KeyGenerator;

public class CryptLord implements CryptManager {

	private KeyGenerator keyGen;
	private  ReadBuilder readBuilder;
	private WriteBuilder writeBuilder;

	public CryptLord (KeyGenerator key, ReadBuilder read, WriteBuilder write) {
		keyGen = key;
		readBuilder = read;
		writeBuilder = write;
	}

	public void createKey(String name) throws Exception {
		
		keyGen.loadKey(name);
	}
	
	public String decryptMessage(String messageName, String keyName) throws Exception {
		
		ReadCypher cypherReader = readBuilder.build(keyName);
		return cypherReader.decryptMessage(messageName);
	}
	
	public void encryptMessage(String messageName, String message, String keyName) throws Exception {
		
		WriteCypher cypherWriter = writeBuilder.build(keyName);
		cypherWriter.encryptMessage(messageName, message);
	}
}
