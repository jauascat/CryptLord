package com.cenfotec.cryptLord.gui;

public class Props {

	public static String algorithmName = "ESA";
	public static String currentPath = "C:/encrypt/symetric/";

	public static String symetricPath() {
		return "C:/encrypt/symetric/";
	}
	
	public static int symetricKeySize() {
		return 8;
	}
	
	public static String asymetricPath() {
		return "C:/encrypt/asymetric/";
	}
	
	public static String criptExtension() {
		return ".encript";
	}
	
	public static String keyExtension() {
		return ".key";
	}

	public static int asymetricKeySize() {
		return 2048;
	}

	public static String getPublicAsymetricPath(String name) {
		return Props.asymetricPath() + name + "public.key";
	}
	
	public static String getPrivateAsymetricPath(String name) {
		return Props.asymetricPath() + name + "private.key";
	}
}
