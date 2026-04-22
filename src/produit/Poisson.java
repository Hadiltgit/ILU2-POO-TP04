package produit;

public class Poisson extends Produit {
	
	private String date;
	
    public Poisson(String date) {
    	super("poisson", Unit.piece);
		this.date = date;
	}

  
  
  

   @Override
   public String decrireProduit() {
	   return "poisson pêché " + date + ".";
   }
}
