package com.cenfotec.cryptLord.services.keys.implementations.asym;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

public class AsymKeyWriter {

	private ObjectOutputStream stream;
	
	public AsymKeyWriter(String fileName) throws Exception {
		
		FileOutputStream fileOutput = new FileOutputStream(fileName);
		stream = new ObjectOutputStream(new BufferedOutputStream(fileOutput));
	}
	
	public void writeBigInteger(BigInteger bigInt) throws Exception {
		
			stream.writeObject(bigInt);
	}

	public void close() throws Exception {
		
			stream.close();
	}
}
