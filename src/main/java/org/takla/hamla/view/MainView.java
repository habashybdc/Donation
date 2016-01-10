package org.takla.hamla.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.takla.hamla.control.OpenNewDonationListener;
import org.takla.hamla.control.ViewDonorsListener;
import org.takla.hamla.modle.Paintcomponent;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton jButtonOpenDonation = new JButton();
	private JButton jButtonViewDonation = new JButton();
	private JButton jButtonViewName = new JButton();
	private JPanel jPanel1 = new JPanel();
	private JPanel up_pic = new Paintcomponent("dam.gif");
	private JPanel down_pic = new Paintcomponent("aya.gif");
	private JTabbedPane jTabbedPane1 = new JTabbedPane();

	public MainView() {
		this.setDefaultCloseOperation(3);
		GroupLayout jPanel2Layout = new GroupLayout(this.up_pic);
		this.up_pic.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 153, 32767));
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 136, 32767));
		this.jButtonViewName.setFont(new Font("Andalus", 1, 24));
		this.jButtonViewName.setText("عرض البيانات");
		this.jButtonViewDonation.setFont(new Font("Andalus", 1, 24));
		this.jButtonViewDonation.setText("سجل الحملات");
		this.jButtonOpenDonation.setFont(new Font("Andalus", 1, 24));
		this.jButtonOpenDonation.setText("فتح حملة");
		GroupLayout jPanel3Layout = new GroupLayout(this.down_pic);
		this.down_pic.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 153, 32767));
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 158, 32767));
		GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
		this.jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addContainerGap()
										.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(this.down_pic, GroupLayout.Alignment.LEADING, -1, -1,
														32767)
										.addComponent(this.jButtonViewName, -1, -1, 32767)
										.addComponent(this.jButtonViewDonation, GroupLayout.Alignment.LEADING, -1, 153,
												32767)
								.addComponent(this.jButtonOpenDonation, GroupLayout.Alignment.LEADING, -1, 153, 32767)
								.addComponent(this.up_pic, GroupLayout.Alignment.LEADING, -1, -1, 32767))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.up_pic, -1, -1, 32767)
						.addGap(18, 18, 18).addComponent(this.jButtonViewName, -2, 90, -2).addGap(43, 43, 43)
						.addComponent(this.jButtonViewDonation, -2, 94, -2).addGap(36, 36, 36)
						.addComponent(this.jButtonOpenDonation, -2, 92, -2).addGap(18, 18, 18)
						.addComponent(this.down_pic, -1, -1, 32767).addContainerGap()));
		this.getContentPane().add((Component) this.jPanel1, "After");
		this.getContentPane().add((Component) this.jTabbedPane1, "Center");
		this.jButtonViewName.addActionListener(new ViewDonorsListener(this.jTabbedPane1));
		this.jButtonOpenDonation.addActionListener(new OpenNewDonationListener(this.jTabbedPane1));
		this.jButtonViewDonation.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ViewHamalt v = new ViewHamalt();
				v.setName("سجل الحملات");
				MainView.this.jTabbedPane1.add(v);
				MainView.this.jTabbedPane1.setSelectedComponent(v);
				MainView.this.jTabbedPane1.setTabComponentAt(MainView.this.jTabbedPane1.getSelectedIndex(),
						new ButtonTabComponent(MainView.this.jTabbedPane1));
			}
		});
		this.pack();
	}

	public void run(JFrame frame) {
		ImageIcon i = new ImageIcon("data/dam_logo.gif");
		this.setIconImage(i.getImage());
		this.setTitle(
				"برنامج حملة التبرع بالدم");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		this.setExtendedState(6);
		this.setResizable(true);
		frame.dispose();
	}

}
