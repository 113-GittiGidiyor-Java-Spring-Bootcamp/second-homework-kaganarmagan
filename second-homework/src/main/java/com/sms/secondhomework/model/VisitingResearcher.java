package com.sms.secondhomework.model;


import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor{
    private double hourlySalary;

    public VisitingResearcher(String name, String address, long phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher() {
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
