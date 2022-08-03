package controller.supporter.signupEncrypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypto {
	
	public String encrypt(String plainText) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(plainText.getBytes());
		
		return bytesToHex(md.digest());
	}
	private String bytesToHex(byte[] encryptTextByte) {
        StringBuilder encryptText = new StringBuilder();
        for (byte b : encryptTextByte) {
        	encryptText.append(String.format("%02x", b));
        }
        return encryptText.toString();
    }
}
