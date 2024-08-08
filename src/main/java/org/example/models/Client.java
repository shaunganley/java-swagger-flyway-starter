package org.example.models;

import java.sql.Date;

public class Client {

    private int id;
    private String name;
    private String address;
    private String phone_number;
    private Date create_date;
    private int acquired_by;

    public Client(int id, String name, String address, String phone_number, Date create_date, int acquired_by) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.create_date = create_date;
        this.acquired_by = acquired_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getAcquired_by() {
        return acquired_by;
    }

    public void setAcquired_by(int acquired_by) {
        this.acquired_by = acquired_by;
    }
}
