package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.view.ButtonTabComponent;
import org.takla.hamla.view.EditDonor;
import org.takla.hamla.view.ViewDonors;

public class AddNewActionListener implements ActionListener {
	private ViewDonors theTwoPane;

	public AddNewActionListener(ViewDonors theTwoPane, JTabbedPane otherTabs) {
		this.theTwoPane = theTwoPane;
	}

	public void actionPerformed(ActionEvent arg0) {
		Donor don = new Donor(-1);
		EditDonor tab = new EditDonor(don, this.theTwoPane, false);
		this.theTwoPane.add(tab);
		this.theTwoPane.setSelectedComponent(tab);
		this.theTwoPane.setTabComponentAt(this.theTwoPane.getSelectedIndex(), new ButtonTabComponent(this.theTwoPane));
	}
}
