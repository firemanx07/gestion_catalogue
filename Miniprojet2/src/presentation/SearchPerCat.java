package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import dao.DaoCatalogue;
import metier.Categorie;

public class SearchPerCat extends JFrame {
	DaoCatalogue action=new DaoCatalogue();

	JComboBox<String> cf = new JComboBox<>(action.AllCatname());
	JButton undo = new JButton("Quitter");
	
	JLabel lrechercher = new JLabel("Chercher par mot categorie:");
	//JTextField tRecherche = new JTextField(10);
	JPanel pRechercher = new JPanel(new FlowLayout());
	JPanel pQuit =new JPanel(new FlowLayout());
	JPanel PHaut = new JPanel(new BorderLayout());
	JPanel pBas = new JPanel(new BorderLayout());
	TableModele3 tm = new TableModele3();
	JTable tableEtudiant = new JTable(tm);
	JScrollPane jsp = new JScrollPane(tableEtudiant);

public SearchPerCat() {
	super("Gestion Produits");
	pRechercher.add(lrechercher);
	pRechercher.add(cf);
	
		

	PHaut.add(pRechercher, BorderLayout.CENTER);
	PHaut.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Rechercher produit"));
	
	pBas.add(jsp, BorderLayout.CENTER);
	pBas.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Liste des produits"));
this.add(PHaut, BorderLayout.NORTH);
	this.add(pBas, BorderLayout.CENTER);
pQuit.add(undo);
this.add(pQuit,BorderLayout.SOUTH);
	// TODO Auto-generated constructor stub
	setSize(500, 400);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	setVisible(true);
	tm.charger(action.getAllProduit());
cf.addItemListener(new ItemListener() {




@Override
public void itemStateChanged(ItemEvent arg0) {
	
	if (cf.getSelectedItem().toString().equals("All"))
		tm.charger(action.getAllProduit());
	else 
	{ 
		List<Categorie> l = action.getAllECategorie();
		int i = 0;
		for (Categorie e:l)
			if(e.getNom_cat().equals(cf.getSelectedItem().toString()))
				i=e.getCode();
		tm.charger(action.getAllProduitParC(i));
		
	}
		

	
}
});
undo.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		new Gestion_Catalogue();
		dispose();

	}
});
}
/*public static void main(String[] args) {
	  
	  new SearchPerCat();
	 
	  }*/
}
