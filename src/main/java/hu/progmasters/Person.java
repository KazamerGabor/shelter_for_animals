package hu.progmasters;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected String name;
    protected int phoneNumber;
    protected String address;
    List<Owner> ownerList = new ArrayList<>();
    List<Volunteer> volunteerList = new ArrayList<>();
    List<Worker> workerList = new ArrayList();


    public Person(String name, int phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
