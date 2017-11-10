package tp.data;

public class Adresse {
	private String numeroEtRue;
	private String codePostal;
	private String ville;
	

	@Override
	public String toString() {
		return "Adresse [numeroEtRue=" + numeroEtRue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	//+get/set
	public String getNumeroEtRue() {
		return numeroEtRue;
	}
	public void setNumeroEtRue(String numeroEtRue) {
		this.numeroEtRue = numeroEtRue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
