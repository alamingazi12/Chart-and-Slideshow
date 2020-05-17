package com.gktech.barchartmultiple;

public class Employee {

    String cid;
    String name;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String cid, String name) {
        this.cid = cid;
        this.name = name;
    }
}
