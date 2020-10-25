package com.capg;

import org.junit.Assert;
import org.junit.Test;

	public class AddressBookTest 
	{
	    @Test
	    public void given3Contact_WhenWrittenTo_CSVFileShouldPass() 
	    {
			AddressBookCSV addressBookCSVobject=new AddressBookCSV("./resources/AddressBookCSVTester.csv");
			int readCSVContacts=addressBookCSVobject.readAddressBookFromCSVFile();
			Assert.assertEquals(3,readCSVContacts);
		}
	}