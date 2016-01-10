package org.takla.hamla.modle;

import java.util.Date;

public class Donor {
	private int id;
	private String name;
	private Address address;
	private String mobile;
	private String e_mail;
	private String father;
	private String church;
	private int bloodType;
	private Date dob;
	private boolean male;
	private boolean canDonate;

	public Donor(int id) {
		this.id = id;
	}

	public Donor(int id, String name, Address address, String mobile, String e_mail, String father, String church,
			int bloodType, Date dob, boolean sex, boolean canDonate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.e_mail = e_mail;
		this.father = father;
		this.bloodType = bloodType;
		this.church = church;
		this.dob = dob;
		this.male = sex;
		this.canDonate = canDonate;
	}

	@SuppressWarnings("deprecation")
	public Donor(String data, boolean sex) {
		String[] dat = data.split(",min,");
		String[] date = dat[8].split("-");
		this.setDonor(Integer.parseInt(dat[0]), dat[1], new Address(dat[2]), dat[3], dat[4], dat[5], dat[6],
				Integer.parseInt(dat[7]),
				new Date(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0])));
		if (dat[9].compareTo("1") == 0) {
			this.setCanDonate(true);
		} else {
			this.setCanDonate(false);
		}
		this.setMale(sex);
	}

	public String toSave() {
		String temp = String.valueOf(this.id) + ",min," + this.name + ",min," + this.address.toSave() + ",min,"
				+ this.mobile + ",min," + this.e_mail + ",min," + this.father + ",min," + this.church + ",min,"
				+ this.bloodType + ",min," + this.dateToString() + ",min,";
		temp = this.canDonate ? String.valueOf(temp) + 1 : String.valueOf(temp) + 0;
		return temp;
	}

	public void setId(int id) {
		this.id = id;
	}

	@SuppressWarnings("deprecation")
	public String dateToString() {
		return String.valueOf(this.dob.getDate()) + "-" + this.dob.getMonth() + "-" + this.dob.getYear();
	}

	public void setDonor(int id, String name, Address address, String mobile, String e_mail, String father,
			String church, int bloodType, Date dob) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.e_mail = e_mail;
		this.father = father;
		this.church = church;
		this.bloodType = bloodType;
		this.dob = dob;
	}

	public Boolean isMale() {
		return this.male;
	}

	public void setMale(Boolean sex) {
		this.male = sex;
	}

	public Boolean CanDonate() {
		return this.canDonate;
	}

	public void setCanDonate(Boolean canDonate) {
		this.canDonate = canDonate;
	}

	public String getName() {
		return this.name;
	}

	public Address getAddress() {
		return this.address;
	}

	public String getMobile() {
		return this.mobile;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public int getId() {
		return this.id;
	}

	public String getFather() {
		return this.father;
	}

	public String getChurch() {
		return this.church;
	}

	public boolean isCanDonate() {
		return this.canDonate;
	}

	public Date getDob() {
		return this.dob;
	}

	@SuppressWarnings("deprecation")
	public String DobToView() {
		if (this.dob.getYear() == 1940) {
			return " ";
		}
		int date = this.dob.getDate();
		int month = this.dob.getMonth() + 1;
		int year = this.dob.getYear() + 1;
		return String.valueOf(date) + " - " + month + " - " + year;
	}

	@SuppressWarnings("deprecation")
	public int getDay() {
		return this.dob.getDate();
	}

	@SuppressWarnings("deprecation")
	public int getMonth() {
		return this.dob.getMonth() + 1;
	}

	@SuppressWarnings("deprecation")
	public int getYear() {
		return this.dob.getYear() + 1;
	}

	public int getBloodType() {
		return this.bloodType;
	}
}
