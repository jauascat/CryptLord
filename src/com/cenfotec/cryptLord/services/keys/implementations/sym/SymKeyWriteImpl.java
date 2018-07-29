package com.cenfotec.cryptLord.services.keys.implementations.sym;

import com.cenfotec.cryptLord.services.keys.SymetricKeyWriter;
import com.cenfotec.cryptLord.services.writers.FileWriteTypeImpl;

public class SymKeyWriteImpl implements SymetricKeyWriter {

	@Override
	public void writeSymetricKey(String vector, byte[] key) throws Exception {
		
		FileWriteTypeImpl writer = new FileWriteTypeImpl();
		writer.write(vector, key);
	}
}
