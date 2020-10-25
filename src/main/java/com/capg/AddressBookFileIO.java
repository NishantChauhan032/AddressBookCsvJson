package com.capg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIO {

	private static  String ADDRESSBOOK_FILE="myAddressBook.txt";
	public void writeContact(List<Contact> contacts)
	{
		StringBuffer contactBuffer=new StringBuffer();
		contacts.forEach(contact->contactBuffer.append(contact.toString().getBytes()));
		try
		{
			Files.write(Paths.get(ADDRESSBOOK_FILE),contactBuffer.toString().getBytes());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	} 
	public List<Contact> readContactFile() {
		final List<Contact> listOfContacts = new ArrayList<>();
		try {
				Files.lines(Paths.get("addressBookFile.txt"))
						.forEach(lines -> {
							String[] contactArray=lines.split(",");
								String firstName = contactArray[0];
								String lastName = contactArray[1];
								String address = contactArray[2];
								String city = contactArray[3];
								String state = contactArray[4];	
								int zip = Integer.parseInt(contactArray[5]);
								long phone = Long.parseLong(contactArray[6]);
								String email = contactArray[7];
								Contact contactObject = new Contact(firstName, lastName,address,city,state,zip, phone,email);
								listOfContacts.add(contactObject);
						});
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return listOfContacts;
	}
}

