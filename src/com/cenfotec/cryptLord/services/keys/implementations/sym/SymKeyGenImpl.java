package com.cenfotec.cryptLord.services.keys.implementations.sym;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.keys.KeyGenerator;
import com.cenfotec.cryptLord.services.keys.SymetricKeyWriter;

public class SymKeyGenImpl implements KeyGenerator {

	SymetricKeyWriter writer;
	
	public SymKeyGenImpl(SymetricKeyWriter writer) {
		this.writer = writer;
	}
	
	@Override
	public Object getKeyGen() throws Exception {
		return generateSymetricKey();
	}
	
	@Override
	public void loadKey(String vector) throws Exception {
		
		writer.writeSymetricKey(vector, generateSymetricKey());		
	}
	
	public byte[] generateSymetricKey() throws Exception {

		StringBuilder randomkey = new StringBuilder();
		for (int i = 0;i < Props.symetricKeySize();i++)
			
			randomkey.append(
				Integer.parseInt(
					Double.toString(
						(Math.random()+0.1)*1000).substring(0,2)));
		
		return randomkey.toString().getBytes("UTF-8");
	}

}
