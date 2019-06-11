package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import dao.DaoCatalogue;
import metier.Categorie;
import metier.Produit;

public class AddProduit extends JFrame {
	JPanel pInfo = new JPanel(new GridLayout(2, 2,10,10));
	JPanel PHaut = new JPanel(new BorderLayout());
	JPanel pAjout = new JPanel();
	JPanel pBas = new JPanel(new BorderLayout());
	JPanel pNom = new JPanel();
	JPanel pProduit = new JPanel();
	JPanel pQte = new JPanel();
	JPanel pCode = new JPanel();
	JLabel lNom = new JLabel("Produit:");
	JLabel lPrenom = new JLabel("Prix unité :");
	JLabel lqte= new JLabel("Quantité de stock:");
	JLabel lcode = new JLabel("categorie :");
	JTextField tNom = new JTextField(10);
	JTextField tprix= new JTextField(10);
	JTextField  tqte= new JTextField(10); 
	JTextField tcode= new JTextField(10); 
	
	TableModele3 tm = new TableModele3();
	JTable tableProduit = new JTable(tm);
	JScrollPane jsp = new JScrollPane(tableProduit);
	JButton ajouter = new JButton("Ajouter");
	JButton annuler = new JButton("Annuler");
	DaoCatalogue action=new DaoCatalogue();
	JComboBox<String> cf = new JComboBox<>(action.AllCatname());
	JPanel pTab = new JPanel(new GridLayout(1, 1));
	


public AddProduit() {

	super("Ajouter Produit");
	pNom.add(lNom);
	pNom.add(tNom);
	pProduit.add(lPrenom);
	pProduit.add(tprix);
	pQte.add(lqte);
	pQte.add(tqte);
	pCode.add(lcode);
	pCode.add(cf);
	pInfo.add(pNom);
	pInfo.add(pProduit);
	pInfo.add(pQte);
	pInfo.add(pCode);
	PHaut.add(pInfo, BorderLayout.CENTER);
	PHaut.add(pAjout, BorderLayout.SOUTH);
	pAjout.add(ajouter);
	pAjout.add(annuler);
	PHaut.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Ajouter Produit"));
	setVisible(true);
	this.add(PHaut, BorderLayout.NORTH);
//	pBas.add(pRechercher, BorderLayout.NORTH);
	pTab.add(jsp);
	pBas.add(pTab, BorderLayout.CENTER);
	pBas.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Liste des Produits"));

	this.add(pBas, BorderLayout.CENTER);

	setSize(500, 400);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	//tm.charger(action.getAllEtudiant());
	ajouter.addActionListener(new ActionListener() {


		@Override
		public void actionPerformed(ActionEvent arg0) {
		
try
{
			String nom = tNom.getText();
			int prix=Integer.parseInt(tprix.getText());	
			int qte=Integer.parseInt(tqte.getText());		
			int code=Integer.parseInt(tcode.getText());		
			if (nom.equals(""))
			JOptionPane.showMessageDialog(AddProduit.this,"erreur de saisie", "erreur",JOptionPane.ERROR_MESSAGE);
			else {
				if(action.ExistCat(code))
				{
				Categorie c=new Categorie(code,action.CatAtID(code));
				Produit e = new Produit(nom, prix, qte, c);
				action.addProduit(e);	
				
				tm.charger(action.getAllProduit());
				}
				else 
					JOptionPane.showMessageDialog(AddProduit.this,"Code categorie inexistant ! ", "erreur",JOptionPane.ERROR_MESSAGE);
				}
	}
catch(NumberFormatException ee)
{
	JOptionPane.showMessageDialog(AddProduit.this,"un entier est requis", "erreur",JOptionPane.ERROR_MESSAGE);
}

		}
	});



	annuler.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new Gestion_Catalogue();
			dispose();

		}
	});

}

	
	/* public static void main(String[] args) {
	  
	  new AddProduit();
	 
	  }*/
	 

}
