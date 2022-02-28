import com.addressbook.AddressBook;
import com.addressbook.BuddyInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AddressBookTest {
    private AddressBook addressBook;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
    }

    @Test
    public void addAndGetBuddy() {
        BuddyInfo buddy = new BuddyInfo("Jane Doe", "123 Address Drive", "613-999-9999");
        addressBook.addBuddy(buddy);
        assertTrue(addressBook.getBuddyInfos().contains(buddy));
    }

    @Test
    public void printBuddies() {
        BuddyInfo buddy = new BuddyInfo("Jane Doe", "123 Address Drive", "613-999-9999");
        addressBook.addBuddy(buddy);

        System.setOut(new PrintStream(outputStreamCaptor));
        addressBook.printBuddies();
        Assert.assertEquals("Jane Doe, 123 Address Drive, 613-999-9999", outputStreamCaptor.toString().trim());
    }

}