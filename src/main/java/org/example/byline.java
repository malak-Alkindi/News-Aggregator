package org.example;

import java.util.ArrayList;

public class byline {
    String original;
    String organization;
    ArrayList<person> person = new ArrayList<person>();

    public ArrayList<org.example.person> getPerson() {
        return person;
    }

    public void setPerson(ArrayList<org.example.person> person) {
        this.person = person;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
