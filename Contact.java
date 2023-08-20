public class Contact {

    private static final int CONTACT_PHONENUM_LENGTH = 10;
    private static final byte CONTACT_ID_LENGTH = 10;
    private static final byte CONTACT_FNAME_LENGTH = 10;
    private static final byte CONTACT_LNAME_LENGTH = 10;
    private static final byte CONTACT_ADDRESS_LENGTH = 30;
    private static final String INITIALIZER = "INITIAL";
    private static final String INITIALIZER_NUM = "1235551234";

    // Instance variables to hold contact information
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Constructors
    public Contact() {
        this.contactId = INITIALIZER;
        this.firstName = INITIALIZER;
        this.lastName = INITIALIZER;
        this.phoneNumber = INITIALIZER_NUM;
        this.address = INITIALIZER;
    }

    public Contact(String contactId) {
        this();
        updateContactId(contactId);
    }

    public Contact(String contactId, String firstName) {
        this(contactId);
        updateFirstName(firstName);
    }

    public Contact(String contactId, String firstName, String lastName) {
        this(contactId, firstName);
        updateLastName(lastName);
    }

    public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
        this(contactId, firstName, lastName);
        updatePhoneNumber(phoneNumber);
    }

    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        this(contactId, firstName, lastName, phoneNumber);
        updateAddress(address);
    }

    // Getter methods for contact information
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // Update methods for contact information
    public void updateFirstName(String firstName) {
        validateNotNull(firstName, "First name");
        validateLength(firstName, CONTACT_FNAME_LENGTH, "First name");
        this.firstName = firstName;
    }

    public void updateLastName(String lastName) {
        validateNotNull(lastName, "Last name");
        validateLength(lastName, CONTACT_LNAME_LENGTH, "Last name");
        this.lastName = lastName;
    }

    public void updatePhoneNumber(String phoneNumber) {
        validateNotNull(phoneNumber, "Phone number");
        validateLength(phoneNumber, CONTACT_PHONENUM_LENGTH, "Phone number");
        validatePhoneNumberFormat(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public void updateAddress(String address) {
        validateNotNull(address, "Address");
        validateLength(address, CONTACT_ADDRESS_LENGTH, "Address");
        this.address = address;
    }

    public void updateContactId(String contactId) {
        validateNotNull(contactId, "Contact ID");
        validateLength(contactId, CONTACT_ID_LENGTH, "Contact ID");
        this.contactId = contactId;
    }

    // Helper method to validate if a value is not null
    private void validateNotNull(String value, String field) {
        if (value == null) {
            throw new IllegalArgumentException(field + " can't be empty");
        }
    }

    // Helper method to validate if a value's length is within the allowed limit
    private void validateLength(String value, int maxLength, String field) {
        if (value.length() > maxLength) {
            throw new IllegalArgumentException(field + " can't be longer than " + maxLength + " characters");
        }
    }

    // Helper method to validate phone number format (digits only)
    private void validatePhoneNumberFormat(String phoneNumber) {
        String regex = "[0-9]+";
        if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("Phone number can't have anything but numbers");
        }
    }
}