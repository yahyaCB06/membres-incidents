package com.example.demo.model;

import java.sql.Date;

public class Incident {
    private int reference;
    private Date time;
    private String status;

    public Incident(int reference, Date time, String status) {
        this.reference = reference;
        this.time = time;
        this.status = status;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
