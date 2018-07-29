package com.cenfotec.cryptLord.services.keys.implementations.asym;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.keys.AsymetricPrivateKeyReader;

public class AsymPrivateKeyReadImpl implements AsymetricPrivateKeyReader {

	RSAPublicKeySpec keySpec;
	
	@Override
	public Key readKey(String keyFileName) throws Exception {
		
		InputStream in = new FileInputStream (Props.asymetricPath() + keyFileName + "private.key");
		ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(in));
		
	    BigInteger modulus = (BigInteger) inputStream.readObject();
	    BigInteger exponent = (BigInteger) inputStream.readObject();  
		keySpec = new RSAPublicKeySpec(modulus, exponent);
		
		inputStream.close();
		return generateAsymKey();
	}

	public byte[] generateKey() throws Exception {
		
		return generateAsymKey().getEncoded();
	}
	
	public Key generateAsymKey() throws Exception {
		
		return KeyFactory.getInstance(Props.algorithmName).generatePrivate(keySpec);
	}
}
