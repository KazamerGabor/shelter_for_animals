package hu.progmasters.humans;

public class Owner extends Person {
    protected int ownerId;


    public Owner(int ownerId, String name, int phoneNumber, Address address) {
        super(name, phoneNumber, address);
        this.ownerId = ownerId;
    }

    public Owner(String name, int phoneNumber, Address address) {
        super(name, phoneNumber, address);
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
