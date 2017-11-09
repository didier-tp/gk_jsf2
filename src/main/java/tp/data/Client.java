package tp.data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	private String nom;
	
	@OneToMany(mappedBy="client")
	private List<Compte> comptes; //+get/set

	
	
	public List<Compte> getComptes() {
		return comptes;
	}



	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}



	public Client() {
		super();
	}
	
	



	public Client(Long numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
	}



	public Long getNumero() {
		return numero;
	}



	public void setNumero(Long numero) {
		this.numero = numero;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
	

}
