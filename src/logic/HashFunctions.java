package logic;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class HashFunctions {
	public static String getHash(byte[] inputBytes) {
		String hashValue ="";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(inputBytes);
			byte[] digestedBytes = messageDigest.digest();
			hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return hashValue;
	}
	public static void main(String[] args) {
		String test = "This is a test";
		System.out.println(getHash(test.getBytes()));
		System.out.println(getHash("matheo".getBytes()));
		
	}
}
