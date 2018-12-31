package service;

import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import entity.Contact;

public class ContactService extends Dao<Contact> {
	public boolean  addContact(Contact contact) {
		return this.add(contact);
	}
	public boolean updateContact(Contact contact) {
		return this.update(contact);
	}
	public boolean deleteContact(Contact contact) {
		return this.delete(contact.getIdcontact(), Contact.class);
	}
	 
	public ArrayList<Contact> getAllContact() {
		return this.getAll("Contact"); 
	}
	public Contact getContactById(int idContact) {
		return this.getById(idContact, Contact.class);
	} 
	
	public int countAllContact() {
		return this.getCount("Contact");
	}
}
