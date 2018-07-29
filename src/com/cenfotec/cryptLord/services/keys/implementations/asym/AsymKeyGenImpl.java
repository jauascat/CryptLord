package com.cenfotec.cryptLord.services.keys.implementations.asym;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.keys.KeyGenerator;

public class AsymKeyGenImpl implements KeyGenerator {

	private KeyFactory keyfactory;
	private KeyPair keyPair;
	
	public AsymKeyGenImpl() throws Exception {
		
		KeyPairGenerator pairGenerator =  KeyPairGenerator.getInstance(Props.algorithmName);
		pairGenerator.initialize(Props.asymetricKeySize());
		
		keyfactory = KeyFactory.getInstance(Props.algorithmName);
		keyPair = pairGenerator.genKeyPair();
	}
	
	@Override
	public Object getKeyGen() {
		return keyPair;
	}
	
	@Override
	public void loadKey(String path) throws Exception {
		
		savePublicKey(path);
		savePrivateKey(path); 
	}
	
	private void savePrivateKey(String name) throws Exception {
		
		saveKeyToFile(
			Props.getPrivateAsymetricPath(name),
			getPrivateKeySpec().getModulus(),
			getPrivateKeySpec().getPrivateExponent()
		);
	}

	private void savePublicKey(String name) throws Exception {
		
		saveKeyToFile(
			Props.getPublicAsymetricPath(name), 
			getPublicKeySpec().getModulus(),
			getPublicKeySpec().getPublicExponent()
		);
	}

	private void saveKeyToFile(String fileName, BigInteger modulus, BigInteger exponent) throws Exception {
		
		AsymKeyWriter stream = new AsymKeyWriter(fileName);
		stream.writeBigInteger(modulus);
		stream.writeBigInteger(exponent);
		stream.close();
	}
	
	private RSAPublicKeySpec getPublicKeySpec() throws Exception {
		
		return keyfactory.getKeySpec(keyPair.getPublic(), RSAPublicKeySpec.class);
	}
	
	private RSAPrivateKeySpec getPrivateKeySpec() throws Exception {

		return keyfactory.getKeySpec(keyPair.getPrivate(), RSAPrivateKeySpec.class);
	}
}
