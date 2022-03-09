package com.example.task12_spring_lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

@Component
public class FileHandler {
	private final String filenameIn = "D:\\_Projects\\_Mirea\\JavaPatternMirea\\task12_spring_lifecycle\\src\\main\\resources\\java_task_12_in.txt";
	private final String filenameOut = "D:\\_Projects\\_Mirea\\JavaPatternMirea\\task12_spring_lifecycle\\src\\main\\resources\\java_task_12_out.txt";
	private String hash;

	@PostConstruct
	public void readInputFile() {
		try {
			File input = new File(filenameIn);
			String fileContent = getInputContent(input);
			hash = getHash(fileContent);

//			deleteFile(input);
		} catch (Exception exception) {
			exception.printStackTrace();
			hash = "null";
		}
	}

	private static String getInputContent(File input) throws FileNotFoundException {
		Scanner scanner = new Scanner(input);
		StringBuilder fileContent = new StringBuilder();
		while (scanner.hasNextLine()) {
			fileContent.append(scanner.nextLine());
		}
		return fileContent.toString();
	}

	private static boolean deleteFile(File file) {
		return file.delete();
	}

	private static String getHash(String data) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = md.digest(data.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			return no.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
	}

	@PreDestroy
	public void writeOutputFile() {
		try {
			FileWriter output = new FileWriter(filenameOut);
			output.write(hash);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
