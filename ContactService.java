import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

    // Instance variables
    private List<Contact> contactList = new ArrayList<>();

    // Constructor
    public ContactService() {
    }

    // Method to add a new contact with default values
    public void addContact() {
        Contact contact = new Contact(generateUniqueId());
        contactList.add(contact);
    }

    // Method to add a new contact with the provided first name
    public void addContact(String firstName) {
        Contact contact = new Contact(generateUniqueId(), firstName);
        contactList.add(contact);
    }

    // Method to add a new contact with the provided first and last names
    public void addContact(String firstName, String lastName) {
        Contact contact = new Contact(generateUniqueId(), firstName, lastName);
        contactList.add(contact);
    }

    // Method to add a new contact with the provided first name, last name, and phone number
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(generateUniqueId(), firstName, lastName, phoneNumber);
        contactList.add(contact);
    }

    // Method to add a new contact with the provided first name, last name, phone number, and address
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = new Contact(generateUniqueId(), firstName, lastName, phoneNumber, address);
        contactList.add(contact);
    }

    // Method to delete a contact by its ID
    public void deleteContact(String id) throws Exception {
        Contact contact = findContactById(id);
        contactList.remove(contact);
    }

    // Method to update the first name of a contact by its ID
    public void updateFirstName(String id, String firstName) throws Exception {
        Contact contact = findContactById(id);
        contact.updateFirstName(firstName);
    }

    // Method to update the last name of a contact by its ID
    public void updateLastName(String id, String lastName) throws Exception {
        Contact contact = findContactById(id);
        contact.updateLastName(lastName);
    }

    // Method to update the phone number of a contact by its ID
    public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
        Contact contact = findContactById(id);
        contact.updatePhoneNumber(phoneNumber);
    }

    // Method to update the address of a contact by its ID
    public void updateAddress(String id, String address) throws Exception {
        Contact contact = findContactById(id);
        contact.updateAddress(address);
    }

    // Method to get the list of contacts
    protected List<Contact> getContactList() {
        return contactList;
    }

    // Helper method to generate a unique ID for contacts
    private String generateUniqueId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    // Helper method to find a contact by its ID
    private Contact findContactById(String id) throws Exception {
        for (Contact contact : contactList) {
            if (id.equals(contact.getContactId())) {
                return contact;
            }
        }
        throw new Exception("The contact does not exist!");
    }
}