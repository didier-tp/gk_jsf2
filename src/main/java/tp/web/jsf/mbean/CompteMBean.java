package tp.web.jsf.mbean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tp.data.Compte;
import tp.service.IServiceCompte;

//cette classe java correspond � un composant 
//qui joue le r�le de "managedBean" JSF (#{compteMBean...}
//et qui est techniquement:
//   - d'abord instanci�/initialis� par spring (@Autowired , ...)
//   - ensuite r�utilis� par JSF
@Component() //id/name par defaut de ce composant spring : 
             // compteMBean (nom de classe avec minuscule au debut)
@Scope("session") //equivalent spring de @SessionScoped
public class CompteMBean {
	
	private Long numClient;//valeur diff�rente pour chaque utilisateur
	private String password;
	private List<Compte> comptes;
	
	@PostConstruct
	public void apresInitSpring(){
		System.out.println("initialise par spring");
	}
	
	//une instance instance d'un service partag�e suffit
	@Autowired
	private IServiceCompte serviceCompte ; /*= 
			       ServiceCompte.getInstance();*/
	
		
	public String login(){
		System.out.println("login() appel� sur " + this.toString());
		if(serviceCompte.verifAuth(numClient, password)){
			this.message = "nbComptes:" 
		      + serviceCompte.comptesDuClient(this.numClient).size();
			return "listeComptes";
		}
		else{ this.message="echec authentification. veuillez r�essayer";
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
