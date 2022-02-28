import com.addressbook.BuddyInfo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BuddyInfoTest {
    private BuddyInfo buddy;

    @Before
    public void setUp() throws Exception {
        buddy = new BuddyInfo("Jane Doe", "123 Address Drive", "613-999-9999");
    }

    @Test
    public void getName() {
        assertEquals("Jane Doe", buddy.getName());
    }

    @Test
    public void setName() {
        buddy.setName("John Dee");
        assertEquals("John Dee", buddy.getName());
    }

    @Test
    public void getAddress() {
        assertEquals("123 Address Drive", buddy.getAddress());
    }

    @Test
    public void setAddress() {
        buddy.setAddress("321 Location Avenue");
        assertEquals("321 Location Avenue", buddy.getAddress());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("613-999-9999", buddy.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        buddy.setPhoneNumber("613-111-1111");
        assertEquals("613-111-1111", buddy.getPhoneNumber());
    }

    @Test
    public void testToString() {
        assertEquals("Jane Doe, 123 Address Drive, 613-999-9999", buddy.toString());
    }
}