
package com.university;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {

    private IntegerProperty id;
    private StringProperty regNumber;
    private StringProperty firstName;
    private StringProperty lastName;

    public Student(int id, String regNumber, String firstName, String lastName) {
        this.id = new SimpleIntegerProperty(id);
        this.regNumber = new SimpleStringProperty(regNumber);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty regNumberProperty() {
        return regNumber;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getRegNumber() {
        return regNumber.get();
    }
}

