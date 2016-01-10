package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.view.EditDonor;

public class CancelActionListener
implements ActionListener {
    private EditDonor edit;
    private JTabbedPane pane;
    private Donor don;

    public CancelActionListener(JTabbedPane pane, EditDonor edit, Donor don) {
        this.pane = pane;
        this.edit = edit;
        this.don = don;
    }

    public void actionPerformed(ActionEvent e) {
        this.pane.remove(this.edit);
        if (this.don.isMale().booleanValue()) {
            this.pane.setSelectedIndex(0);
        } else {
            this.pane.setSelectedIndex(1);
        }
    }
}

