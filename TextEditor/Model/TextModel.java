package Model;

import java.io.*;

import javax.swing.*;

public class TextModel {

	public String openFile(File file) {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return content.toString();
	}

	public void saveFile(File file, String text) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(text);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
