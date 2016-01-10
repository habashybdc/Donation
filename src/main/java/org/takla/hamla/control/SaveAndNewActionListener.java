package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.run.AllRun;
import org.takla.hamla.view.EditDonor;
import org.takla.hamla.view.ViewDonors;

public class SaveAndNewActionListener implements ActionListener {
	EditDonor edit;
	Donor donator;
	ViewDonors pane;

	public SaveAndNewActionListener(ViewDonors pane, EditDonor edit, Donor pos) {
		this.pane = pane;
		this.edit = edit;
		this.donator = pos;
	}

	public void actionPerformed(ActionEvent e) {
		Donor don = this.edit.getNewData(this.donator.getId());
		int t = 0;
		if (this.donator.getId() == -1) {
			this.donator.setMale(don.isMale());
		}
		if (this.donator.isMale().booleanValue() && don.isMale().booleanValue()) {
			t = this.search(this.donator.getId(), AllRun.hamla.getMenDontators());
			AllRun.hamla.edit(t, don);
		} else if (!this.donator.isMale().booleanValue() && !don.isMale().booleanValue()) {
			t = this.search(this.donator.getId(), AllRun.hamla.getWoMenDontators());
			AllRun.hamla.edit(t, don);
		} else {
			int g = JOptionPane.showConfirmDialog(null, "هل انت واثق من انك تريد نوع " + don.getName()
					+ "\n و هذا معناه انه سوف يتم اضاعة بيانات اذا كانت حضر حملة من قبل ");
			if (g == 0) {
				if (this.donator.isMale().booleanValue()) {
					t = this.search(this.donator.getId(), AllRun.hamla.getMenDontators());
					AllRun.hamla.deleteMenDonors(t);
					AllRun.hamla.edit(-1, don);
					this.pane.setMenView();
				} else {
					t = this.search(this.donator.getId(), AllRun.hamla.getWoMenDontators());
					AllRun.hamla.deleteWomenDonors(t);
					AllRun.hamla.edit(-1, don);
					this.pane.setWomenView();
				}
			}
		}
		Donor dona = new Donor(-1);
		this.edit.setView(dona, false);
		if (don.isMale().booleanValue()) {
			this.pane.setMenView();
		} else {
			this.pane.setWomenView();
		}
	}

	public int search(int id, ArrayList<Donor> array) {
		if (id != -1) {
			int i = 0;
			while (i < array.size()) {
				if (array.get(i).getId() == id) {
					return i;
				}
				++i;
			}
		}
		return -1;
	}
}
