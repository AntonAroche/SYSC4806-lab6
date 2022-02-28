package com.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/books")
    public Iterable<AddressBook> getAddressBooks() {
        return addressBookRepository.findAll();
    }

    @GetMapping(value = "/books/{id}")
    public AddressBook getBook(@PathVariable Integer id) {
        return addressBookRepository.findById(id).orElse(null);
    }

    @PostMapping("/books")
    public AddressBook createBook(@RequestBody AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    @PostMapping(value = "/books/buddy/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AddressBook addBuddy(@PathVariable Integer id, @RequestBody BuddyInfo buddyInfo) {
        AddressBook book = addressBookRepository.findById(id).orElse(null);
        if (book != null) {
            book.addBuddy(buddyInfo);
            return addressBookRepository.save(book);
        }
        return null;
    }

    @DeleteMapping(value = "/books/buddy/{bookID}/{budID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AddressBook removeBuddy(@PathVariable Integer bookID, @PathVariable Integer budID) {
        AddressBook book = addressBookRepository.findById(bookID).orElse(null);
        if (book == null) {
            return null;
        }
        book.removeBuddy(budID);
        return addressBookRepository.save(book);
    }
}
