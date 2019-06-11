package presentation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import metier.Categorie;
import metier.Produit;

public class TableModele3 extends AbstractTableModel {
	String colonnes[] = { "ID", "Produit","Prix unité","Quantité Stock","Categorie"};
	List<Produit> liste = new ArrayList<>();
	List<Categorie> l=new ArrayList<>();

	@Override
	public int getColumnCount() {

		return colonnes.length;
	}

	@Override
	public int getRowCount() {

		return liste.size();
	}


	@Override
	public Object getValueAt(int l, int c) {

		switch (c) {
		case 0:
			return liste.get(l).getId();
		case 1:
			return liste.get(l).getNom();
		case 2:
			return liste.get(l).getPrix_prod();
		case 3:
			return liste.get(l).getQte_stock();
		case 4:
			return liste.get(l).getC().getNom_cat();
			
	
		

		}
		return null;
	}

	@Override
	public String getColumnName(int column) {

		return colonnes[column];
	}

	public void charger(List<Produit> l) {
		//this.l=f;
		liste = l;
		fireTableDataChanged();
	}
}
