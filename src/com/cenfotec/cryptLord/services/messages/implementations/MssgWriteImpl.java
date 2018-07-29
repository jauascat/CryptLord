package com.cenfotec.cryptLord.services.messages.implementations;

import com.cenfotec.cryptLord.services.messages.MessageWriter;
import com.cenfotec.cryptLord.services.writers.FileWriteTypeImpl;

public class MssgWriteImpl implements MessageWriter {

	@Override
	public void write(String vector, byte[] data) throws Exception {
		
		FileWriteTypeImpl fileWrite = new FileWriteTypeImpl();
		fileWrite.write(vector, data);
	}
}
