package com.cenfotec.cryptLord.services;

import com.cenfotec.cryptLord.services.cyphers.ReadBuilder;
import com.cenfotec.cryptLord.services.cyphers.WriteBuilder;
import com.cenfotec.cryptLord.services.cyphers.implementations.ReadCypherImpl;
import com.cenfotec.cryptLord.services.cyphers.implementations.WriteCypherImpl;
import com.cenfotec.cryptLord.services.keys.AsymetricPrivateKeyReader;
import com.cenfotec.cryptLord.services.keys.AsymetricPublicKeyReader;
import com.cenfotec.cryptLord.services.keys.KeyGenerator;
import com.cenfotec.cryptLord.services.keys.KeyReader;
import com.cenfotec.cryptLord.services.keys.SymetricKeyReader;
import com.cenfotec.cryptLord.services.messages.MessageReader;
import com.cenfotec.cryptLord.services.messages.MessageWriter;

public class CryptLordFactory {

	public static CryptLord aSymetric(
			KeyGenerator key, MessageReader MssgReader, MessageWriter mssgWriter,
			AsymetricPublicKeyReader publicKReader, AsymetricPrivateKeyReader privateKReader) {
		
		ReadBuilder read = genReadBuilder(privateKReader, MssgReader);
		WriteBuilder write = genWriteBuilder(publicKReader, mssgWriter);

		return new CryptLord(key, read, write);
	}
	
	
	public static CryptLord symetric(
			KeyGenerator key, MessageReader MssgReader, MessageWriter mssgWriter,
			SymetricKeyReader keyreader) {
		
		ReadBuilder read = genReadBuilder(keyreader, MssgReader);
		WriteBuilder write = genWriteBuilder(keyreader, mssgWriter);

		return new CryptLord(key, read, write);
	}

	private static ReadBuilder genReadBuilder(KeyReader keyReader, MessageReader mssgReader) {
		return new ReadCypherImpl.ReadBuilderCypher().keyReader(keyReader).messageReader(mssgReader);
	}
	
	private static WriteBuilder genWriteBuilder(KeyReader keyReader, MessageWriter mssgReader) {
		return new WriteCypherImpl.WriteBuilderCypher().keyReader(keyReader).messageWriter(mssgReader);
	}
}
