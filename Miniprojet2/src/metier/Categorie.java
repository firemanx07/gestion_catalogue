package metier;

public class Categorie {
		
	private int code;

	private static int nb ;
	private String nom_cat;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom_cat() {
		return nom_cat;
	}
	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}
	public Categorie() {
		this.code=nb++;
		// TODO Auto-generated constructor stub
	}
	public Categorie(int code, String nom_cat) {
		super();
		this.code = code;
		this.nom_cat = nom_cat;
	}
	public Categorie( String nom_cat) {
		super();
		
		this.nom_cat = nom_cat;
	}

}
