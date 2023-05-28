package codeacademy.learnintermediatejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileIntroduction {

	public static void main(String[] args) throws IOException {
		//Pruebas con FileInputStream
		int counter = 0;
		String path = "c:/tmp/input.txt";

		FileInputStream fis = new FileInputStream(path);
		//InputStream fis = FileIntroduction.class.getResourceAsStream("input.txt");
		while ((counter = fis.read()) != -1) {
			// Print each character
			System.out.print((char) counter);
		}

		fis.close();
		
		//Pruebas con FileOutputStream
		FileOutputStream fos = new FileOutputStream("c:/tmp/output.txt");
	    String outputText = "Somos nuestras decisiones --Jean-Paul Sartre.";
	    byte[] outputTextInBytes = outputText.getBytes();
	    fos.write(outputTextInBytes);
	    fos.close();
	}

}
