package hu.progmasters;

public class Volunteer extends Person {

    private int volunteerId;

    public Volunteer(String name, int phoneNumber, String address) {
        super(name, phoneNumber, address);
    }

    public Volunteer(int volunteerId, String name, int phoneNumber, String address) {
        super(name, phoneNumber, address);
        this.volunteerId = volunteerId;


    }

    public int getVolunteerId() {
        return volunteerId;
    }

}
