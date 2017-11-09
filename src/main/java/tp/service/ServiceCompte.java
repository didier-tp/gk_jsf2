package tp.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import tp.dao.ICompteDao;
import tp.data.Client;
import tp.data.Compte;
import tp.data.Virement;
//Simulation d'un service métier (avec spring, sans database)
@Service
@Scope("singleton")
@Transactional
public class ServiceCompte implements IServiceCompte {
	
	@Autowired
	private ICompteDao compteDao;
	
	public boolean verifAuth(Long numClient , String password){
		boolean res=false;
		if(password.equals("pwd"+numClient)){
			res=true; //ok pour numClient=1 et password=pwd1
		}
		return res;
	}
	
		
	public ServiceCompte(){
		//compteDao encore à null dans constructeur et donc inutilisable.
	}
	
	@PostConstruct
	public void initJeuxDeDonneesEnModeDeveloppement(){
		if(compteDao.findCompte(1L)==null){
			Client cli1 = compteDao.insertClient(new Client(null,"client1"));
			Client cli2 = compteDao.insertClient(new Client(null,"client2"));
			for(int i=1;i<=3;i++){
				Compte c = new Compte(null,"compte "+i+" en base" , 100.0 * i);
				c.setClient(cli1);
				compteDao.insertCompte(c);
			}
			for(int i=4;i<=5;i++){
				Compte c = new Compte(null,"compte "+i+" en base" , 100.0 * i);
				c.setClient(cli2);
				compteDao.insertCompte(c);
			}
		}
	}
	
	public void effectuerVirement(Virement ordreVirement){
		Compte cptDeb = compteDao.findCompte(ordreVirement.getNumCptDeb());
		Compte cptCred= compteDao.findCompte(ordreVirement.getNumCptCred());
		cptDeb.setSolde(cptDeb.getSolde() - ordreVirement.getMontant());
		cptCred.setSolde(cptCred.getSolde() + ordreVirement.getMontant());
		//compteDao.updateCompte(cptDeb); compteDao.updateCompte(cptCred);
		//non obligatoires si @Transactional et cptDeb , cptCred à l'état persistant
	}
	
	public List<Compte> comptesDuClient(Long numClient){
		return compteDao.rechercherComptesDuClient(numClient);
	}
	
	

}
