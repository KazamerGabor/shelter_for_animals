package hu.progmasters;

public class Worker extends Person {
    private int workerId;

    public Worker(String name, int phoneNumber, String address) {
        super(name, phoneNumber, address);
    }

    public Worker(int workerId, String name, int phoneNumber, String address) {
        super(name, phoneNumber, address);
        this.workerId = workerId;
    }

    public int getWorkerId() {
        return workerId;
    }
}
