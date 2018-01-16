package com.accolite.au.java.design.logger;

import java.io.IOException;

public class client {
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		try {
			logger.log();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
