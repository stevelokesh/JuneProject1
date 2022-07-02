package com.maven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Sampleprop {

	public static void readProp() throws IOException {

		FileReader read = new FileReader(
				"C:\\\\Users\\\\User\\\\eclipse-workspace\\\\SampleProject\\\\Config.Properties");
		Properties prop = new Properties();
		prop.load(read);
		String user = prop.getProperty("username");
		System.out.println(user);
		String pass = prop.getProperty("password");
		System.out.println(pass);
	}

	public static void reuseableProp(String key) throws IOException {

		FileReader read = new FileReader("C:\\Users\\User\\eclipse-workspace\\SampleProject\\Config.Properties");
		Properties prop = new Properties();
		prop.load(read);
		String user = prop.getProperty(key);
		System.out.println(user);
	}

	public static void main(String[] args) throws IOException {

		readProp();

	}

}
