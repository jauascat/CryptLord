package com.cenfotec.cryptLord.services.keys.implementations.sym;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.keys.SymetricKeyReader;

public class SymKeyReadImpl implements SymetricKeyReader {

	@Override
	public Key readKey(String keyName) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(Props.symetricPath() + keyName + ".key"));
		String everything = "";
	    StringBuilder stringbuilder = new StringBuilder();
	    String line = reader.readLine();
	    
	    while (line != null) {
	        stringbuilder.append(line);
	        line = reader.readLine();
	    }
	    reader.close();
	    
	    everything = stringbuilder.toString();
		return new SecretKeySpec(everything.getBytes(StandardCharsets.UTF_8),"AES");
	}
}
