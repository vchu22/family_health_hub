package io.github.vchu22.family_and_pets_health_tracker.api.model;

import java.time.LocalDate;
import java.time.Period;

public class HouseholdMember {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName; // derived from firstName + lastName
    private char gender;
    private LocalDate DOB;
    private String species;

    public HouseholdMember(int id, String firstName, String lastName, char gender, LocalDate DOB, String species) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setFullName();
        this.gender = gender;
        this.DOB = DOB;
        this.species = species;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setFullName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName();
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Period.between(DOB, now).getYears();
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }

    // derived information
    private void setFullName() {
        this.fullName = firstName + (lastName.length() == 0? "" : " " + lastName);
    }

    public boolean isPerson() {
        return this.species.equals("human");
    }
}
