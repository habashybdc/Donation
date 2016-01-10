package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

import javax.swing.JTable;

public class PrintListner implements ActionListener {
	JTable table;
	String header;

	public PrintListner(JTable table, String Header) {
		this.header = Header;
		this.table = table;
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
			MessageFormat headerFormat = new MessageFormat(this.header);
			MessageFormat footerFormat = new MessageFormat("- {0} -");
			this.table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
		} catch (PrinterException pe) {
			System.err.println("Error printing: " + pe.getMessage());
		}
	}
}
