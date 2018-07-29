package com.cenfotec.cryptLord.services.writers;

import java.io.FileOutputStream;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.keys.SymetricKeyWriter;

public class FileWriteTypeImpl implements SymetricKeyWriter, FileWriter {
	
	@Override
	public void write(String vector, byte[] data) throws Exception {
		
		hookWrite(vector, data);
	}

	@Override
	public void writeSymetricKey(String vector, byte[] key) throws Exception {
		hookWrite(vector, key);		
	}

	private void hookWrite(String vector, byte[] data) throws Exception {
		
		StringBuilder path = new StringBuilder();
		path.append(Props.currentPath);
		path.append(vector);
		path.append(Props.keyExtension());
		
		FileOutputStream outStream = new FileOutputStream(path.toString());
		outStream.write(data);
		outStream.close();
	}
}
