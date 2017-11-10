package tp.web.jsf.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	private List<String> toutesLesVilles ;
	
	public InscriptionMBean(){
		toutesLesVilles = new ArrayList<String>();
		toutesLesVilles.add("Paris"); toutesLesVilles.add("Perpignan");
		toutesLesVilles.add("Lyon"); toutesLesVilles.add("Laon");
		toutesLesVilles.add("Besançon"); toutesLesVilles.add("Beauvais");
		toutesLesVilles.add("Toulouse"); toutesLesVilles.add("T...");
	}
	//ville: <p:autoComplete completeMethod="#{inscriptionMBean.suggererVilles}"
	//                       value="#{inscriptionMBean.adresse.ville}" />
	public List<String> suggererVilles(String debutNomDeVille){
		List<String> suggestions = new ArrayList<String>();
		
		String debutVilleAvecMaj = debutNomDeVille.substring(0, 1).toUpperCase();
		if(debutNomDeVille.length()>1) 
			debutVilleAvecMaj+=debutNomDeVille.substring(1);
		
		for(String v : toutesLesVilles){
		    if(v.startsWith(debutVilleAvecMaj))
		     suggestions.add(v);
		   } 
		return suggestions;
	}
	
	
	public String inscrire(){
		message = "inscription prise en compte pour nom="
				+nom + " date=" + date + " adresse="+ adresse.toString();
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
