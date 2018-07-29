package com.cenfotec.cryptLord.services.cyphers.implementations;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.cyphers.WriteBuilder;
import com.cenfotec.cryptLord.services.cyphers.WriteCypher;
import com.cenfotec.cryptLord.services.keys.KeyReader;
import com.cenfotec.cryptLord.services.messages.MessageWriter;

public class WriteCypherImpl implements WriteCypher {

	public static class WriteBuilderCypher implements WriteBuilder {
		
		private MessageWriter messageWriter;
		private KeyReader keyReader;
		
		public WriteBuilderCypher() {}
		
		@Override
		public WriteBuilder keyReader(KeyReader keyReader) {
			this.keyReader = keyReader;
			return this;
		}
		
		@Override
		public WriteBuilder messageWriter(MessageWriter messageWriter) {
			this.messageWriter = messageWriter;
			return this;
		}
		
		@Override
		public WriteCypherImpl build(String keyName) throws Exception {
			
			Cipher cipher = Cipher.getInstance(Props.algorithmName);
			cipher.init(Cipher.ENCRYPT_MODE, keyReader.readKey(keyName));
			return new WriteCypherImpl(cipher, messageWriter);
		}
	}
	
	private Cipher cipher;
	private MessageWriter messageWriter;

	private WriteCypherImpl(Cipher cipher, MessageWriter messageWriter) throws Exception {
		
		this.cipher = cipher;
		this.messageWriter = messageWriter;
	}
	
	@Override
	public void encryptMessage(String vector, String message) throws Exception {
		
		byte[] data = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
		messageWriter.write(vector, data);
	}
}
