package tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.data.Compte;
import tp.data.Virement;
import tp.service.IServiceCompte;

//test JUnit +Spring
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/jpaSpringConf.xml")
public class VerifierServiceCompte {
	
	@Autowired
	private IServiceCompte serviceCompte;
	
	
	@Test
	public void testComptesDuClient(){
		List<Compte> comptes = serviceCompte.comptesDuClient(1L);
		Assert.assertTrue(comptes != null);
		System.out.println("Comptes du client 1:");
		for(Compte c : comptes){
			System.out.println("\t" + c.toString());
		}
	}
	
	@Test
	public void testVirement(){
		List<Compte> comptesAvant = serviceCompte.comptesDuClient(1L);
		System.out.println("Comptes du client 1 (avant virement):");
		for(Compte c : comptesAvant){
			System.out.println("\t" + c.toString());
		}
		serviceCompte.effectuerVirement(new Virement(50.0,1L,2L));
		List<Compte> comptesApres = serviceCompte.comptesDuClient(1L);
		System.out.println("Comptes du client 1 (apres virement):");
		for(Compte c : comptesApres){
			System.out.println("\t" + c.toString());
		}
	}

}
