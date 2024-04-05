package Controller;

import java.io.File;

import javax.swing.JFileChooser;

import Model.TextModel;
import View.TextView;

public class TextController {
	private TextView view;
	private TextModel model;
	private File currentFile;

	public TextController(TextView view, TextModel model) {
		this.view = view;
		this.model = model;
	}

	public void openFile() {
		JFileChooser fileChooser = view.getFileChooser();
		if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String content = model.openFile(file);
			view.getTextArea().setText(content);
		}
	}

	public void saveFile() {
		JFileChooser fileChooser = view.getFileChooser();
		if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String text = view.getTextArea().getText();
			model.saveFile(file, text);
		}
	}

	public void saveAs() {
		JFileChooser fileChooser = view.getFileChooser();
		int returnValue = fileChooser.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			saveFile();
			currentFile = selectedFile;
		}
	}
}
