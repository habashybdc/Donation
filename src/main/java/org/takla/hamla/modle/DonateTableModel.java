package org.takla.hamla.modle;

import javax.swing.table.AbstractTableModel;

import org.takla.hamla.view.ViewDonorHamla;

public class DonateTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5796010728382719105L;

	private Object[][] data;
	private ViewDonorHamla hamla;
	private String[] columnNames = new String[] { "id", "عرفت منين",
			"الاسم", "تبرع" };

	public DonateTableModel(Object[][] data, ViewDonorHamla hamla) {
		this.data = data;
		this.hamla = hamla;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public Object[][] getData() {
		return this.data;
	}

	public int getColumnCount() {
		return this.columnNames.length;
	}

	public int getRowCount() {
		return this.data.length;
	}

	@Override
	public String getColumnName(int col) {
		return this.columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}
	
	public Class<? extends Object> getColumnClass(int c) {
		return this.getValueAt(0, c).getClass();
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		if (col < 2) {
			return false;
		}
		return true;
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		this.data[row][col] = value;
		this.hamla.setCome();
		this.fireTableCellUpdated(row, col);
	}
}
