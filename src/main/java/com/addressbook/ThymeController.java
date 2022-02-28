package com.addressbook;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class ThymeController {
    private final AddressBookRepository addressBookRepository;
    private String getUri (String path) {
        return "http://localhost:8080/" + path;
    }
    @GetMapping("/")
    public String getBooks(@ModelAttribute("addressBook") AddressBook addressBook,
                           BindingResult bindingResult, Model model) {
        printBindingErrors(bindingResult);

        Iterable<AddressBook> addressBooks = addressBookRepository.findAll();
        model.addAttribute("books", addressBooks);

        return "index";
    }

    @PostMapping("/book")
    public String createBook(@ModelAttribute("addressBook") AddressBook addressBook,
                             BindingResult bindingResult, Model model) {
        printBindingErrors(bindingResult);

        addressBookRepository.save(addressBook);
        Iterable<AddressBook> addressBooks = addressBookRepository.findAll();
        model.addAttribute("books", addressBooks);

        return "index";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable Integer id, @ModelAttribute("buddyInfo") BuddyInfo buddyInfo,
                          BindingResult bindingResult, Model model) {;
        printBindingErrors(bindingResult);

        AddressBook book = addressBookRepository.findById(id).orElse(null);

        if (book != null) {
            model.addAttribute("id", id);
            model.addAttribute("buddies", book.getBuddyInfos());
        }
        return "book";
    }

    @PostMapping("/book/{id}")
    public String addBuddy(@PathVariable Integer id,
                           @ModelAttribute("buddyInfo") BuddyInfo buddyInfo,
                           BindingResult bindingResult,
                           Model model) {
        printBindingErrors(bindingResult);
        AddressBook book = addressBookRepository.findById(id).orElse(null);

        if (book != null) {
            book.addBuddy(buddyInfo);
            addressBookRepository.save(book);
            model.addAttribute("id", id);
            model.addAttribute("buddies", book.getBuddyInfos());
        }
        return "book";
    }

    private void printBindingErrors(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            System.out.println("There was a error " + bindingResult);
        }
    }
}
