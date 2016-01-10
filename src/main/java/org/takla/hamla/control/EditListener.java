package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.view.ButtonTabComponent;
import org.takla.hamla.view.EditDonor;
import org.takla.hamla.view.ViewDonorOfKind;
import org.takla.hamla.view.ViewDonors;

public class EditListener implements ActionListener {
	private ViewDonorOfKind view;
	private ArrayList<Donor> donators;
	private ViewDonors theTwoPane;

	public EditListener(ViewDonorOfKind table, ArrayList<Donor> youthes, ViewDonors theTwoPane,
			JTabbedPane otherTabs) {
		this.donators = youthes;
		this.theTwoPane = theTwoPane;
		this.view = table;
	}

	public void actionPerformed(ActionEvent arg0) {
		JTable table = this.view.getTable2();
		if (table.getSelectedRow() != -1) {
			Donor pos = this
					.search(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
			EditDonor tab = new EditDonor(pos, this.theTwoPane, false);
			this.theTwoPane.add(tab);
			this.theTwoPane.setSelectedComponent(tab);
			this.theTwoPane.setTabComponentAt(this.theTwoPane.getSelectedIndex(),
					new ButtonTabComponent(this.theTwoPane));
		} else {
			JOptionPane.showMessageDialog(null,
					"من فضلك اختار الاسم المراد  تعديله",
					"تحذير", 0);
		}
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
}
