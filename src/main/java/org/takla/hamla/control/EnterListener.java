package org.takla.hamla.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.takla.hamla.view.MainView;

public class EnterListener implements ActionListener {
	JFrame frame;
	JTextField user;
	JTextField pass;
	JRadioButton black;

	public EnterListener(JFrame frame, JTextField user, JTextField pass, JRadioButton black) {
		this.frame = frame;
		this.user = user;
		this.pass = pass;
		this.black = black;
	}

	public void actionPerformed(ActionEvent e) {
		if (this.user.getText()
				.equals("حملة التبرع بالدم")
				&& this.pass.getText().equals("mina shafik")) {
			if (!this.black.isSelected()) {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
				} catch (Exception var2_2) {
					// empty catch block
				}
			}
			String mass = "اهداء من المهندس/ مينا شفيق الى كشافة الحبشى";
			JLabel l = new JLabel(
					"مرحباً بك في برنامج حملة التبرع بالدم ");
			JLabel l2 = new JLabel(mass);
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(2, 1));
			p.add(l);
			p.add(l2);
			l.setFont(new Font("Andalus", 1, 20));
			l.setHorizontalAlignment(0);
			l2.setHorizontalAlignment(0);
			l2.setFont(new Font("Times New Roman", 1, 20));
			l2.setForeground(Color.YELLOW);
			l.setForeground(Color.red);
			JOptionPane.showMessageDialog(null, p);
			new MainView().run(this.frame);
		} else {
			Object[] options = new Object[] {
					"إعادة المحاولة",
					"خروج" };
			int i = JOptionPane.showOptionDialog(null,
					"اسم المستخدم وكلمة السر غير صحيحين اعد المحاولة.",
					"تحذير", -1, 2, null, options, options[0]);
			if (i == 1) {
				System.exit(0);
			}
		}
	}
}
