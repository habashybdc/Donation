package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.modle.HasDonate;
import org.takla.hamla.view.ViewDonorHamla;

public class AddInActionListener implements ActionListener {
	private ArrayList<HasDonate> come;
	private ArrayList<Donor> current;
	private ViewDonorHamla Donhamla;
	private JTable table;
	private JComboBox<String> combo;

	public AddInActionListener(ArrayList<Donor> all, ArrayList<HasDonate> current, JTable table,
			ViewDonorHamla Donhamla, JComboBox<String> combo) {
		this.current = all;
		this.come = current;
		this.Donhamla = Donhamla;
		this.table = table;
		this.combo = combo;
	}

	public void setAddIn(JTable table) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (this.table.getSelectedRow() != -1) {
			this.Donhamla.setCome();
			this.current = this.Donhamla.current;
			Donor pos = this.search(
					Integer.parseInt(this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString()));
			this.come.add(new HasDonate(pos.getId(), false, this.combo.getSelectedIndex()));
			this.Donhamla.copyArray(this.Donhamla.getText());
			this.Donhamla.view();
			this.Donhamla.validate();
		} else {
			JOptionPane.showMessageDialog(null,
					"من فضلك اختار الاسم المراد ادخاله الى الحملة",
					"تحذير", 0);
		}
	}

	private Donor search(int serial) {
		Iterator<Donor> iterator = this.current.iterator();
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (don.getId() != serial)
				continue;
			return don;
		}
		return null;
	}
}
