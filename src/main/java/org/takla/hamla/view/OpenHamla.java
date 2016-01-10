package org.takla.hamla.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import org.takla.hamla.run.AllRun;

public class OpenHamla extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTabbedPane allPane;
	private JButton jButtonEditHamla;
	private JButton jButtonNewHamla;
	private JComboBox<String> jComboBoxBankNew;
	private JComboBox<String> jComboBoxBankOpen;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JList<String> jListEdit;
	private JPanel jPanelEdit;
	private JPanel jPanelNew;
	private JScrollPane jScrollPane1;
	private JSpinner jSpinnerHamlaNumberEdit;
	private JSpinner jSpinnerHamlaNumberOpen;
	private JTextField jTextFieldDaysNew;
	private JTextField jTextFieldDaysOpen;

	private File[] files = null;

	private BufferedReader in;
	private String[] banksNames;
	public OpenHamla(JTabbedPane allPane) {
		this.allPane = allPane;
		files = AllRun.hamla.getHamalatFolders();
		banksNames = AllRun.basicData.getBanksName();
		this.initComponents();
	}

	private void initComponents() {
		this.jPanelNew = new JPanel();
		this.jSpinnerHamlaNumberOpen = new JSpinner();
		this.jLabel1 = new JLabel();
		this.jLabel2 = new JLabel();
		this.jComboBoxBankNew = new JComboBox<String>(banksNames);
		this.jComboBoxBankOpen = new JComboBox<String>(banksNames);
		this.jTextFieldDaysNew = new JTextField();
		this.jLabel3 = new JLabel();
		this.jButtonNewHamla = new JButton();
		this.jPanelEdit = new JPanel();
		this.jLabel4 = new JLabel();
		this.jSpinnerHamlaNumberEdit = new JSpinner();
		this.jLabel5 = new JLabel();
		this.jLabel6 = new JLabel();
		this.jTextFieldDaysOpen = new JTextField();
		this.jScrollPane1 = new JScrollPane();
		this.jListEdit = new JList<String>();
		this.jButtonEditHamla = new JButton();
		this.jPanelNew.setBorder(BorderFactory.createTitledBorder(null, " اضافة حملة جديدة", TitledBorder.RIGHT , 0,
				new Font("Times New Roman", 1, 20), new Color(255, 0, 0)));
		this.jSpinnerHamlaNumberOpen.setFont(new Font("Times New Roman", 1, 20));
		this.jSpinnerHamlaNumberOpen
				.setModel(new SpinnerNumberModel((Number) 17, Integer.valueOf(1), null, (Number) 1));
		this.jLabel1.setBackground(new Color(255, 0, 0));
		this.jLabel1.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel1.setForeground(new Color(255, 0, 0));
		this.jLabel1.setHorizontalAlignment(4);
		this.jLabel1.setText("رقم الحملة");
		this.jLabel2.setBackground(new Color(255, 0, 0));
		this.jLabel2.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel2.setForeground(new Color(255, 0, 0));
		this.jLabel2.setHorizontalAlignment(4);
		this.jLabel2.setText("بنك الدم");
		this.jComboBoxBankNew.setFont(new Font("Times New Roman", 1, 20));
		this.jLabel3.setBackground(new Color(255, 0, 0));
		this.jLabel3.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel3.setForeground(new Color(255, 0, 0));
		this.jLabel3.setHorizontalAlignment(4);
		this.jLabel3.setText("الايام");
		this.jButtonNewHamla.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonNewHamla.setText("New");
		GroupLayout jPanelNewLayout = new GroupLayout(this.jPanelNew);
		this.jPanelNew.setLayout(jPanelNewLayout);
		jPanelNewLayout.setHorizontalGroup(jPanelNewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanelNewLayout.createSequentialGroup().addContainerGap(35, 32767).addGroup(jPanelNewLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, jPanelNewLayout.createSequentialGroup()
								.addGroup(jPanelNewLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(jPanelNewLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(this.jComboBoxBankNew, GroupLayout.Alignment.TRAILING, 0,
														-1, 32767)
												.addComponent(this.jTextFieldDaysNew, GroupLayout.Alignment.TRAILING,
														-2, 195, -2))
										.addComponent(this.jSpinnerHamlaNumberOpen, -2, 53, -2))
								.addGap(18, 18, 18)
								.addGroup(jPanelNewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.jLabel1, -2, 68, -2)
										.addGroup(jPanelNewLayout
												.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, -1,
														32767)
												.addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -2, 65, -2)))
								.addContainerGap())
						.addGroup(GroupLayout.Alignment.TRAILING, jPanelNewLayout.createSequentialGroup()
								.addComponent(this.jButtonNewHamla, -2, 72, -2).addGap(48, 48, 48)))));
		jPanelNewLayout.setVerticalGroup(jPanelNewLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanelNewLayout.createSequentialGroup().addGap(118, 118, 118)
						.addGroup(jPanelNewLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jSpinnerHamlaNumberOpen, -2, 26, -2)
								.addComponent(this.jLabel1, -2, 32, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanelNewLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jComboBoxBankNew, -2, 27, -2).addComponent(this.jLabel2, -2, 34, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanelNewLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jTextFieldDaysNew, -2, 29, -2)
								.addComponent(this.jLabel3, -2, 34, -2))
						.addGap(18, 18, 18).addComponent(this.jButtonNewHamla, -2, 45, -2)
						.addContainerGap(137, 32767)));
		this.jPanelEdit.setBorder(BorderFactory.createTitledBorder(null, "تعديل حملة", TitledBorder.RIGHT, 0,
				new Font("Times New Roman", 1, 20), new Color(255, 0, 0)));
		this.jPanelEdit.setFont(new Font("Times New Roman", 1, 20));
		this.jLabel4.setBackground(new Color(255, 0, 0));
		this.jLabel4.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel4.setForeground(new Color(255, 0, 0));
		this.jLabel4.setHorizontalAlignment(4);
		this.jLabel4.setText("رقم الحملة");
		this.jButtonEditHamla.setBackground(new Color(255, 0, 0));
		this.jButtonNewHamla.setBackground(new Color(255, 0, 0));
		this.jButtonEditHamla.setForeground(new Color(255, 255, 255));
		this.jButtonNewHamla.setForeground(new Color(255, 255, 255));
		this.jSpinnerHamlaNumberEdit.setFont(new Font("Times New Roman", 1, 20));
		this.jSpinnerHamlaNumberEdit
				.setModel(new SpinnerNumberModel((Number) 17, Integer.valueOf(1), null, (Number) 1));
		this.jComboBoxBankOpen.setFont(new Font("Times New Roman", 1, 20));
		this.jLabel5.setBackground(new Color(255, 0, 0));
		this.jLabel5.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel5.setForeground(new Color(255, 0, 0));
		this.jLabel5.setHorizontalAlignment(4);
		this.jLabel5.setText("بنك الدم");
		this.jLabel6.setBackground(new Color(255, 0, 0));
		this.jLabel6.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel6.setForeground(new Color(255, 0, 0));
		this.jLabel6.setHorizontalAlignment(4);
		this.jLabel6.setText("الايام");
		this.jListEdit.setFont(new Font("Times New Roman", 1, 20));
		this.jListEdit.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			File[] monthesNames = files;
			String[] strings = new String[files.length];

			public int getSize() {
				if(monthesNames ==null)
					return 0;
				int i = 0;
				while (i < this.monthesNames.length) {
					this.strings[i] = this.monthesNames[i].getName();
					++i;
				}
				return this.strings.length;
			}

			public String getElementAt(final int i) {
				return this.strings[i];
			}
		});
		this.jListEdit.setSelectedIndex(0);
		this.setFields(this.jListEdit.getSelectedValue().toString());
		this.jScrollPane1.setViewportView(this.jListEdit);
		this.jButtonEditHamla.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonEditHamla.setText("Edit");
		GroupLayout jPanelEditLayout = new GroupLayout(this.jPanelEdit);
		this.jPanelEdit.setLayout(jPanelEditLayout);
		jPanelEditLayout.setHorizontalGroup(jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanelEditLayout.createSequentialGroup().addContainerGap().addGroup(jPanelEditLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, jPanelEditLayout.createSequentialGroup()
								.addGroup(jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(jPanelEditLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(this.jComboBoxBankOpen, GroupLayout.Alignment.TRAILING, 0,
														-1, 32767)
												.addComponent(this.jTextFieldDaysOpen, GroupLayout.Alignment.TRAILING,
														-2, 195, -2))
										.addComponent(this.jSpinnerHamlaNumberEdit, -2, 53, -2))
								.addGap(18, 18, 18)
								.addGroup(jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(this.jLabel4, -2, 68, -2)
										.addGroup(jPanelEditLayout
												.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(this.jLabel6, GroupLayout.Alignment.LEADING, -1, -1,
														32767)
												.addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -2, 65, -2)))
								.addContainerGap())
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelEditLayout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 176, 32767)
										.addGap(18, 18, 18).addComponent(this.jButtonEditHamla, -2, 101, -2)
										.addGap(20, 20, 20)))));
		jPanelEditLayout
				.setVerticalGroup(
						jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, jPanelEditLayout.createSequentialGroup()
										.addGroup(jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(jPanelEditLayout.createSequentialGroup().addGap(92, 92, 92)
														.addComponent(this.jButtonEditHamla, -2, 45, -2))
								.addComponent(this.jScrollPane1, -1, 296, 32767))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jSpinnerHamlaNumberEdit, -2, 26, -2)
								.addComponent(this.jLabel4, -2, 32, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jComboBoxBankOpen, -2, 27, -2)
								.addComponent(this.jLabel5, -2, 34, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanelEditLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jTextFieldDaysOpen, -2, 29, -2)
								.addComponent(this.jLabel6, -2, 34, -2)).addContainerGap()));
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelEdit, -1, -1, 32767)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(this.jPanelNew, -1, -1, 32767).addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(this.jPanelEdit, GroupLayout.Alignment.LEADING, -1, -1,
														32767)
										.addComponent(this.jPanelNew, GroupLayout.Alignment.LEADING, -1, -1, 32767))
						.addContainerGap()));
		this.jButtonNewHamla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(OpenHamla.this.jSpinnerHamlaNumberOpen.getValue().toString());
				if (!OpenHamla.this.isPastHamla(String.valueOf(num))) {
					File f1 = new File("data/Hamlet/" + num);
					f1.mkdirs();
					OpenHamla.this.setInfor("فتح حملة", num, OpenHamla.this.jComboBoxBankNew.getSelectedIndex(),
							OpenHamla.this.jTextFieldDaysNew.getText(), false);
				} else {
					JOptionPane.showMessageDialog(null,
							"رقم هذه الحملة قد تم ادخاله نم قبل ان اردت التعديل اضغط على Edit");
				}
			}
		});
		this.jButtonEditHamla.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(OpenHamla.this.jSpinnerHamlaNumberEdit.getValue().toString());
				OpenHamla.this.setInfor("تعديل حملة", num, OpenHamla.this.jComboBoxBankOpen.getSelectedIndex(),
						OpenHamla.this.jTextFieldDaysOpen.getText(), true);
			}
		});
		this.jListEdit.addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent arg0) {
				OpenHamla.this.setFields(OpenHamla.this.jListEdit.getSelectedValue().toString());
			}

			public void mouseClicked(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
			}

			public void mouseExited(MouseEvent e) {
				
			}

		});
	}

	private void setFields(String s) {
		int selectedValue = Integer.parseInt(s);
		this.jSpinnerHamlaNumberEdit.setValue(selectedValue);
		try {
			in = new BufferedReader(
					new FileReader(new File("data/hamlet/" + selectedValue + "/inf.txt")));
			this.jComboBoxBankOpen.setSelectedIndex(Integer.parseInt(in.readLine()));
			this.jTextFieldDaysOpen.setText(in.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isPastHamla(String temp) {
		File yearName = new File("data/Hamlet/");
		File[] hamlaNames = yearName.listFiles();
		int i = 0;
		while (i < hamlaNames.length) {
			if (hamlaNames[i].getName().compareToIgnoreCase(temp) == 0) {
				return true;
			}
			++i;
		}
		return false;
	}

	public void setInfor(String temp, int num, int bank, String days, boolean edit) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File("data/Hamlet/" + num + "/inf.txt")));
			out.write(String.valueOf(bank) + "\n");
			out.write(days);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.allPane.remove(this);
		ViewHamla v = new ViewHamla(num, banksNames[bank], days, edit);
		v.setName(temp);
		this.allPane.add(v);
		this.allPane.setSelectedComponent(v);
	}

}
