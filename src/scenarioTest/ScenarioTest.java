package scenarioTest;

import villagegaulois.Etal;
import villagegaulois.IEtal;
import personnages.*;
import produit.*;

public class ScenarioTest {

	public static void acheterProduit(IEtal[] marche, String produit, int quantiteSouhaitee) {
		int quantiteRestante = quantiteSouhaitee;
		for (int i = 0; i < marche.length && quantiteRestante != 0; i++) {
			IEtal etal = marche[i];
			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
			if (quantiteDisponible != 0) {
				int prix = etal.acheterProduit(quantiteDisponible);
				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
						+ " et je paye " + prix + " sous.");
				quantiteRestante -= quantiteDisponible;
			}
		}
		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
				+ (quantiteSouhaitee - quantiteRestante) + ".");
	}

	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String chaineProduit = produit;
		if (quantiteSouhaitee > 1) {
			chaineProduit = produit + "s";
		}
		return chaineProduit;
	}

	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(200, obelix);
		Sanglier sanglier2 = new Sanglier(150, obelix);
		Sanglier sanglier3 = new Sanglier(100, asterix);
		Sanglier sanglier4 = new Sanglier(50, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		
		Etal etalSanglier1 = new Etal<Sanglier>();
		Etal etalSanglier2 = new Etal<Sanglier>();
		
		Etal etalPoisson = new Etal<Poisson>();
		
		etalSanglier1.installerVendeur(obelix, sangliersObelix  , 8);
		etalSanglier2.installerVendeur(asterix, sangliersAsterix  , 10);
		
	    etalPoisson.installerVendeur(ordralfabetix, poissons  , 7);

	    

		IEtal[] marche = new IEtal[3];
		marche[0]= etalSanglier1;
		marche[1]= etalSanglier2;
		marche[2]= etalPoisson;

		System.out.println( etalSanglier1.etatEtal() );
		System.out.println( etalSanglier2.etatEtal() );
		System.out.println( etalPoisson.etatEtal() );
		
		acheterProduit(marche,"sanglier", 3);
		
		System.out.println( etalSanglier1.etatEtal() );
		System.out.println( etalSanglier2.etatEtal() );
		System.out.println( etalPoisson.etatEtal() );
	}

}

