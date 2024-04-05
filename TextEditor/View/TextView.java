package View;

import javax.swing.border.EmptyBorder;

import Controller.TextController;
import Model.TextModel;

import javax.swing.*;
import java.awt.*;

public class TextView extends JFrame {
	private static TextModel model;
	private static TextView view;
	private static TextController controller;
	private JFileChooser fileChooser;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			model = new TextModel();
			view = new TextView();
			controller = new TextController(view, model);
			view.setVisible(true);
			view.setLocationRelativeTo(null);
		});
	}

	public TextView() {
		setTitle("Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 670);

		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
		JScrollPane scrollPane = new JScrollPane(textArea);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.setBounds(0, 0, 568, 33);

		JMenu menu = new JMenu("File");
		menu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		menuBar.add(menu);

		JMenuItem open = new JMenuItem("Open");
		open.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menu.add(open);

		JMenuItem save = new JMenuItem("Save");
		save.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menu.add(save);

		JMenuItem saveAs = new JMenuItem("Save As");
		saveAs.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menu.add(saveAs);

		JMenuItem exit = new JMenuItem("Exit");
		exit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menu.add(exit);

		open.addActionListener(e -> controller.openFile());
		save.addActionListener(e -> controller.saveFile());
		saveAs.addActionListener(e -> controller.saveAs());
		exit.addActionListener(e -> System.exit(0));

		fileChooser = new JFileChooser();

	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}
}
