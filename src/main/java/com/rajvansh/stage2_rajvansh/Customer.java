package com.rajvansh.stage2_rajvansh;

public class Customer {
    private String customerId;
    private String name;
    private String contactDetails;

    // Constructor
    public Customer(String customerId, String name, String contactDetails) {
        this.customerId = customerId;
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getter and Setter methods
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Contact: " + contactDetails;
    }
}
