package com.cenfotec.cryptLord.services.cyphers;

public interface WriteCypher {

	public void encryptMessage(String vector, String message) throws Exception;
}
