package com.cenfotec.cryptLord.services.cyphers.implementations;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.cyphers.ReadBuilder;
import com.cenfotec.cryptLord.services.cyphers.ReadCypher;
import com.cenfotec.cryptLord.services.keys.KeyReader;
import com.cenfotec.cryptLord.services.messages.MessageReader;

public class ReadCypherImpl implements ReadCypher {

	public static class ReadBuilderCypher implements ReadBuilder {
		
		private KeyReader keyreader;
		private MessageReader messageReader;

		public ReadBuilderCypher() {}
		
		@Override
		public ReadBuilder keyReader(KeyReader keyReader) {
			this.keyreader = keyReader;
			return this;
		}
		
		@Override
		public ReadBuilder messageReader(MessageReader messageReader) {
			this.messageReader = messageReader;
			return this;
		}

		@Override
		public ReadCypherImpl build(String keyName) throws Exception {
			
			Cipher cipher = Cipher.getInstance(Props.algorithmName);
			cipher.init(Cipher.DECRYPT_MODE, keyreader.readKey(keyName));
			return new ReadCypherImpl(cipher, messageReader);
		}
	}
	
	private Cipher cipher;
	private MessageReader messageReader;

	private ReadCypherImpl(Cipher cipher, MessageReader messagerReader) throws Exception {
		
		this.cipher = cipher;
		this.messageReader = messagerReader;
	}
	
	@Override
	public String decryptMessage(String vector) throws Exception {
		
		byte[] data = messageReader.read(vector);
		return new String(cipher.doFinal(data), StandardCharsets.UTF_8);
	}
}
