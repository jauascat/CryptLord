package com.cenfotec.cryptLord.services.keys;

public interface SymetricKeyWriter extends KeyWriter {
	
	public void writeSymetricKey(String vector, byte[] key) throws Exception;
}
