package com.cenfotec.cryptLord.services.messages;

public interface MessageWriter {

	public void write(String vector, byte[] data) throws Exception;
}
