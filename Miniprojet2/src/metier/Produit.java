package metier;

public class Produit implements Comparable<Produit> {
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	private static int nb;
	private String nom_prod;
	private int prix_prod,qte_stock;
	private Categorie c;
	public Categorie getC() {
		return c;
	}
	public void setC(Categorie c) {
		this.c = c;
	}
	public String getNom() {
		return nom_prod;
	}
	public void setNom(String nom) {
		this.nom_prod = nom;
	}
	public int getPrix_prod() {
		return prix_prod;
	}
	public void setPrenom(int prix_prod) {
		this.prix_prod = prix_prod;
	}
	public int getQte_stock() {
		return qte_stock;
	}
	public void setQte_stock(int qte_stock) {
		this.qte_stock = qte_stock;
	}
	
	public int getId() {
		return id;
	}
	public Produit() {
		id=++nb;
	}
	public Produit(String nom, int prenom, int sexe, Categorie code) {
		super();
		id=++nb;
		this.nom_prod = nom;
		this.prix_prod = prenom;
		this.qte_stock = sexe;
		this.setC(code);
	}
	public Produit(int id,String nom, int prix_prod, int qte_stock, Categorie code) {
		super();
		this.id=id;
		this.nom_prod = nom;
		this.prix_prod = prix_prod;
		this.qte_stock = qte_stock;
		this.setC(code);
	}
	@Override
	public int compareTo(Produit arg0) {
		// TODO Auto-generated method stub
		return nom_prod.compareTo(arg0.getNom());
	}
	/**
	 * @return the code
	 */

	/**
	 * @param code the code to set
	 */
	
	
	

}
