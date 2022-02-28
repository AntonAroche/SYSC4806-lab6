package com.addressbook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Integer id = null;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyInfos;

    public AddressBook() {
        this("Default");
    }

    public AddressBook(String name) {
        this.name = name;
        this.buddyInfos = new ArrayList<BuddyInfo>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }
    public List<BuddyInfo> getBuddyInfos() {
        return this.buddyInfos;
    }

    public void setBuddyInfos(ArrayList<BuddyInfo> buddies) {
        this.buddyInfos = buddies;
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddyInfos.add(buddy);
    }

    public void removeBuddy(Integer id) {
        for (int i = 0; i < this.buddyInfos.size(); i++) {
            if (this.buddyInfos.get(i).getId().equals(id)) {
                this.buddyInfos.remove(i);
                break;
            }
        }
    }

    public void printBuddies() {
        for (BuddyInfo buddy: buddyInfos) {
            System.out.println(buddy.toString());
        }
    }

    public String toString() {
        return this.id.toString() + ": " + this.name;
    }

    public static void main(String[] args) {
        BuddyInfo myBuddy = new BuddyInfo("Jane Doe", "123 Address Drive", "613-999-9999");
        BuddyInfo myBuddy2 = new BuddyInfo("John Dee", "321 Location Avenue", "613-111-1111");

        AddressBook addressBook = new AddressBook();

        addressBook.addBuddy(myBuddy);
        addressBook.addBuddy(myBuddy2);
        addressBook.printBuddies();
    }
}
