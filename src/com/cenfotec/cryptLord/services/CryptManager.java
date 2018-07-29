package com.cenfotec.cryptLord.services;

public interface CryptManager {

	public void createKey(String vector) throws Exception;
	
	public String decryptMessage(String messageVector, String keyVector) throws Exception;
	
	public void encryptMessage(String messageVector, String message, String keyVector) throws Exception;
}
