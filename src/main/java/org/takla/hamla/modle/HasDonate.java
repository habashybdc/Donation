package org.takla.hamla.modle;

public class HasDonate {
    private int donator_id;
    private boolean donated;
    private int know;

    public HasDonate(int donator_id, boolean donated, int know) {
        this.donator_id = donator_id;
        this.donated = donated;
        this.know = know;
    }

    public int getDonor_Id() {
        return this.donator_id;
    }

    public boolean hasDonated() {
        return this.donated;
    }

    public void setDonated(boolean donated) {
        this.donated = donated;
    }

    public String toSave() {
        if (this.hasDonated()) {
            return String.valueOf(this.donator_id) + "," + 1 + "," + this.know;
        }
        return String.valueOf(this.donator_id) + "," + 0 + "," + this.know;
    }

    public int getKnow() {
        return this.know;
    }

    public void setKnow(int know) {
        this.know = know;
    }
}

