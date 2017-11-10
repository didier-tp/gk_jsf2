package tp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import tp.dao.ICompteDao;
import tp.data.Client;
import tp.data.Compte;
import tp.data.Operation;
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


	@Override
	public List<Operation> dernieresOperations(Long numCompte) {
		// version simulée sans base de données:
		List<Operation> listeOp = new ArrayList<Operation>();
		int numCpt = (int)(long) numCompte;
		Date d=new Date();
		switch(numCpt){
		case 1:
			listeOp.add(new Operation(101L,1L,d,"achat xy 1",-23.20));
			listeOp.add(new Operation(102L,1L,d,"achat xy 2",-15.20));
			break;
		case 2:
			listeOp.add(new Operation(201L,2L,d,"achat zzz 2 ",-123.20));
			listeOp.add(new Operation(202L,2L,d,"achat zzz 2", -115.20));
			break;
		case 3:
			listeOp.add(new Operation(301L,3L,d,"achat aa 1",-223.20));
			listeOp.add(new Operation(302L,3L,d,"achat bb 2",-215.20));
			break;
		
		}
		return listeOp;
	}
	
	

}
