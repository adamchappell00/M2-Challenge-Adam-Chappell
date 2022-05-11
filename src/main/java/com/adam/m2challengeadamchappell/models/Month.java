package com.adam.m2challengeadamchappell.models;

// Java Imports
import java.util.Objects;

public class Month {

    // Fields
    private Integer number;
    private String name;

    // Constructors
    public Month(){}

    public Month(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    // Unique Methods : NONE

    // Standard Methods - Equals, HashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(number, month.number) && Objects.equals(name, month.name);
    }
    // Standard Methods - Getters & Setters
    public Integer getNumber() {return number;}
    public void setNumber(Integer number) {this.number = number;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "Month{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}