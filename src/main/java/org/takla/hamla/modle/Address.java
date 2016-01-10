package org.takla.hamla.modle;

public class Address {
    private String flat;
    private String floor;
    private String house;
    private String street;
    private String zone;

    public Address(String flat, String floor, String house, String street, String zone) {
        this.flat = flat.trim().compareTo("") == 0 ? " " : flat.trim();
        this.floor = floor.trim().compareTo("") == 0 ? " " : floor.trim();
        this.house = house.trim().compareTo("") == 0 ? " " : house.trim();
        this.street = street.trim().compareTo("") == 0 ? " " : street.trim();
        this.zone = zone.trim().compareTo("") == 0 ? " " : zone.trim();
    }

    public Address(String data) {
        String[] dat = data.split(",mina,");
        this.setAddress(dat[0], dat[1], dat[2], dat[3], dat[4]);
    }

    public void setAddress(String flat, String floor, String house, String street, String zone) {
        this.flat = flat;
        this.floor = floor;
        this.house = house;
        this.street = street;
        this.zone = zone;
    }

    public String getFlat() {
        return this.flat;
    }

    public String getFloor() {
        return this.floor;
    }

    public String getHouse() {
        return this.house;
    }

    public String getStreet() {
        return this.street;
    }

    public String getZone() {
        return this.zone;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String toSave() {
        return String.valueOf(this.flat) + ",mina," + this.floor + ",mina," + this.house + ",mina," + this.street + ",mina," + this.zone;
    }

    public String toview() {
        String temp = String.valueOf(this.getHouse()) + " " + this.getStreet();
        if (this.floor.compareTo(" ") != 0) {
            temp = String.valueOf(temp) + " الدور " + this.getFloor();
        }
        if (this.flat.compareTo(" ") != 0) {
            temp = String.valueOf(temp) + " شقة " + this.getFlat();
        }
        if (this.zone.compareTo(" ") != 0) {
            temp = String.valueOf(temp) + "," + this.getZone();
        }
        return temp;
    }
}

