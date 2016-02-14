package org.takla.hamla.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.takla.hamla.control.AddNewActionListener;
import org.takla.hamla.control.EditListener;
import org.takla.hamla.control.ExportExcelListner;
import org.takla.hamla.control.PrintListner;
import org.takla.hamla.modle.Donor;
import org.takla.hamla.modle.MyCellRender;
import org.takla.hamla.run.AllRun;

public class ViewDonorOfKind extends JPanel {
	private static final long serialVersionUID = 1;
	private JPanel edit1Panel;
	private JPanel teachersPanel;
	private JScrollPane jScrollPane12 = new JScrollPane();
	private JTable table2;
	private String[] colounms2;
	private Object[][] data2;
	private JButton add1;
	private JButton print1;
	private JButton export1;
	private JButton edit1;
	private ArrayList<Donor> donators;
	private JButton remove;

	public ViewDonorOfKind(ArrayList<Donor> donators, ViewDonors theTwoPane, JTabbedPane otherTabs) {
		this.setview(donators, theTwoPane, otherTabs);
	}

	public void setview(final ArrayList<Donor> donators, final ViewDonors theTwoPane, JTabbedPane otherTabs) {
		this.donators = donators;
		this.remove = new JButton("حذف");
		this.print1 = new JButton("طباعة");
		this.export1 = new JButton("استخراج");
		this.setLayout(new BorderLayout());
		new javax.swing.JScrollPane();
		this.teachersPanel = new JPanel();
		this.edit1Panel = new JPanel();
		this.colounms2 = new String[11];
		this.add1 = new JButton("اضافة اسم جديد");
		this.edit1 = new JButton("تعديل");
		Color r = new Color(255, 0, 0);
		Color w = new Color(255, 255, 255);
		this.add1.setBackground(r);
		this.add1.setForeground(w);
		this.edit1.setBackground(r);
		this.edit1.setForeground(w);
		this.remove.setBackground(r);
		this.remove.setForeground(w);
		this.print1.setBackground(r);
		this.print1.setForeground(w);
		this.export1.setBackground(r);
		this.export1.setForeground(w);
		this.teachersPanel.setLayout(new BorderLayout());
		this.edit1Panel.setLayout(new GridLayout(1, 3, 50, 50));
		Font f = new Font("Arial ITC", 1, 20);
		this.add1.setFont(f);
		this.edit1.setFont(f);
		this.export1.setFont(f);
		this.print1.setFont(f);
		this.remove.setFont(f);
		this.edit1Panel.add(this.add1);
		this.edit1Panel.add(this.edit1);
		this.edit1Panel.add(this.remove);
		this.edit1Panel.add(this.print1);
		this.edit1Panel.add(this.export1);
		this.teachersPanel.add((Component) this.edit1Panel, "South");
		this.add((Component) this.teachersPanel, "Center");
		this.view();
		EditListener editListener1 = new EditListener(this, donators, theTwoPane, otherTabs);
		this.edit1.addActionListener(editListener1);
		this.add1.addActionListener(new AddNewActionListener(theTwoPane, otherTabs));

		this.remove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (ViewDonorOfKind.this.table2.getSelectedRow() != -1) {
					int id = Integer.parseInt(ViewDonorOfKind.this.table2.getModel()
							.getValueAt(ViewDonorOfKind.this.table2.getSelectedRow(), 0).toString());
					Donor d = ViewDonorOfKind.this.search(id);
					int g = JOptionPane.showConfirmDialog(null, "هل انت واثق من انك تريد مسح " + d.getName()
							+ "\n و هذا معناه انه سوف يتم اضاعة بيانات اذا كانت حضر حملة من قبل ");
					if (g == 0) {
						donators.remove(d);
						if (d.isMale().booleanValue()) {
							AllRun.hamla.saveMenDonor();
							theTwoPane.setMenView();
						} else {
							AllRun.hamla.saveWoMenDonor();
							theTwoPane.setWomenView();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "من فضلك اختار الاسم المراد  مسحه", "تحذير", 0);
				}
			}
		});
		String temp = " الرجال";
		String filename = "men";
		if (donators.size() != 0 && !donators.get(0).isMale().booleanValue()) {
			temp = " السيدات";
			filename = "women";
		}
		this.print1.addActionListener(new PrintListner(this.table2, "بيانات" + temp));
		this.export1.addActionListener(new ExportExcelListner(table2, this, "Donners" + "-" + filename));
	}

	private Donor search(int serial) {
		Iterator<Donor> iterator = this.donators.iterator();
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (don.getId() != serial)
				continue;
			return don;
		}
		return null;
	}

	public JTable getTable2() {
		return this.table2;
	}

	public JTable view() {
		this.colounms2[10] = "م";
		this.colounms2[9] = "الاسم";
		this.colounms2[8] = "الدم";
		this.colounms2[7] = "تاريخ الميلاد";
		this.colounms2[6] = "الموبيل";
		this.colounms2[5] = "العنوان";
		this.colounms2[4] = "الكنيسة";
		this.colounms2[3] = "أب الاعتراف";
		this.colounms2[2] = "E-mail";
		this.colounms2[1] = "التبرع";
		this.colounms2[0] = "ID";
		this.data2 = new Object[this.donators.size()][11];
		int i = 0;
		while (i < this.donators.size()) {
			Donor don = this.donators.get(i);
			this.data2[i][1] = "X";
			if (don.isCanDonate()) {
				this.data2[i][1] = "✓";
			}
			this.data2[i][2] = don.getE_mail();
			this.data2[i][3] = don.getFather();
			this.data2[i][4] = don.getChurch();
			this.data2[i][5] = don.getAddress().toview();
			this.data2[i][6] = don.getMobile();
			this.data2[i][7] = don.DobToView();
			this.data2[i][8] = AllRun.basicData.getBloodTypes()[don.getBloodType()].trim();
			this.data2[i][9] = " " + don.getName();
			this.data2[i][10] = i + 1;
			this.data2[i][0] = don.getId();
			++i;
		}
		this.table2 = new JTable(this.data2, this.colounms2) {
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
		TableColumnModel f = this.table2.getColumnModel();
		// Donated
		f.getColumn(1).setMaxWidth(35);
		f.getColumn(1).setMinWidth(35);
		// Email
		f.getColumn(2).setMinWidth(200);
		// Father
		f.getColumn(3).setMinWidth(80);
		// Church
		f.getColumn(4).setMinWidth(100);
		// Address
		f.getColumn(5).setMinWidth(200);
		// mobile
		f.getColumn(6).setMinWidth(100);
		// birth date
		f.getColumn(7).setMaxWidth(95);
		f.getColumn(7).setMinWidth(95);
		// Blood type
		f.getColumn(8).setMinWidth(45);
		f.getColumn(8).setMaxWidth(45);
		// Name
		f.getColumn(9).setMinWidth(150);
		// Index
		f.getColumn(10).setMinWidth(35);
		f.getColumn(10).setMaxWidth(35);
		this.table2.removeColumn(f.getColumn(0));
		this.table2.setAlignmentX(4.0f);
		this.table2.getTableHeader().setFont(new Font("Arial ITC", 1, 18));
		this.table2.setCellSelectionEnabled(false);
		this.table2.setRowSelectionAllowed(true);
		this.table2.setColumnSelectionAllowed(false);
		this.teachersPanel.setBorder(BorderFactory.createEtchedBorder());
		this.table2.setFont(new Font("Arial ITC", 1, 18));
		this.table2.setRowHeight(40);
		this.jScrollPane12.getViewport().add((Component) this.table2, (Object) null);
		// jScrollPane12.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.teachersPanel.add((Component) this.jScrollPane12, "Center");
		return this.table2;
	}

}
