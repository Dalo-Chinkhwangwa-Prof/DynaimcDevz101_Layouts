package com.dynamicdevz.dynammicdevz101.model;

import java.io.Serializable;

public class Human implements Serializable {

    private String name;
    private String dob;
    private double netWorth;

    public Human(String name, String dob, double netWorth) {
        this.name = name;
        this.dob = dob;
        this.netWorth = netWorth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    @Override
    public String toString() {
        return name + " born on "+dob+" has a net worth of $"+netWorth;
    }
}
