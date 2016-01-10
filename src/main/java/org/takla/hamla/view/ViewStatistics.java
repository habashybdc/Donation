package org.takla.hamla.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JTabbedPane;

import org.takla.hamla.modle.Donor;
import org.takla.hamla.modle.HasDonate;
import org.takla.hamla.run.AllRun;

public class ViewStatistics extends JTabbedPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] colom;
	private Object[][] dataRecords;

	private String[] howDidYouKnow;

	public ViewStatistics() {
		howDidYouKnow = AllRun.basicData.getHowDidYouKnow();
		String[] recordColom = new String[howDidYouKnow.length + 5];
		int i = howDidYouKnow.length - 1;
		while (i >= 0) {
			recordColom[howDidYouKnow.length - i + 1] = howDidYouKnow[i];
			--i;
		}
		recordColom[recordColom.length - 1] = "الحملة";
		recordColom[recordColom.length - 2] = "بنك الدم";
		recordColom[recordColom.length - 3] = "الايام";
		recordColom[1] = "عدد الحاضورن";
		recordColom[0] = "عدد المتبرعين";
		File yearName = new File("data/Hamlet/");
		File[] monthesNames = yearName.listFiles();
		if (monthesNames == null || monthesNames.length == 0) {
			return;
		}
		this.dataRecords = new Object[monthesNames.length][recordColom.length];
		this.setColoms();
		ViewStatisticstOfKind men = new ViewStatisticstOfKind(this.setData(true), this.colom, 0);
		ViewStatisticstOfKind women = new ViewStatisticstOfKind(this.setData(false), this.colom, 1);
		this.setDataRecord();
		ViewStatisticstOfKind record = new ViewStatisticstOfKind(this.dataRecords, recordColom, 2);
		men.setName("رجال");
		women.setName("سيدات");
		record.setName("تأثير الدعاية");
		this.add(men);
		this.add(women);
		this.add(record);
	}

	private void setDataRecord() {
		int t;
		String[] bank = AllRun.basicData.getBanksName();
		File yearName = new File("data/Hamlet/");
		File[] monthesNames = yearName.listFiles();
		int i = monthesNames.length - 1;
		while (i >= 0) {
			try {
				BufferedReader in = new BufferedReader(
						new FileReader(new File("data/Hamlet/" + monthesNames[i].getName() + "/inf.txt")));
				t = Integer.parseInt(in.readLine());
				this.dataRecords[i][this.dataRecords[i].length - 2] = bank[t];
				this.dataRecords[i][this.dataRecords[i].length - 3] = in.readLine();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			--i;
		}
		i = 0;
		while (i < this.dataRecords.length) {
			int j = 2;
			while (j < this.dataRecords[i].length - 3) {
				t = Integer.parseInt(this.dataRecords[i][j].toString());
				if (t == 0) {
					this.dataRecords[i][j] =0;
				}
				++j;
			}
			++i;
		}
	}

	private void setColoms() {
		File yearName = new File("data/Hamlet/");
		File[] monthesNames = yearName.listFiles();
		this.colom = new String[monthesNames.length + 3];
		int i = monthesNames.length - 1;
		while (i >= 0) {
			this.colom[monthesNames.length - i + 1] = monthesNames[i].getName();
			this.dataRecords[i][howDidYouKnow.length + 4] = " " + monthesNames[i].getName() + " ";
			--i;
		}
		this.colom[this.colom.length - 1] = "الاسم";
		this.colom[1] = "عدد مرات الحضور";
		this.colom[0] = "عدد مرات التبرع";
	}

	private Object[][] setData(boolean kind) {
		Object[][] data = this.getData(kind);
		int i = 0;
		while (i < data.length) {
			int come = 0;
			int donate = 0;
			int j = 2;
			while (j < data[i].length - 1) {
				if (data[i][j] != null) {
					if (data[i][j].equals("+")) {
						++come;
						++donate;
					} else if (data[i][j].equals("-")) {
						++come;
					}
				}
				++j;
			}
			data[i][0] = donate;
			data[i][1] = come;
			++i;
		}
		Iterator<Donor> iterator = null;
		iterator = kind ? AllRun.hamla.getMenDontators().iterator() : AllRun.hamla.getWoMenDontators().iterator();
		int i2 = 0;
		while (iterator.hasNext()) {
			Donor don = iterator.next();
			data[i2][this.colom.length - 1] = " " + don.getName() + " ";
			++i2;
		}
		return data;
	}

	private Object[][] getData(boolean kind) {
		File yearName = new File("data/Hamlet/");
		File[] monthesNames = yearName.listFiles();
		Object[][] ret = kind ? new Object[AllRun.hamla.getMenDontators().size()][monthesNames.length + 3]
				: new Object[AllRun.hamla.getWoMenDontators().size()][monthesNames.length + 3];
		int i = monthesNames.length - 1;
		while (i >= 0) {
			ArrayList<HasDonate> donated = this.loadHamla(monthesNames[i].getName(), kind);
			Iterator<HasDonate> iterator = donated.iterator();
			Integer[] records = new Integer[howDidYouKnow.length];
			Arrays.fill(records, new Integer(0));
			Integer donator_numbers = 0;
			while (iterator.hasNext()) {
				HasDonate don = iterator.next();
				int pos = this.inAll(kind, don.getDonor_Id());
				String g = null;
				if (don.hasDonated()) {
					g = "+";
					++donator_numbers;
				} else {
					g = "-";
				}
				Integer[] arrn = records;
				int n = don.getKnow();
				arrn[n] = arrn[n] + 1;
				ret[pos][monthesNames.length - i + 1] = g;
			}
			int j = 0;
			while (j < records.length) {
				if (kind) {
					this.dataRecords[i][howDidYouKnow.length + 1 - j] = records[j];
				} else {
					int r = Integer.parseInt(this.dataRecords[i][howDidYouKnow.length + 1 - j].toString());
					this.dataRecords[i][howDidYouKnow.length + 1 - j] = records[j] + r;
				}
				++j;
			}
			if (kind) {
				this.dataRecords[i][0] = donator_numbers;
				this.dataRecords[i][1] = donated.size();
			} else {
				this.dataRecords[i][0] = ((Integer) this.dataRecords[i][0]) + donator_numbers;
				this.dataRecords[i][1] = ((Integer) this.dataRecords[i][1]) + donated.size();
			}
			--i;
		}
		return ret;
	}

	private ArrayList<HasDonate> loadHamla(String s, boolean men) {
		ArrayList<HasDonate> don = new ArrayList<HasDonate>();
		try {
			String h = "data/Hamlet/" + s;
			h = men ? String.valueOf(h) + "/men.min" : String.valueOf(h) + "/women.min";
			BufferedReader in = new BufferedReader(new FileReader(new File(h)));
			String temp = in.readLine();
			while (temp != null) {
				String[] split = temp.split(",");
				int temp1 = Integer.parseInt(split[0]);
				int temp2 = 0;
				try {
					temp2 = Integer.parseInt(split[2]);
				} catch (Exception var10_11) {
					// empty catch block
				}
				if (this.inAll(men, temp1) != -1) {
					if (Integer.parseInt(split[1]) == 1) {
						don.add(new HasDonate(temp1, true, temp2));
					} else {
						don.add(new HasDonate(temp1, false, temp2));
					}
				}
				temp = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return don;
	}

	public int inAll(boolean men, int serial) {
		Iterator<Donor> iterator = men ? AllRun.hamla.getMenDontators().iterator()
				: AllRun.hamla.getWoMenDontators().iterator();
		int i = 0;
		Donor don = null;
		while (iterator.hasNext()) {
			don = iterator.next();
			if (don.getId() == serial) {
				return i;
			}
			++i;
		}
		return -1;
	}
}
