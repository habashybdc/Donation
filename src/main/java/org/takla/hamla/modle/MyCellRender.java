/*
 * Decompiled with CFR 0_110.
 */
package org.takla.hamla.modle;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyCellRender extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6495695973343509797L;

	int colom;

	public MyCellRender(int colom) {
		this.colom = colom;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JLabel renderedLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);
		if (this.colom == 7 || this.colom == 9) {
			renderedLabel.setHorizontalAlignment(0);
		} else {
			renderedLabel.setHorizontalAlignment(4);
		}
		return renderedLabel;
	}
}
