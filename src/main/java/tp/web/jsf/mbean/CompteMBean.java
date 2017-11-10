package tp.web.jsf.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tp.data.Compte;
import tp.service.IServiceCompte;

//cette classe java correspond à un composant 
//qui joue le rôle de "managedBean" JSF (#{compteMBean...}
//et qui est techniquement:
//   - d'abord instancié/initialisé par spring (@Autowired , ...)
//   - ensuite réutilisé par JSF
@Component() //id/name par defaut de ce composant spring : 
             // compteMBean (nom de classe avec minuscule au debut)
@Scope("session") //equivalent spring de @SessionScoped
public class CompteMBean {
	
	private Long numClient;//valeur différente pour chaque utilisateur
	private String password;
	private List<Compte> comptes;
	
	@PostConstruct
	public void apresInitSpring(){
		System.out.println("initialise par spring");
	}
	
	//une instance instance d'un service partagée suffit
	@Autowired
	private IServiceCompte serviceCompte ; /*= 
			       ServiceCompte.getInstance();*/
	
		
	public String login(){
		System.out.println("login() appelé sur " + this.toString());
		if(serviceCompte.verifAuth(numClient, password)){
			this.message = "authentification ok"; 
		    this.comptes = serviceCompte.comptesDuClient(this.numClient);
		    if(this.comptes.size()>0)
			    return "listeComptes";//pour naviguer vers listeComptes.xhtml
		    else {
		    	FacesContext.getCurrentInstance()
		    	    .addMessage( null /* id = null pour message global */,
		    		     new FacesMessage("aucun compte pour ce client" , "...details..."));
		    	return null;//pour ne pas changer de page
		    }
		}
		else{ this.message="echec authentification. veuillez réessayer";
			return null; 
		}
	}
	
	public String actualiserListeComptes() {
		try {
			this.comptes = serviceCompte.comptesDuClient(this.numClient);
			return "listeComptes";//pour naviguer vers listeComptes.xhtml
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//+get/set
	
	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
    private String message=null;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	
	
	

}
