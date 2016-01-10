package org.takla.hamla.modle;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Paintcomponent extends JPanel {
	private static final long serialVersionUID = 1;
	String pic;

	public Paintcomponent(String pic) {
		this.pic = pic;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(new ImageIcon("data/" + this.pic).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
