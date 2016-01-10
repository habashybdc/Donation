package org.takla.hamla.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.takla.hamla.control.EnterListener;
import org.takla.hamla.modle.Paintcomponent;

public class Intro extends JFrame {
	private static final long serialVersionUID = 1;
	private JLabel userName;
	private JLabel password;
	private JButton enter;
	private JTextField user;
	private JRadioButton white;
	private JRadioButton black;
	private JPasswordField pass;
	private Paintcomponent p;

	public Intro() {
		ButtonGroup butt = new ButtonGroup();
		this.p = new Paintcomponent("anba.jpg");
		this.user = new JTextField();
		this.pass = new JPasswordField(10);
		this.userName = new JLabel();
		this.password = new JLabel();
		this.enter = new JButton();
		this.white = new JRadioButton("White");
		this.black = new JRadioButton("Black");
		butt.add(this.black);
		butt.add(this.white);
		this.black.setSelected(true);
		this.user.setBorder(BorderFactory.createLineBorder(Color.white));
		this.pass.setBorder(BorderFactory.createLineBorder(Color.white));
		this.userName.setBackground(Color.black);
		this.user.setBackground(Color.black);
		this.pass.setBackground(Color.black);
		this.enter.setBackground(Color.black);
		this.white.setBackground(Color.white);
		this.black.setBackground(Color.black);
		this.userName.setForeground(Color.white);
		this.password.setForeground(Color.white);
		this.enter.setForeground(Color.blue);
		this.p.setLayout(null);
		this.userName.setBounds(290, 450, 200, 30);
		this.user.setBounds(100, 450, 150, 30);
		this.black.setBounds(20, 520, 55, 19);
		this.white.setBounds(20, 543, 55, 19);
		this.p.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.password.setBounds(290, 500, 210, 30);
		this.pass.setBounds(100, 505, 150, 30);
		this.enter.setBounds(295, 530, 100, 28);
		this.user.setForeground(Color.white);
		this.pass.setForeground(Color.white);
		this.enter.setFont(new Font("TimesRoman", 1, 20));
		this.userName.setFont(new Font("TimesRoman", 1, 20));
		this.password.setFont(new Font("TimesRoman", 1, 20));
		this.user.setFont(new Font("TimesRoman", 1, 15));
		this.pass.setFont(new Font("TimesRoman", 1, 10));
		this.black.setFont(new Font("TimesRoman", 0, 10));
		this.white.setFont(new Font("TimesRoman", 0, 10));
		this.userName.setText("اسم المستخدم");
		this.password.setText("كلمة السر");
		this.pass.setText("mina shafik");
		this.user.setText(
				"حملة التبرع بالدم");
		this.enter.setText("دخول");
		this.enter.addActionListener(new EnterListener(this, this.user, this.pass, this.black));
		this.add(this.p);
		this.p.add(this.user);
		this.p.add(this.userName);
		this.p.add(this.password);
		this.p.add(this.pass);
		this.p.add(this.enter);
		this.p.add(this.white);
		this.p.add(this.black);
	}
}
