package org.takla.hamla.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.takla.hamla.modle.Donor;

public class Hamla {
    ArrayList<Donor> menDonors = new ArrayList<Donor>();
    ArrayList<Donor> woMenDonors = new ArrayList<Donor>();
    int last_men = 0;
    int last_woMen = 0;

    public int getLast_men() {
        return this.last_men;
    }

    public int getLast_woMen() {
        return this.last_woMen;
    }

    public Hamla() {
        this.LoadDonor();
    }

    public ArrayList<Donor> getMenDontators() {
        return this.menDonors;
    }

    public ArrayList<Donor> getWoMenDontators() {
        return this.woMenDonors;
    }

    public void LoadDonor() {
        this.menDonors.clear();
        this.woMenDonors.clear();
        try {
            Donor d;
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("data/men.min")), "UTF8"));
            String line = in.readLine();
            while (line != null) {
                d = new Donor(line, true);
                if (d.getId() > this.last_men) {
                    this.last_men = d.getId();
                }
                this.menDonors.add(d);
                line = in.readLine();
            }
            in.close();
            in = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(new File("data/women.min")), "UTF8"));
            line = in.readLine();
            while (line != null) {
                d = new Donor(line, false);
                if (d.getId() > this.last_woMen) {
                    this.last_woMen = d.getId();
                }
                this.woMenDonors.add(d);
                line = in.readLine();
            }
            in.close();
        }
        catch (Exception e) {
            File f = new File("data/women.min");
            File f2 = new File("data/men.min");
            f.mkdir();
            f2.mkdir();
        }
    }

    public void saveMenDonor() {
        this.sortMen();
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("data/men.min")), "UTF8"));
            int i = 0;
            while (i < this.menDonors.size()) {
                out.write(String.valueOf(this.menDonors.get(i).toSave()) + "\n");
                ++i;
            }
            out.close();
        }
        catch (Exception i) {
            // empty catch block
        }
    }

    public void saveWoMenDonor() {
        this.sortWoMen();
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("data/women.min")), "UTF8"));
            int i = 0;
            while (i < this.woMenDonors.size()) {
                out.write(String.valueOf(this.woMenDonors.get(i).toSave()) + "\n");
                ++i;
            }
            out.close();
        }
        catch (Exception i) {
            // empty catch block
        }
    }

    public void deleteMenDonors(int pos) {
        this.menDonors.remove(pos);
    }

    public void deleteWomenDonors(int pos) {
        this.woMenDonors.remove(pos);
    }

    public void edit(int pos, Donor d) {
        if (d.isMale().booleanValue()) {
            if (pos == -1) {
                ++this.last_men;
                d.setId(this.last_men);
                this.menDonors.add(d);
            } else {
                this.menDonors.set(pos, d);
            }
            this.saveMenDonor();
        } else {
            if (pos == -1) {
                ++this.last_woMen;
                d.setId(this.last_woMen);
                this.woMenDonors.add(d);
            } else {
                this.woMenDonors.set(pos, d);
            }
            this.saveWoMenDonor();
        }
    }

    public int menSize() {
        return this.menDonors.size();
    }

    public int woMenSize() {
        return this.woMenDonors.size();
    }
    
    public File[] getHamalatFolders(){
    	final File file = new File("data/Hamlet");
		return file.listFiles();
    }
    
    
    private void sortMen() {
        boolean finished = false;
        int counter = 0;
        while (!finished && counter < this.menDonors.size() - 1) {
            ++counter;
            finished = true;
            int i = this.menDonors.size() - 2;
            while (i >= 0) {
                if (this.menDonors.get(i).getName().compareTo(this.menDonors.get(i + 1).getName()) > 0) {
                    this.swapMen(i, i + 1);
                    finished = false;
                }
                --i;
            }
        }
    }

    private void sortWoMen() {
        boolean finished = false;
        int counter = 0;
        while (!finished && counter < this.woMenDonors.size() - 1) {
            ++counter;
            finished = true;
            int i = this.woMenDonors.size() - 2;
            while (i >= 0) {
                if (this.woMenDonors.get(i).getName().compareTo(this.woMenDonors.get(i + 1).getName()) > 0) {
                    this.swapWo(i, i + 1);
                    finished = false;
                }
                --i;
            }
        }
    }

    private void swapWo(int i, int j) {
        Donor temp = this.woMenDonors.get(i);
        this.woMenDonors.set(i, this.woMenDonors.get(j));
        this.woMenDonors.set(j, temp);
    }

    private void swapMen(int i, int j) {
        Donor temp = this.menDonors.get(i);
        this.menDonors.set(i, this.menDonors.get(j));
        this.menDonors.set(j, temp);
    }
}

