package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Contact;
import entity.User;
import service.ContactService;
import service.UserService;

@SessionScoped
@ManagedBean(name = "contactbean")
public class ContactBean {

	List<Contact> contacts = new ArrayList<>();
	ContactService cs = new ContactService();
	UserService us = new UserService();
	List<Contact> contactfilter;

	@PostConstruct
	private void onLoad() {
		contacts = us.getUserById(((User) UserBean.getSession().getAttribute("user")).getIduser()).getContacts();
		// System.out.println(contacts);
	}

	public void addContact() {
		Contact newcontact = new Contact(contact.getNom(), contact.getPrenom(), contact.getNumero(),
				(User) UserBean.getSession().getAttribute("user"));
		cs.addContact(newcontact);
		this.contacts = us.getUserById(((User) UserBean.getSession().getAttribute("user")).getIduser()).getContacts();
		this.contact = new Contact();
	}

	public void deleteContact(Contact contact) {
		cs.deleteContact(contact);
		this.contacts = us.getUserById(((User) UserBean.getSession().getAttribute("user")).getIduser()).getContacts();
		this.contact = new Contact();
	}

	public void updateContact(Contact contact) {
		cs.update(contact);
		this.contacts = us.getUserById(((User) UserBean.getSession().getAttribute("user")).getIduser()).getContacts();
		this.contact = new Contact();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	Contact contact = new Contact();

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContactfilter() {
		return contactfilter;
	}

	public void setContactfilter(List<Contact> contactfilter) {
		this.contactfilter = contactfilter;
	}
}
