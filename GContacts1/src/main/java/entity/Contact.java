package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcontact;
	private String nom;
	private String prenom;
	private String numero;

	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user;

	public Contact() {

	}

	public Contact(String nom, String prenom, String numero) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
	}

	public Contact(String nom, String prenom, String numero, User user) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.user = user;
	}

	public int getIdcontact() {
		return idcontact;
	}

	public void setIdcontact(int idcontact) {
		this.idcontact = idcontact;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User newUser) {
		if (this.user == null || !this.user.equals(newUser)) {
			if (this.user != null) {
				User oldUser = this.user;
				this.user = null;
				oldUser.removeContacts(this);
			}
			if (newUser != null) {
				this.user = newUser;
				this.user.addContacts(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Contact [idcontact=" + idcontact + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero
				+ ", user=" + user.getIduser() + "]";
	}
	
}
