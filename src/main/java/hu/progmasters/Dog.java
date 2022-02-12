package hu.progmasters;

public class Dog {
    protected int id;
    protected String breed;
    protected String name;
    protected String dateOfBirth;
    protected String status;

    public Dog(int id, String breed, String name, String dateOfBirth, String status) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    public Dog(String breed, String name, String dateOfBirth, String status) {
        this.breed = breed;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
