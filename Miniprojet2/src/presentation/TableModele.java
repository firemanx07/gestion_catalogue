package presentation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Categorie;

public class TableModele extends AbstractTableModel {
	String colonnes[] = { "Code", "Categorie",};
	List<Categorie> liste = new ArrayList<>();

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
			return liste.get(l).getCode();
		case 1:
			return liste.get(l).getNom_cat();
		

		}
		return null;
	}

	@Override
	public String getColumnName(int column) {

		return colonnes[column];
	}

	public void charger(List<Categorie> l) {
		liste = l;
		fireTableDataChanged();
	}
}
