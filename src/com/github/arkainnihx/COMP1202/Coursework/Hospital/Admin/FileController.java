package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileController {
	private String selectedFile = null;
	
	public FileController(String fileName) {
		selectedFile = (!fileName.endsWith(".txt") ? (fileName + ".txt") : fileName);
	}
	
	public boolean saveFile(String[] data) {
		try {
			PrintWriter fileSave = new PrintWriter(selectedFile);
			for (String line : data) {
				fileSave.println(line);
			}
			fileSave.flush();
			fileSave.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String[] loadFile() {
		try {
			BufferedReader fileLoad = new BufferedReader(new FileReader(selectedFile));
			ArrayList<String> dataList = new ArrayList<String>();
			while (fileLoad.ready()) {
				dataList.add(fileLoad.readLine());
			}
			fileLoad.close();
			return (String []) dataList.toArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}