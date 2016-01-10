package org.takla.hamla.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.takla.hamla.control.AddInActionListener;
import org.takla.hamla.control.RemoveActionListener;
import org.takla.hamla.control.TextActionListener;
import org.takla.hamla.modle.Donor;
import org.takla.hamla.modle.HasDonate;
import org.takla.hamla.modle.MyCellRender;
import org.takla.hamla.modle.DonateTableModel;
import org.takla.hamla.run.AllRun;

public class ViewDonorHamla extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Donor> allDonors;
	public ArrayList<Donor> current;
	private ArrayList<HasDonate> come;
	private AddInActionListener add;
	private RemoveActionListener remove;
	private TextActionListener text;
	private File file;
	private ViewHamla allPane;
	private JButton jButtonAdd;
	private JButton jButtonRemove;
	private JButton jButtonEdit;
	private JLabel jLabel1;
	private JLabel jLabelStatus1;
	private JLabel jLabelStatus2;
	private JPanel jLeftPanel;
	private JPanel jPanelRight;
	private JPanel jPanelScrollComeTable;
	private JPanel jPanelTable;
	private JTextField jTextSearch;
	private JTable jTableDonorData;
	private JTable jTableCome;
	private DonateTableModel myTableModel; 
	private JComboBox<String> jComboBoxHowDidYouKnow;

	public ViewDonorHamla(ArrayList<Donor> allDonors, ArrayList<HasDonate> come, File f, ViewHamla pane) {
		this.allPane = pane;
		this.allDonors = allDonors;
		this.file = f;
		this.come = come;
		this.jTextSearch = new JTextField();
		this.copyArray("");
		this.declar();
	}

	public void copyArray(String t) {
		this.current = new ArrayList<Donor>();
		Iterator<Donor> iterator = this.allDonors.iterator();
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (!this.isPartOf(don.getName(), t) || this.hasCome(don.getId()) != -1)
				continue;
			this.current.add(don);
		}
	}

	public boolean isPartOf(String all, String part) {
		if (part.compareTo("") == 0) {
			return true;
		}
		return all.contains(part);
	}

	public void declar() {
		this.jPanelRight = new JPanel();
		this.jLabelStatus1 = new JLabel();
		this.jLabelStatus2 = new JLabel();
		this.jPanelScrollComeTable = new JPanel();
		this.jLeftPanel = new JPanel();
		this.jButtonAdd = new JButton();
		this.jButtonEdit = new JButton("Edit");
		this.jButtonRemove = new JButton();
		this.jLabel1 = new JLabel();
		this.jPanelTable = new JPanel();
		this.jComboBoxHowDidYouKnow = new JComboBox<String>();
		this.jLabel1.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel1.setForeground(new Color(255, 51, 51));
		this.jLabel1.setHorizontalAlignment(4);
		this.jLabel1.setText("بحث بالاسم");
		this.setLayout(new BorderLayout());
		this.jLabelStatus1.setFont(new Font("Andalus", 1, 18));
		this.jLabelStatus1.setForeground(new Color(255, 51, 51));
		this.jLabelStatus1.setHorizontalAlignment(4);
		this.jLabelStatus1.setText("عدد الحاضرون : ");
		this.jLabelStatus2.setFont(new Font("Andalus", 1, 18));
		this.jLabelStatus2.setForeground(new Color(255, 51, 51));
		this.jLabelStatus2.setHorizontalAlignment(4);
		this.jLabelStatus2.setText("عدد المتبرعون : ");
		GroupLayout jPanel2Layout = new GroupLayout(this.jPanelRight);
		this.jPanelRight.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(this.jPanelScrollComeTable, -1, 226, 32767).addGap(10, 10, 10))
						.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(this.jLabelStatus2, GroupLayout.Alignment.TRAILING, -1, 236, 32767)
								.addComponent(this.jLabelStatus1, GroupLayout.Alignment.TRAILING, -1, 236, 32767)))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabelStatus1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jLabelStatus2, -2, 24, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jPanelScrollComeTable, -1, 589, 32767)));
		this.add((Component) this.jPanelRight, "After");
		this.jButtonAdd.setFont(new Font("Tahoma", 1, 16));
		this.jButtonRemove.setFont(new Font("Tahoma", 1, 16));
		this.jLabel1.setFont(new Font("Times New Roman", 0, 18));
		this.jLabel1.setForeground(new Color(255, 51, 51));
		this.jLabel1.setHorizontalAlignment(4);
		this.jLabel1.setText("بحث بالاسم");
		this.jTextSearch.setFont(new Font("Times New Roman", 0, 20));
		this.jPanelTable.setLayout(new BorderLayout());
		this.jComboBoxHowDidYouKnow.setEditable(true);
		this.jComboBoxHowDidYouKnow.setFont(new Font("Times New Roman", 1, 16));
		this.jComboBoxHowDidYouKnow.setModel(new DefaultComboBoxModel<String>(AllRun.basicData.getHowDidYouKnow()));
		GroupLayout jPanel1Layout = new GroupLayout(this.jLeftPanel);
		this.jLeftPanel.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup()
												.addComponent(this.jPanelTable, -1, 467, 32767)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel1Layout
														.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addGroup(jPanel1Layout
																.createParallelGroup(GroupLayout.Alignment.TRAILING,
																		false)
																.addComponent(this.jButtonRemove, -1, -1, 32767)
																.addComponent(this.jButtonAdd, -1, 83, 32767)
																.addComponent(this.jComboBoxHowDidYouKnow,
																		GroupLayout.Alignment.LEADING, -2, 93, -2))
												.addComponent(this.jButtonEdit, -2, 93, -2)).addContainerGap())
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addComponent(this.jTextSearch, -2, 227, -2)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.jLabel1, -2, 84, -2).addGap(145, 145, 145)))));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jTextSearch, -2, 28, -2).addComponent(this.jLabel1, -2, 37, -2))
						.addGroup(jPanel1Layout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 154, 32767)
										.addComponent(this.jButtonAdd, -2, 54, -2).addGap(77, 77, 77)
										.addComponent(this.jButtonRemove, -2, 54, -2).addGap(139, 139, 139)
										.addComponent(this.jComboBoxHowDidYouKnow, -2, 43, -2).addGap(18, 18, 18)
										.addComponent(this.jButtonEdit, -2, 44, -2).addGap(22, 22, 22))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6)
										.addComponent(this.jPanelTable, -1, 599, 32767)))));
		this.add((Component) this.jLeftPanel, "Center");
		Color r = new Color(255, 0, 0);
		Color w = new Color(255, 255, 255);
		Font f = new Font("Times New Roman", 1, 40);
		this.jButtonAdd.setText(">>");
		this.jButtonAdd.setFont(f);
		this.jButtonRemove.setText("<<");
		this.jButtonRemove.setFont(f);
		this.jButtonEdit.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonEdit.setBackground(r);
		this.jButtonEdit.setForeground(w);
		this.jButtonAdd.setBackground(r);
		this.jButtonAdd.setForeground(w);
		this.jButtonRemove.setBackground(r);
		this.jButtonRemove.setForeground(w);
		this.add = new AddInActionListener(this.current, this.come, this.jTableDonorData, this, this.jComboBoxHowDidYouKnow);
		this.remove = new RemoveActionListener(this.current, this.come, this.jTableCome, this);
		this.view();
		this.jTextSearch.setFont(new Font("Times New Roman", 0, 20));
		this.jButtonAdd.addActionListener(this.add);
		this.text = new TextActionListener(this.jTextSearch, this);
		this.jButtonRemove.addActionListener(this.remove);
		this.jTextSearch.addKeyListener(this.text);
		this.jComboBoxHowDidYouKnow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int t = ViewDonorHamla.this.jTableCome.getSelectedRow();
				if (t != -1) {
					((HasDonate) ViewDonorHamla.this.come.get(t))
							.setKnow(ViewDonorHamla.this.jComboBoxHowDidYouKnow.getSelectedIndex());
					myTableModel.setValueAt(ViewDonorHamla.this.jComboBoxHowDidYouKnow.getSelectedItem().toString(), t, 1);
				}
			}
		});
		this.jButtonEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (ViewDonorHamla.this.jTableDonorData.getSelectedRow() != -1) {
					Donor pos = ViewDonorHamla.this
							.search(Integer.parseInt(ViewDonorHamla.this.jTableDonorData.getModel()
									.getValueAt(ViewDonorHamla.this.jTableDonorData.getSelectedRow(), 0).toString()));
					EditDonor e = new EditDonor(pos, ViewDonorHamla.this.allPane, true);
					ViewDonorHamla.this.allPane.getJTabbedPaneAll().add(e);
					ViewDonorHamla.this.allPane.getJTabbedPaneAll().setSelectedComponent(e);
				} else {
					JOptionPane.showMessageDialog(null,
							"من فضلك اختار الاسم المراد ادخاله الى الحملة",
							"تحذير", 0);
				}
			}
		});
	}

	public int get_rest() {
		int sum = 0;
		Iterator<Donor> iterator = this.current.iterator();
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (this.hasCome(don.getId()) <= -1)
				continue;
			++sum;
		}
		return sum;
	}

	public void setListeners() {
		this.add.setAddIn(this.jTableDonorData);
		this.remove.setRemove(this.jTableCome);
		this.setRecord();
	}

	public String getText() {
		return this.jTextSearch.getText();
	}

	public JTable view() {
		Object[] colounms2 = new String[8];
		colounms2[7] = "الاسم";
		colounms2[6] = "الدم";
		colounms2[5] = "تاريخ الميلاد";
		colounms2[4] = "الموبيل";
		colounms2[3] = "العنوان";
		colounms2[2] = "الكنيسة";
		colounms2[1] = "التبرع";
		colounms2[0] = "ID";
		Object[][] data = new Object[this.come.size()][4];
		Object[][] data2 = this.current.size() != 0 ? new String[this.current.size() - this.get_rest()][10]
				: new String[this.current.size()][8];
		int leftPos = 0;
		int rightPos = 0;
		int i = 0;
		while (i < this.allDonors.size()) {
			Donor don = this.allDonors.get(i);
			if (this.inCurrent(don.getId())) {
				data2[leftPos][1] = "No";
				if (don.isCanDonate()) {
					data2[leftPos][1] = "Yes";
				}
				data2[leftPos][2] = don.getChurch();
				data2[leftPos][3] = don.getAddress().toview();
				data2[leftPos][4] = don.getMobile();
				data2[leftPos][5] = don.DobToView();
				data2[leftPos][6] = AllRun.basicData.getBloodTypes()[don.getBloodType()].trim();
				data2[leftPos][7] = " " + don.getName();
				data2[leftPos][0] = String.valueOf(don.getId());
				++leftPos;
			}
			++i;
		}
		Iterator<HasDonate> iterator = this.come.iterator();
		HasDonate hasDonate = null;
		while (iterator.hasNext()) {
			hasDonate = iterator.next();
			Donor don = this.search(hasDonate.getDonor_Id());
			data[rightPos][0] = don.getId();
			data[rightPos][1] = " " + AllRun.basicData.getHowDidYouKnow()[hasDonate.getKnow()];
			data[rightPos][3] = new Boolean(hasDonate.hasDonated());
			data[rightPos][2] = " " + don.getName();
			++rightPos;
		}
		this.jTableDonorData = new JTable(data2, colounms2) {
			private static final long serialVersionUID = 1;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				return new MyCellRender(column);
			}
		};
		myTableModel = new DonateTableModel(data, this);
		this.jTableCome = new JTable(myTableModel) {
			private static final long serialVersionUID = 1;

			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 2) {
					return false;
				}
				return true;
			}

			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				if (column != 2) {
					return new MyCellRender(column);
				}
				return super.getCellRenderer(row, column);
			}
		};
		TableColumnModel f = this.jTableDonorData.getColumnModel();
		f.getColumn(1).setMaxWidth(35);
		f.getColumn(1).setMinWidth(35);
		f.getColumn(4).setMinWidth(100);
		f.getColumn(5).setMinWidth(90);
		f.getColumn(6).setMinWidth(42);
		f.getColumn(6).setMaxWidth(42);
		f.getColumn(7).setMinWidth(130);
		this.jTableDonorData.removeColumn(f.getColumn(0));
		
		this.jTableDonorData.getTableHeader().setFont(new Font("Arial ITC", 1, 15));
		this.jTableDonorData.setCellSelectionEnabled(false);
		this.jTableDonorData.setRowSelectionAllowed(true);
		this.jTableDonorData.setColumnSelectionAllowed(false);
		this.jTableDonorData.setFont(new Font("Arial ITC", 1, 17));
		this.jTableCome.setFont(new Font("Arial ITC", 1, 17));
		this.jTableCome.setRowHeight(40);
		this.jTableDonorData.setRowHeight(40);
		JScrollPane pane = new JScrollPane();
		pane.getViewport().add((Component) this.jTableDonorData, (Object) null);
		this.jPanelTable.removeAll();
		this.jPanelTable.setLayout(new BorderLayout(0, 0));
		this.jPanelTable.add((Component) pane, "Center");
		this.jTableCome.setFillsViewportHeight(true);
		TableColumnModel m = this.jTableCome.getColumnModel();
		m.getColumn(3).setMaxWidth(30);
		this.jTableCome.removeColumn(m.getColumn(0));
		JScrollPane scrollPane = new JScrollPane(this.jTableCome);
		this.jPanelScrollComeTable.removeAll();
		this.jPanelScrollComeTable.setLayout(new BorderLayout(0, 0));
		this.jPanelScrollComeTable.add((Component) scrollPane, "Center");
		this.setListeners();
		return this.jTableDonorData;
	}

	public void saveToFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(this.file));
			Iterator<HasDonate> iterator = this.come.iterator();
			HasDonate has = null;
			while (iterator.hasNext()) {
				has = iterator.next();
				out.write(String.valueOf(has.toSave()) + "\n");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
		}
	}

	public void setRecord() {
		int number = 0;
		int i = 0;
		while (i < this.come.size()) {
			if (this.come.get(i).hasDonated()) {
				++number;
			}
			++i;
		}
		this.jLabelStatus1.setText(
				"   عدد الحاضرون : " + this.come.size());
		this.jLabelStatus2
				.setText("   عدد المتبرعون : " + number);
	}

	private boolean inCurrent(int serial) {
		Iterator<Donor> iterator = this.current.iterator();
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (don.getId() != serial)
				continue;
			return true;
		}
		return false;
	}

	public int hasCome(int id) {
		int i = 0;
		while (i < this.come.size()) {
			if (id == this.come.get(i).getDonor_Id()) {
				return i;
			}
			++i;
		}
		return -1;
	}

	private Donor search(int serial) {
		Iterator<Donor> iterator = this.allDonors.iterator();
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (don.getId() != serial)
				continue;
			return don;
		}
		return null;
	}

	public void setCome() {
		int i = 0;
		while (i < this.jTableCome.getRowCount()) {
			String tr = "true";
			if (tr.compareToIgnoreCase(this.jTableCome.getValueAt(i, 2).toString()) == 0) {
				this.come.get(i).setDonated(true);
			} else {
				this.come.get(i).setDonated(false);
			}
			++i;
		}
	}

}
