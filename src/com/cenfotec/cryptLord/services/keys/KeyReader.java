package com.cenfotec.cryptLord.services.keys;

import java.security.Key;

public interface KeyReader {

	public Key readKey(String keyName) throws Exception;
}
