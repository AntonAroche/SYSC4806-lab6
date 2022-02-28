package com.addressbook;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {
    List<AddressBook> findByName(String name);

   // AddressBook findById(Integer id);
}