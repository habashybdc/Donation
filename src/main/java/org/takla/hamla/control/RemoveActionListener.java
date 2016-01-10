package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.modle.HasDonate;
import org.takla.hamla.view.ViewDonorHamla;

public class RemoveActionListener implements ActionListener {
	ArrayList<HasDonate> current;
	ArrayList<Donor> all;
	ViewDonorHamla Donhamla;
	JTable table;

	public RemoveActionListener(ArrayList<Donor> all, ArrayList<HasDonate> current, JTable table,
			ViewDonorHamla Donhamla) {
		this.all = all;
		this.current = current;
		this.Donhamla = Donhamla;
		this.table = table;
	}

	public void setRemove(JTable table) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (this.table.getSelectedRow() != -1) {
			this.Donhamla.setCome();
			int temp = this.table.getSelectedRow();
			int y = Integer.parseInt(this.table.getModel().getValueAt(temp, 0).toString());
			this.current.remove(this.search(y));
			this.Donhamla.copyArray(this.Donhamla.getText());
			this.Donhamla.view();
			this.Donhamla.validate();
		} else {
			JOptionPane.showMessageDialog(null, "من فضلك اختار الاسم المراد اخراجه من السته", "تحذير", 0);
		}
	}

	private int search(int serial) {
		Iterator<HasDonate> iterator = this.current.iterator();
		HasDonate don = null;
		int i = 0;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (don.getDonor_Id() == serial) {
				return i;
			}
			++i;
		}
		return -1;
	}
}
