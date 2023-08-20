import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        contactService.addContact();
        List<Contact> contactList = contactService.getContactList();
        Assertions.assertEquals(1, contactList.size());
        Assertions.assertEquals("INITIAL", contactList.get(0).getFirstName());
    }

    @Test
    public void testAddContactWithFirstName() {
        contactService.addContact("Zion");
        List<Contact> contactList = contactService.getContactList();
        Assertions.assertEquals(1, contactList.size());
        Assertions.assertEquals("Zion", contactList.get(0).getFirstName());
    }

    @Test
    public void testDeleteContact() throws Exception {
        contactService.addContact("Zion");
        List<Contact> contactList = contactService.getContactList();
        Assertions.assertEquals(1, contactList.size());

        String contactId = contactList.get(0).getContactId();
        contactService.deleteContact(contactId);

        contactList = contactService.getContactList();
        Assertions.assertEquals(0, contactList.size());
    }

    @Test
    public void testUpdateFirstName() throws Exception {
        contactService.addContact("Zion");
        List<Contact> contactList = contactService.getContactList();
        Assertions.assertEquals(1, contactList.size());

        String contactId = contactList.get(0).getContactId();
        contactService.updateFirstName(contactId, "Ziona");

        Assertions.assertEquals("Ziona", contactList.get(0).getFirstName());
    }

    @Test
    public void testUpdatePhoneNumber() throws Exception {
        contactService.addContact("Zion");
        List<Contact> contactList = contactService.getContactList();
        Assertions.assertEquals(1, contactList.size());

        String contactId = contactList.get(0).getContactId();
        contactService.updatePhoneNumber(contactId, "9876543210");

        Assertions.assertEquals("9876543210", contactList.get(0).getPhoneNumber());
    }
}
