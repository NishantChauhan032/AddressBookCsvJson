package com.capg;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AddressBookManagement 
{
	static Scanner sc=new Scanner(System.in);
	
	public static Map<String, Contact> cityAndContactMap = new TreeMap<>();
	public static Map<String, Contact> stateAndContactMap = new TreeMap<>();
	public static Map<String,AddressBookMain> addressMap=new TreeMap<>();
	
	
	public static void addNewAddressBook()
	{
		AddressBookMain addressBookMainObject=new AddressBookMain();
		System.out.println("Enter a unique name");
		String name=sc.next();
		addressBookMainObject.maintainAddressBook();
		addressMap.put(name,addressBookMainObject);
	}
	public static void showContactGroupedByState() {
		Set<String> stateList = stateAndContactMap.keySet();
		for(String state : stateList) {
			System.out.println("Contact Entries for STATE: " + state);
			searchPersonInAddressBook(state);
		}
	}
	public static void showContactGroupedByCity() {
		Set<String> cityList = cityAndContactMap.keySet();
		for(String city : cityList) {
			System.out.println("Contact Entries for CITY: " + city);
			searchPersonInAddressBook(city);
		}
	}
	public static void searchPersonInAddressBook(String searchIn)
	{
		Predicate<Contact> search = n -> n.getFirstName().equals(searchIn) ? true : false;
		Consumer<Contact> display = n -> System.out.println(n);
		addressMap.forEach((k, v) -> {
			v.getcontactArray().stream().filter(search).forEach(display);
		});
	}
	public static void countContactsByCity() {
		Set<String> cityList = cityAndContactMap.keySet();
		for(String cityName : cityList) {
			Contact contactNumber = cityAndContactMap.get(cityName);
			System.out.println("No of contact entries for the city  " + cityName + " " + ((Map<String, AddressBookMain>) contactNumber).size());
		}
	}

	public static void countContactsByState() {
		Set<String> stateList = stateAndContactMap.keySet();
		for(String stateName : stateList) {
			Contact contactNumber = stateAndContactMap.get(stateName);
			System.out.println("No of contact entries for STATE " + stateName + " " + ((Map<String, AddressBookMain>) contactNumber).size());
		}
	}
	public static void main(String args[])
	{
		AddressBookManagement addressBookManager=new AddressBookManagement();
		while(true)
		{
			System.out.println("\n1. Add a new Address Book");
			System.out.println("\n2. Search person across all address books");
			System.out.println("\n3. Show contact  by city");
			System.out.println("\n4. Show contacts by state");
			System.out.println("\n5. count contacts  by city");
			System.out.println("\n6. count contacts by state");
			System.out.println("\n7. Exit");
			System.out.println("\n Please Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
			while (true) {
				AddressBookMain m = new AddressBookMain();
				System.out.println("Enter A name for your address Book");
				String name = sc.next();
				if (addressBookManager.addressMap.containsKey(name)) {
					System.out.println("\nSorry..Address Book already exists !!!\n");
					continue;
				} else {
					addressBookManager.addressMap.put(name, m);
					System.out.println("\n Now you are in Address Book : " + name);
					m.maintainAddressBook();
					break;
				}
			}
			break;

		case 2:
			System.out.println("Enter city or state to search a person");
			String search = sc.next();
			addressBookManager.searchPersonInAddressBook(search);
			break;
		case 3:showContactGroupedByCity();
			break;
		case 4:showContactGroupedByState();
			break;
		case 5:countContactsByCity();
			break;
		case 6:countContactsByState();
			break;
		case 7:
			System.exit(0);
			break;
			}
	}
}
}