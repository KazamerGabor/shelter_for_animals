package hu.progmasters.humans;

public class Address {

    private int addressId;
    private int postalCode;
    private String city;
    private String street;
    private String number;

    public Address(int addressId, String city, int postalCode, String street, String number) {
        this.addressId = addressId;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Address(String city, int postalCode, String street, String number) {

        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
