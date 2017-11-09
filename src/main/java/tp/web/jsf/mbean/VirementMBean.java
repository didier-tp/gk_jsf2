package tp.web.jsf.mbean;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tp.data.Virement;
import tp.service.IServiceCompte;

@Component
@Scope("request")
public class VirementMBean {
	private Virement ordreVirement=new Virement();//� saisir dans virement.xhtml
	   //avec get/set  #{virementMBean.ordreVirement.montant}
	
	@Autowired
	private IServiceCompte serviceCompte;//acces au service m�tier spring
	private CompteMBean compteMBean=null ;//acces au MBean d'� cot� (pour d�l�guer)
	
	public String doVirement(){
		String suite=null;
		try {
			serviceCompte.effectuerVirement(this.ordreVirement);//virement en base
			//acc�der � un autre MBean de l'application JSF:
			this.compteMBean = (CompteMBean) FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get("compteMBean");
			
			suite=compteMBean.actualiserListeComptes();//nouvelle m�thode � coder
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suite;
	}

	public Virement getOrdreVirement() {
		return ordreVirement;
	}

	public void setOrdreVirement(Virement ordreVirement) {
		this.ordreVirement = ordreVirement;
	}
	
	

}
