package tp.data;

import java.util.Date;
//@Entity
public class Operation {
	private Long id;
	private Long numeroCompte;
	private Date dateOp;
	private String label;
	private Double montant; //positif ou négatif si achat
	
	
	public Operation() {
		super();
	}

	public Operation(Long id, Long numeroCompte, Date dateOp, String label, Double montant) {
		super();
		this.id = id;
		this.numeroCompte = numeroCompte;
		this.dateOp = dateOp;
		this.label = label;
		this.montant = montant;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateOp() {
		return dateOp;
	}
	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	
}
