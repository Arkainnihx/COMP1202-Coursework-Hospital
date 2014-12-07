package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;

public class FileController {
	private File selectedFile = null;
	
	public void saveFile(String fileName, String[] data) {
		if (!fileName.endsWith(".txt")) {
			fileName += ".txt";
		}
		selectedFile = new File(fileName);
		// TODO Start here
	}
	
	public String[] loadFile(String fileName) {
		
	}
}
