import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact();
    }

    @Test
    public void testDefaultConstructor() {
        Assertions.assertEquals("INITIAL", contact.getContactId());
        Assertions.assertEquals("INITIAL", contact.getFirstName());
        Assertions.assertEquals("INITIAL", contact.getLastName());
        Assertions.assertEquals("1235551234", contact.getPhoneNumber());
        Assertions.assertEquals("INITIAL", contact.getAddress());
    }

    @Test
    public void testUpdateFirstName() {
        contact.updateFirstName("Zion");
        Assertions.assertEquals("Zion", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        contact.updateLastName("Johnson");
        Assertions.assertEquals("Johnson", contact.getLastName());
    }

    @Test
    public void testUpdatePhoneNumber() {
        contact.updatePhoneNumber("9876543210");
        Assertions.assertEquals("9876543210", contact.getPhoneNumber());
    }

    @Test
    public void testUpdateAddress() {
        contact.updateAddress("444 Sunset Blvd");
        Assertions.assertEquals("444 Sunset Blvd", contact.getAddress());
    }

    @Test
    public void testUpdateContactId() {
        contact.updateContactId("BOY444");
        Assertions.assertEquals("BOY444", contact.getContactId());
    }
}
