package produit;

public interface IProduit {

	String getNom();

	Unit getUnit();

	String decrireProduit();

	int calculerPrix(int prix);

}