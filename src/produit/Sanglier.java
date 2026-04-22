package produit;
import personnages.Gaulois;
public class Sanglier extends Produit{
   
	 private int poids;
	 private Gaulois chasseur;
	 
	 public Sanglier(int poids, Gaulois chasseur) {
	        super("sanglier", Unit.kg);
	        this.poids = poids;
	        this.chasseur = chasseur;
	    }

	    @Override
	    public String decrireProduit() {
	        return "sanglier de " + poids + " kg chassé par " + chasseur.getNom() + ".";
	    }
}
