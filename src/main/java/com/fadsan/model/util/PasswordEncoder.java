package com.fadsan.model.util;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class PasswordEncoder {

	public static String getEcodedPassword(String oldpassword) {
		MessageDigestPasswordEncoder ms = new MessageDigestPasswordEncoder(
				"MD5");
		return ms.encodePassword(oldpassword, null);
	
}
}