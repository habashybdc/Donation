package org.takla.hamla.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.modle.HasDonate;
import org.takla.hamla.run.AllRun;

public class ViewHamla extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String bank;
	private String days;
	private boolean edit;
	private ViewDonorHamla menView;
	private ViewDonorHamla womenView;
	private int hamlaNumber;
	private JLabel jComboBoxBank;
	private JLabel jLabelDays;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPanel jPanelup;
	private JSeparator jSeparator1;
	private JLabel jSpinnerNmuber;
	private JTabbedPane jTabbedPaneAll;
	private JButton jButtonSave;

	public ViewHamla(int number, String bank, String days, boolean edit) {
		this.hamlaNumber = number;
		this.bank = bank;
		this.edit = edit;
		this.days = days;
		this.initComponents();
	}

	private void initComponents() {
		this.jPanelup = new JPanel();
		this.jSeparator1 = new JSeparator();
		this.jLabel1 = new JLabel();
		this.jLabel3 = new JLabel();
		this.jSpinnerNmuber = new JLabel();
		this.jLabel2 = new JLabel();
		this.jComboBoxBank = new JLabel();
		this.jTabbedPaneAll = new JTabbedPane();
		this.jButtonSave = new JButton();
		this.jLabelDays = new JLabel();
		this.setLayout(new BorderLayout());
		Font f = new Font("Times New Roman", 1, 18);
		Color c = new Color(255, 51, 51);
		this.jLabel1.setFont(f);
		this.jLabel1.setForeground(c);
		this.jLabel1.setHorizontalAlignment(4);
		this.jLabel1.setText("رقم الحملة");
		this.jSpinnerNmuber.setFont(new Font("Times New Roman", 1, 18));
		this.jSpinnerNmuber.setText(String.valueOf(this.hamlaNumber));
		this.jLabel2.setFont(f);
		this.jLabel2.setForeground(c);
		this.jLabel2.setHorizontalAlignment(4);
		this.jLabel2.setText("بنك الدم");
		this.jComboBoxBank.setFont(new Font("Times New Roman", 1, 20));
		this.jComboBoxBank.setText(this.bank);
		this.jButtonSave.setFont(new Font("Times New Roman", 1, 18));
		this.jButtonSave.setText("save");
		this.jLabel3.setFont(f);
		this.jLabel3.setForeground(c);
		this.jLabel3.setHorizontalAlignment(4);
		this.jLabel3.setText("الايام");
		this.jLabelDays.setFont(new Font("Times New Roman", 1, 20));
		this.jLabelDays.setHorizontalAlignment(0);
		this.jLabelDays.setText(this.days);
		GroupLayout jPanelupLayout = new GroupLayout(this.jPanelup);
		this.jPanelup.setLayout(jPanelupLayout);
		jPanelupLayout.setHorizontalGroup(jPanelupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanelupLayout.createSequentialGroup()
								.addComponent(this.jSeparator1, -1, 955,
										32767)
								.addContainerGap())
				.addGroup(GroupLayout.Alignment.TRAILING, jPanelupLayout.createSequentialGroup().addGap(20, 20, 20)
						.addComponent(this.jButtonSave, -2, 85, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, 32767)
						.addComponent(this.jLabelDays, -2, 153, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3, -2, 43, -2)
						.addGap(127, 127, 127).addComponent(this.jComboBoxBank, -2, 119, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2, -2, 65, -2)
						.addGap(115, 115, 115).addComponent(this.jSpinnerNmuber, -2, 57, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1, -2, 81, -2)
						.addGap(34, 34, 34)));
		jPanelupLayout
				.setVerticalGroup(
						jPanelupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanelupLayout.createSequentialGroup().addContainerGap(45, 32767)
												.addGroup(jPanelupLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanelupLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																		.addComponent(this.jLabel1, -2, 34, -2)
																		.addComponent(this.jSpinnerNmuber, -2, 27, -2)
																		.addComponent(this.jLabel2, -2, 34, -2)
																		.addComponent(this.jComboBoxBank, -2, 27, -2)
																		.addComponent(this.jLabel3, -2, 34, -2)
																		.addComponent(this.jLabelDays, -2, 23, -2))
												.addComponent(this.jButtonSave, -2, 31, -2)).addGap(18, 18, 18)
						.addComponent(this.jSeparator1, -2, -1, -2).addContainerGap()));
		Color r = new Color(255, 0, 0);
		Color w = new Color(255, 255, 255);
		this.jButtonSave.setBackground(r);
		this.jButtonSave.setForeground(w);
		this.add((Component) this.jPanelup, "First");
		this.add((Component) this.jTabbedPaneAll, "Center");
		this.setFile();
		this.jButtonSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				ViewHamla.this.menView.setCome();
				ViewHamla.this.womenView.setCome();
				ViewHamla.this.menView.saveToFile();
				ViewHamla.this.womenView.saveToFile();
				ViewHamla.this.menView.view();
				ViewHamla.this.womenView.view();
			}
		});
		this.menView.setName("رجال");
		this.womenView.setName("سيدات");
		this.jTabbedPaneAll.add(this.menView);
		this.jTabbedPaneAll.add(this.womenView);
	}

	public void setMenView() {
		this.menView.copyArray(this.menView.getText());
		this.menView.view();
	}

	public void setWomenView() {
		this.womenView.copyArray(this.womenView.getText());
		this.womenView.view();
	}

	public JTabbedPane getJTabbedPaneAll() {
		return this.jTabbedPaneAll;
	}

	public void setFile() {
		String menS = "data/Hamlet/" + this.hamlaNumber + "/men.min";
		String womenS = "data/Hamlet/" + this.hamlaNumber + "/women.min";
		if (!this.edit) {
			this.menView = new ViewDonorHamla(AllRun.hamla.getMenDontators(), new ArrayList<HasDonate>(),
					new File(menS), this);
			this.womenView = new ViewDonorHamla(AllRun.hamla.getWoMenDontators(), new ArrayList<HasDonate>(),
					new File(womenS), this);
		} else {
			this.menView = new ViewDonorHamla(AllRun.hamla.getMenDontators(), this.loadHamla(menS, true),
					new File(menS), this);
			this.womenView = new ViewDonorHamla(AllRun.hamla.getWoMenDontators(), this.loadHamla(womenS, false),
					new File(womenS), this);
		}
	}

	private ArrayList<HasDonate> loadHamla(String s, boolean men) {
		ArrayList<HasDonate> don = new ArrayList<HasDonate>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(s)));
			String temp = in.readLine();
			while (temp != null) {
				String[] split = temp.split(",");
				int temp1 = Integer.parseInt(split[0]);
				int temp2 = 0;
				try {
					temp2 = Integer.parseInt(split[2]);
				} catch (Exception var9_10) {
					// empty catch block
				}
				if (this.inAll(men, temp1)) {
					if (Integer.parseInt(split[1]) == 1) {
						don.add(new HasDonate(temp1, true, temp2));
					} else {
						don.add(new HasDonate(temp1, false, temp2));
					}
				}
				temp = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return don;
	}

	public boolean inAll(boolean men, int serial) {
		Iterator<Donor> iterator = men ? AllRun.hamla.getMenDontators().iterator()
				: AllRun.hamla.getWoMenDontators().iterator();
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (don.getId() != serial)
				continue;
			return true;
		}
		return false;
	}

}
