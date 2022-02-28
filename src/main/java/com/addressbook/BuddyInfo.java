package com.addressbook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Integer id = null;

    private String name;
    private String address;
    private String phoneNumber;

    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo() {
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
    }

    public static void main(String[] args) {
        BuddyInfo myBuddy = new BuddyInfo("Jane Doe", "123 Address Drive", "613-999-9999");

        System.out.println("Hello " + myBuddy.getName());
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return this.name + ", " + this.address + ", " + this.phoneNumber + "\n";
    }
}
