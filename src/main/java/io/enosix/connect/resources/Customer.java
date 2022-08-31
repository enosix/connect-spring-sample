package io.enosix.connect.resources;

public class Customer {
    public String name;
    public String customerNumber;
    public String city;
    public String region;
    public String countryKey;

    public Customer() {
    }

    public Customer(String name, String customerNumber, String city, String region, String countryKey) {
        this.name = name;
        this.customerNumber = customerNumber;
        this.city = city;
        this.region = region;
        this.countryKey = countryKey;
    }
}
