package com.cenfotec.cryptLord.services.cyphers;

import com.cenfotec.cryptLord.services.keys.KeyReader;
import com.cenfotec.cryptLord.services.messages.MessageReader;

public interface ReadBuilder {

	public ReadBuilder keyReader(KeyReader reader);
	
	public ReadBuilder messageReader(MessageReader messageReader);
	
	public ReadCypher build(String keyName) throws Exception;
}
