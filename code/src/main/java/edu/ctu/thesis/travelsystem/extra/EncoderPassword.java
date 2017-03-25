package edu.ctu.thesis.travelsystem.extra;

import org.apache.commons.codec.binary.Base64;

public class EncoderPassword {
	Base64 b64 = new Base64();
	
	public String enCoded(String str) {
		byte[] byteEncoded = b64.encode(str.getBytes());
		return new String(byteEncoded);
	}
	
	public String deCoded(String encodedValue) {
		byte[] tmp = encodedValue.getBytes();
		byte[] valueDecoded = b64.decode(tmp);
		return new String(valueDecoded);
	}
}
