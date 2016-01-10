package org.takla.hamla.run;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.takla.hamla.data.BasicData;
import org.takla.hamla.data.Hamla;
import org.takla.hamla.view.Intro;

public class AllRun {
	public static Hamla hamla;
	public static BasicData basicData;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		hamla = new Hamla();
		basicData = new BasicData();
		Intro d = new Intro();
		ImageIcon i = new ImageIcon("data/dam.gif");
		d.setIconImage(i.getImage());
		d.setTitle("الدخول");
		d.setSize(400, 600);
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(3);
		d.setVisible(true);
		d.setResizable(false);
	}

}
