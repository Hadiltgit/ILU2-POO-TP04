package produit;



public abstract class Produit implements IProduit {
	   private String nom;
	   private Unit unit;
	   
	   public Produit (String nom,Unit unit) {
		   this.nom = nom;
		   this.unit = unit;
	   }
	   
	   @Override
	public String getNom() {
		   return nom;
	   }
	   
	   @Override
	public Unit getUnit() {
	        return unit;
	    }
	   
	   @Override
	public  abstract String decrireProduit();
	  
}
