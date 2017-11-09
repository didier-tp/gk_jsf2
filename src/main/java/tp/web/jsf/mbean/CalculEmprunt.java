package tp.web.jsf.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CalculEmprunt {
	
	private Double montant;
	private Integer nbAnnees;
	private Double tauxAnnuel ;
	private Double mensualite; 
	
	public String calculerMensualite(){
		String pageSuivante = null;
		try {
			double tauxMensuel = (tauxAnnuel / 100) / 12 ;
			int nbMois = nbAnnees * 12 ;
			this.mensualite = montant * tauxMensuel / 
					         ( 1 - Math.pow ( 1 + tauxMensuel , -nbMois) ) ;
			pageSuivante="resCalculMensualite"; //".jsp" ou ".xhtml"
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageSuivante;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Integer getNbAnnees() {
		return nbAnnees;
	}

	public void setNbAnnees(Integer nbAnnees) {
		this.nbAnnees = nbAnnees;
	}

	public Double getTauxAnnuel() {
		return tauxAnnuel;
	}

	public void setTauxAnnuel(Double tauxAnnuel) {
		this.tauxAnnuel = tauxAnnuel;
	}

	public Double getMensualite() {
		return mensualite;
	}

	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}
	
	

}
