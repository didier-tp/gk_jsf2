package tp.service;

import java.util.List;

import tp.data.Compte;
import tp.data.Virement;

public interface IServiceCompte {
	public boolean verifAuth(Long numClient , String password);
	public void effectuerVirement(Virement ordreVirement);
	public List<Compte> comptesDuClient(Long numClient);
}