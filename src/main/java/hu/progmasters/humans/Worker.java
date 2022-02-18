package hu.progmasters.humans;

public class Worker extends Person {
    private int workerId;

    public Worker(String name, String phoneNumber, Address address) {
        super(name, phoneNumber, address);
    }

    public Worker(int workerId, String name, String phoneNumber, Address address) {
        super(name, phoneNumber, address);
        this.workerId = workerId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
