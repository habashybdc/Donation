package org.takla.hamla.modle;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewCellRender extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8878943802975445844L;
	int colom;

	public ViewCellRender(int colom) {
		this.colom = colom;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel renderedLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);
		if (this.colom != table.getColumnCount() - 1) {
			renderedLabel.setHorizontalAlignment(0);
			renderedLabel.setFont(new Font("Arial ITC", 1, 20));
		} else {
			renderedLabel.setHorizontalAlignment(4);
			renderedLabel.setFont(new Font("Arial ITC", 1, 17));
		}
		return renderedLabel;
	}
}
