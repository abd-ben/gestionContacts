package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iduser;
	private String nom;
	private String prenom;
	private String email;
	private String login;
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "iduser")
	private List<Contact> contacts;

	public User() {

	}

	public User(String nom, String prenom, String email, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contact> getContacts() {
		if (contacts == null)
			contacts = new java.util.ArrayList<Contact>();
		return contacts;
	}

	public java.util.Iterator getIteratorContacts() {
		if (contacts == null)
			contacts = new java.util.ArrayList<Contact>();
		return contacts.iterator();
	}

	public void setContacts(java.util.List<Contact> newContact) {
		removeAllContacts();
		for (java.util.Iterator iter = newContact.iterator(); iter.hasNext();)
			addContacts((Contact) iter.next());
	}

	public void addContacts(Contact newContact) {
		if (newContact == null)
			return;
		if (this.contacts == null)
			this.contacts = new java.util.ArrayList<Contact>();
		if (!this.contacts.contains(newContact)) {
			this.contacts.add(newContact);
			newContact.setUser(this);
		}
	}

	public void removeContacts(Contact oldContact) {
		if (oldContact == null)
			return;
		if (this.contacts != null)
			if (this.contacts.contains(oldContact)) {
				this.contacts.remove(oldContact);
				oldContact.setUser((User) null);
			}
	}

	public void removeAllContacts() {
		if (contacts != null) {
			Contact oldContact;
			for (java.util.Iterator iter = getIteratorContacts(); iter.hasNext();) {
				oldContact = (Contact) iter.next();
				iter.remove();
				oldContact.setUser((User) null);
			}
		}
	}
}
