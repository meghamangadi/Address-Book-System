package com.blz.addressbooksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMainClass { 
	public static AddressBook addressBook=new AddressBook();
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		addContactDetails();
	}
	
	
	public static void addContactDetails() {
		

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1 : Add new contact    2 : Edit contact   3 : Delete Contact");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1 :
			System.out.println("Enter the First Name");
			String firstName = sc.next();
			System.out.println("Enter the Last Name");
			String lastName = sc.next();
			System.out.println("Enter The Address");
			String address = sc.next();
			System.out.println("Enter the city");
			String city = sc.next();
			System.out.println("Enter the state");
			String state = sc.next();
			System.out.println("Enter the zip Code");
			int zip = sc.nextInt();
			System.out.println("Enter the Phone number");
			long phone = sc.nextLong();
			List<Contact> contactList=new ArrayList<>();
			Contact contact= new Contact( firstName,   lastName,   address,   city,   state,   zip,   phone);
			contactList.add(contact); 
			addressBook.setContacts(contactList);
			displayContacts(addressBook);
			addContactDetails();
			break;
		case 2:	

			System.out.println("Enter the person Name");
			String name = sc.next();
			System.out.println("Enter the Last Name");
			String editLastName = sc.next();
			System.out.println("Enter The Address");
			String editAddress = sc.next();
			System.out.println("Enter the city");
			String editCity = sc.next();
			System.out.println("Enter the state");
			String editState = sc.next();
			System.out.println("Enter the zip Code");
			int editzip = sc.nextInt();
			System.out.println("Enter the Phone number");
			long editPhone = sc.nextLong();
			editContact(name,editLastName,editAddress,editCity,editState,editzip,editPhone);
			addContactDetails();
			break;
		case 3:	
			System.out.println("Enter the person Name");
			String deletename = sc.next();
			deleteContactDetails(deletename);
			addContactDetails();
			break;
			default :
				System.out.println("Please Enter correct choice");
				break;
		
		}
		
		
		
		sc.close();

	
	}
	 
	public static void deleteContactDetails(String name) {
		 List<Contact> contactDetails=addressBook.getContacts();
		for (int i =0;i <=contactDetails.size()-1;i++) {
			 
			int value = 0;
			Contact contactperson=contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {
				contactperson.setAddress("");
				contactperson.setCity("");
				contactperson.setFirstName("");
				contactperson.setLastName("");
				contactperson.setPhone(value);
				contactperson.setState("");
				contactperson.setZip(value);
				contactDetails.set(i, contactperson);
				addressBook.setContacts(contactDetails);
			}
		}
		System.out.println("Contact deleted Successfully");
		displayContacts(addressBook);
	}
	public static void editContact(String name,String lastname,String address,String city,String state,int zip,long phone) {
		 List<Contact> contactDetails=addressBook.getContacts();
		for (int i =0;i <=contactDetails.size()-1;i++) {
			
			Contact contactperson=contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {
				
				contactperson.setAddress(address);
				contactperson.setCity(city);
				contactperson.setFirstName(name);
				contactperson.setLastName(lastname);
				contactperson.setPhone(phone);
				contactperson.setState(state);
				contactperson.setZip(zip);
				contactDetails.set(i, contactperson);
				addressBook.setContacts(contactDetails);
			}
		}
		displayContacts(addressBook);
	}
	 public static void displayContacts(AddressBook addressBook){
		 List<Contact> contactDetails=addressBook.getContacts();
		 
		 for (int i =0;i <=contactDetails.size()-1;i++) {
			 Contact contactperson=contactDetails.get(i);
			 if(!contactperson.getFirstName().equals("")) {
			 System.out.println("Conatct Details :"); 
			 System.out.println("FirstName :"+contactperson.getFirstName()+"      LastName :"+contactperson.getLastName()
			 		+ "     Address :"+contactperson.getAddress()+"      City :"+contactperson.getCity()+
			 		"       State :"+contactperson.getState()+"     Zip :"+contactperson.getZip()+"     Phone Number :"+contactperson.getPhone()); 
			 }else {
				 
				 System.out.println("No Conatct Details available :");
			 }
		 }
		 
	 }

}
