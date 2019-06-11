package dao;

import java.util.List;

import metier.*;



public interface IDaoCatalogue {
		public void addCategorie(Categorie e);
		public void addProduit(Produit e);
		public List<Categorie> getAllECategorie();
		public List<Produit> getAllProduit();
	public List<Produit> getAllProduitParC(int code);
	
	
	

}
