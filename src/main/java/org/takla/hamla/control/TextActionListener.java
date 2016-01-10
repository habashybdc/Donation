package org.takla.hamla.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.takla.hamla.view.ViewDonorHamla;

public class TextActionListener implements KeyListener {
	private JTextField text;
	private ViewDonorHamla hamla;

	public TextActionListener(JTextField text, ViewDonorHamla hamla) {
		this.text = text;
		this.hamla = hamla;
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
		String currentText = this.text.getText();
		this.hamla.setCome();
		this.hamla.copyArray(currentText);
		this.hamla.view();
		this.hamla.validate();
	}

	public void keyTyped(KeyEvent e) {
	}
}
