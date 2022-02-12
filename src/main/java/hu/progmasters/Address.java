package hu.progmasters;

public class Address {

    private int addressId;
    private int postalCode;
    private String city;
    private String street;
    private int number;

    public Address(int addressId, int postalCode, String city, String street, int number) {
        this.addressId = addressId;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address(int postalCode, String city, String street, int number) {

        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public int getAddressId() {
        return addressId;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
