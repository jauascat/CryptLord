package com.cenfotec.cryptLord.services.cyphers;

import com.cenfotec.cryptLord.services.keys.KeyReader;
import com.cenfotec.cryptLord.services.messages.MessageWriter;

public interface WriteBuilder {

	public WriteBuilder keyReader(KeyReader reader);
	
	public WriteBuilder messageWriter(MessageWriter writer);
	
	public WriteCypher build(String keyName) throws Exception;
}
