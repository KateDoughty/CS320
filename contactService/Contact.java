package contactService;

/*
 * Author: Kate Doughty
 */

public class Contact {

	private static int contactPhonenumLength = 10;
	private static byte contactIdLength = 10;
	private static byte contactFNameLength = 10;
	private static byte contactLNameLength = 10;
	private static byte contactAddressLength = 30;
	private static String initializer = "Initial";
	private static String initializerNum = "0000000000";
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	Contact(){
		this.contactId = initializer;
		this.firstName = initializer;
		this.lastName = initializer;
		this.phoneNumber = initializerNum;
		this.address = initializer;
	}
	
	Contact(String contactId) {
		updateContactId(contactId);
		this.firstName = initializer;
		this.lastName = initializer;
		this.phoneNumber = initializerNum;
		this.address = initializer;
	}
	
	Contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = initializer;
	    this.phoneNumber = initializerNum;
	    this.address = initializer;
	}

	Contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNumber = initializerNum;
	    this.address = initializer;
	}

	Contact(String contactId, String firstName, String lastName,
	        String phoneNumber) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    this.address = initializer;
	}

	Contact(String contactId, String firstName, String lastName,
	        String phoneNumber, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    updateAddress(address);
	}
	
	protected String getContactId() { return contactId; }
	
	protected final String getFirstName() { return firstName; }

	protected final String getLastName() { return lastName; }

	protected final String getPhoneNumber() { return phoneNumber; }

	protected final String getAddress() { return address; }
	
	protected void updateFirstName (String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First Name cannot be longer than " + contactFNameLength + "characters.");
		} else {
			this.firstName = firstName;
		}
	}
	
	protected void updateLastName(String lastName) {
	    if (lastName == null) {
	    	throw new IllegalArgumentException("Last name cannot be empty.");
	    } else if (lastName.length() > contactLNameLength) {
	    	throw new IllegalArgumentException("Last name cannot be longer than " + contactLNameLength + " characters.");
	    } else {
	    	this.lastName = lastName;
	    }
	  }
	
	protected void updatePhoneNumber(String phoneNumber) {
	    String regex = "[0-9]+";
	    if (phoneNumber == null) {
	    	throw new IllegalArgumentException("Phone number cannot be empty.");
	    } else if (phoneNumber.length() != contactPhonenumLength) {
	    	throw new IllegalArgumentException(
	          "Phone number length invalid. Ensure it is " + contactPhonenumLength + " digits.");
	    } else if (!phoneNumber.matches(regex)) {
	    	throw new IllegalArgumentException("Phone number cannot have anything but numbers.");
	    } else {
	    	this.phoneNumber = phoneNumber;
	    }
	  }

	  protected void updateAddress(String address) {
		  if (address == null) {
			  throw new IllegalArgumentException("Address cannot be empty.");
		  } else if (address.length() > contactAddressLength) {
			  throw new IllegalArgumentException("Address cannot be longer than " + contactAddressLength + " characters.");
		  } else {
			  this.address = address;
		  }
	  	}

	  protected void updateContactId(String contactId) {
		  if (contactId == null) {
			  throw new IllegalArgumentException("Contact ID cannot be empty.");
		  } else if (contactId.length() > contactIdLength) {
			  throw new IllegalArgumentException("Contact ID cannot be longer than " + contactIdLength + " characters.");
		  } else {
			  this.contactId = contactId;
		  }
	  	}
}
