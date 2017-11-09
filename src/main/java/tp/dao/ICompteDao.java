package tp.dao;

import java.util.List;

import tp.data.Client;
import tp.data.Compte;

//interface de DAO avec méthodes CRUD
public interface ICompteDao {
	public Compte findCompte(Long num);
	public List<Compte> rechercherComptesDuClient(Long numClient);
	public void updateCompte(Compte c);
	public Compte insertCompte(Compte c); //retourne c avec numero auto_incr
	public Client insertClient(Client c); //retourne c avec numero auto_incr
	public void removeCompte(Long num);
	//...
}
