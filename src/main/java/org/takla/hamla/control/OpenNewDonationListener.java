package org.takla.hamla.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import org.takla.hamla.view.ButtonTabComponent;
import org.takla.hamla.view.OpenHamla;
 
public class OpenNewDonationListener
implements ActionListener {
    JTabbedPane allPane;

    public OpenNewDonationListener(JTabbedPane allPane) {
        this.allPane = allPane;
    }

    public void actionPerformed(ActionEvent e) {
        OpenHamla h = new OpenHamla(this.allPane);
        h.setName("فتح الحملات");
        this.allPane.add(h);
        this.allPane.setSelectedComponent(h);
        this.allPane.setTabComponentAt(this.allPane.getSelectedIndex(), new ButtonTabComponent(this.allPane));
    }
}

