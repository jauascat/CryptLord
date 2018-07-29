package com.cenfotec.cryptLord.services.keys;

public interface KeyGenerator {

	public void loadKey(String vector) throws Exception;
	
	public Object getKeyGen() throws Exception;
}
