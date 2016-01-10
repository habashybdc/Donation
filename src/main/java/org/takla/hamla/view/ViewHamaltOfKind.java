package org.takla.hamla.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.takla.hamla.control.ExportExcelListner;
import org.takla.hamla.control.PrintListner;
import org.takla.hamla.modle.ViewCellRender;

public class ViewHamaltOfKind extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jButtonPrint;
	private JButton jButtonExport;
	private JPanel jTableData;
	private Object[][] data;
	private String[] colom;

	public ViewHamaltOfKind(Object[][] data, String[] colom, int num) {
		this.data = data;
		this.colom = colom;
		this.initComponents(num);
	}

	private void initComponents(int num) {
		this.jButtonPrint = new JButton();
		this.jButtonExport = new JButton();
		this.jTableData = new JPanel();
		JTable table = new JTable(this.data, this.colom) {
			private static final long serialVersionUID = 1;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public TableCellRenderer getCellRenderer(int row, int column) {
				return new ViewCellRender(column);
			}
		};
		table.getTableHeader().setFont(new Font("Arial ITC", 0, 16));
		table.setRowHeight(35);
		this.jTableData.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(table);
		this.jTableData.add((Component) scrollPane, "Center");
		this.jButtonPrint.setBackground(new Color(255, 0, 0));
		this.jButtonPrint.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonPrint.setForeground(new Color(255, 255, 255));
		this.jButtonPrint.setText("طباعة");

		this.jButtonExport.setBackground(new Color(255, 0, 0));
		this.jButtonExport.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonExport.setForeground(new Color(255, 255, 255));
		this.jButtonExport.setText("استخراج");

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(this.jTableData, -1, -1, 32767)
								.addGroup(layout.createSequentialGroup().addComponent(this.jButtonPrint, -2, 124, -2)
										.addGap(32, 32, 32).addComponent(this.jButtonExport, -2, 124, -2)))
				.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap().addComponent(this.jTableData, -1, -1, 32767)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
										.addComponent(this.jButtonPrint, -2, 33, -2)
										.addComponent(this.jButtonExport, -2, 33, -2))));
		String header = "حضور رجال";
		String fileName = "men";
		if (num == 1) {
			header = "حضور سيدات";
			fileName = "women";
		} else if (num == 2) {
			TableColumnModel f = table.getColumnModel();
			f.getColumn(1).setMinWidth(100);
			header = "دعاية الحملات";
			fileName = "advertisement";
		}
		this.jButtonPrint.addActionListener(new PrintListner(table, header));
		this.jButtonExport.addActionListener(new ExportExcelListner(table, this, "Hamlat" + "-" + fileName));
	}

}
