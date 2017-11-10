package tp.web.jsf.mbean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import tp.data.Adresse;

@ManagedBean //JSF sans spring
@RequestScoped // ou bien @SessionScoped
public class InscriptionMBean {

	//(new pour eviter nullPointerException)
	private Adresse adresse = new Adresse(); //à saisir 
	private String nom;
	private Date date;
	
	private String message; //à afficher
	
	public String inscrire(){
		message = "inscription prise en compte pour nom="
				+nom + " date=" + date + " adresse="+ adresse;
		return null; //pour affichage message sur meme page
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
