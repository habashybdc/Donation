package org.takla.hamla.view;

import javax.swing.JTabbedPane;

import org.takla.hamla.run.AllRun;

public class ViewDonors
extends JTabbedPane {
    private static final long serialVersionUID = 1;
    private ViewDonorOfKind men;
    private ViewDonorOfKind women;
    private JTabbedPane tabs;

    public ViewDonors(JTabbedPane tabs) {
        this.tabs = tabs;
        this.setAutoscrolls(true);
        this.setName("عرض البيانات");
        this.men = new ViewDonorOfKind(AllRun.hamla.getMenDontators(), this, tabs);
        this.women = new ViewDonorOfKind(AllRun.hamla.getWoMenDontators(), this, tabs);
        this.men.setName("رجال");
        this.women.setName("سيدات");
        this.add(this.men);
        this.add(this.women);
    }

    public void setMenView() {
        this.men.removeAll();
        this.men.setview(AllRun.hamla.getMenDontators(), this, this.tabs);
    }

    public void setWomenView() {
        this.women.removeAll();
        this.women.setview(AllRun.hamla.getWoMenDontators(), this, this.tabs);
    }
}

