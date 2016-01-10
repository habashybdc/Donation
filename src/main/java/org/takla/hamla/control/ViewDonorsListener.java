package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import org.takla.hamla.view.ButtonTabComponent;
import org.takla.hamla.view.ViewDonors;

public class ViewDonorsListener implements ActionListener {
	JTabbedPane tabs;

	public ViewDonorsListener(JTabbedPane tabs) {
		this.tabs = tabs;
	}

	public void actionPerformed(ActionEvent arg0) {
		ViewDonors tab = new ViewDonors(this.tabs);
		this.tabs.add(tab);
		this.tabs.setSelectedComponent(tab);
		this.tabs.setTabComponentAt(this.tabs.getSelectedIndex(), new ButtonTabComponent(this.tabs));
	}
}
