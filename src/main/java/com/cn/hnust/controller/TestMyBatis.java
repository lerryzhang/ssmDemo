package com.cn.hnust.controller;

import org.apache.shiro.crypto.hash.SimpleHash;

public class TestMyBatis {

	public static void main(String args[]) {

		String hashAlgorithmName = "MD5";
		String credentials = "123456";
		int hashIterations = 1024;
		Object obj = new SimpleHash(hashAlgorithmName, credentials, null,
				hashIterations);
		System.out.println(obj);

	}

}
