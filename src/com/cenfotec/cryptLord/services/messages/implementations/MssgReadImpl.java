package com.cenfotec.cryptLord.services.messages.implementations;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

import com.cenfotec.cryptLord.gui.Props;
import com.cenfotec.cryptLord.services.messages.MessageReader;

public class MssgReadImpl implements MessageReader {

	@Override
	public byte[] read(String name) throws Exception {
		
		StringBuilder path = new StringBuilder(Props.currentPath);
		path.append(name);
		path.append(Props.criptExtension());
		
		File file = new File(path.toString());
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        
        reader.read(bytes, 0, length);
        reader.close();
		return Base64.getDecoder().decode(bytes);
	}

}
