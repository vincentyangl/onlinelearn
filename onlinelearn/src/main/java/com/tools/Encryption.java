package com.tools;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Encryption {


	
	public static String encryptionByMD5(String username,String password){
		String hashAlgorithName="MD5";
		Object salt=ByteSource.Util.bytes(username);
		int count=1024;
		Object result=new SimpleHash(hashAlgorithName, password,salt,count);
		return result.toString();
	}
	
	public static String EduByMD5(String password){
		String hashAlgorithName="MD5";
		Object salt=ByteSource.Util.bytes(password);
		int count=1024;
		Object result=new SimpleHash(hashAlgorithName, password,salt,count);
		return result.toString();
	}

	
}
