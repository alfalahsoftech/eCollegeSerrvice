package com.fadsan.commom.util;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RandomPasswordUtil {
	
	public static String getRandomString() {
		String num = (String) UUID.randomUUID().toString().subSequence(0, 6);
		System.out.println("##### num="+num);
		String numm = num.replace("-", "");
		BCryptPasswordEncoder ec =new BCryptPasswordEncoder();
		System.out.println(ec.encode("1234"));
		return numm;
	}
	
	public static void main(String[] args) {
		System.out.println("output11=="+getRandomString());
		System.out.println("output22=="+getRandomString());
		System.out.println("output33=="+getRandomString());
		System.out.println("output44=="+getRandomString());
		System.out.println("output44=="+getRandomString());

		System.out.println("output55=="+getRandomString());
		System.out.println("output66=="+getRandomString());
		System.out.println("output77=="+getRandomString());
		System.out.println("output88=="+getRandomString());

	}

}
