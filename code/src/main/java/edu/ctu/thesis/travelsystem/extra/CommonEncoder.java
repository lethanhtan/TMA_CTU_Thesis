package edu.ctu.thesis.travelsystem.extra;

import org.apache.commons.codec.binary.Base64;

public class CommonEncoder {
	public static void main(String[] args) {
		String str1 = "12345";
		String str2 = "ABCDEF1291272";
		Base64 b64 = new Base64();
		byte[] byteEncoded = b64.encode(str2.getBytes());
		byte[] valueDecoded = b64.decode(byteEncoded);
		System.out.println(new String(byteEncoded));
		System.out.println(new String(valueDecoded));
		//System.out.println(b64.decode(str2));
		//System.out.println(b64.encodeToString(b64.decode(str2)));
	}
}
