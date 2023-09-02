package br.com.cod3r.decorator.swing;

import java.awt.FlowLayout;

import javax.swing.*;

public class Client {

	public static void main(String[] args) {
		JFrame frame =new JFrame();  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(400,300);
		
		JTextArea textArea = new JTextArea(10, 30);
		textArea.setLineWrap(true);

		// Utilizando decorator no scroll com o textArea.
		JScrollPane scroll = new JScrollPane(textArea,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		frame.add(scroll);
		          
		frame.setVisible(true);
	}
}
