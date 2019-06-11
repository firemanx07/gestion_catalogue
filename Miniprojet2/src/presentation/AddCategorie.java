package presentation;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;

import dao.*;
import metier.Categorie;



public class AddCategorie extends JFrame {
	
	JPanel pInfo = new JPanel(new GridLayout(1, 2,10,10));
	JPanel PHaut = new JPanel(new BorderLayout());
	JPanel pAjout = new JPanel();
	JPanel pBas = new JPanel(new BorderLayout());
	JPanel pPrenom = new JPanel(new FlowLayout());
	
	
	
	JLabel lPrenom = new JLabel("Nom de Categorie:");

	
	JTextField tPrenom = new JTextField(10);
	
	TableModele tm = new TableModele();
	JTable tableEtudiant = new JTable(tm);
	JScrollPane jsp = new JScrollPane(tableEtudiant);
	JButton ajouter = new JButton("Ajouter");
	JButton annuler = new JButton("Annuler");
	
	JPanel pTab = new JPanel(new GridLayout(1, 1));
	DaoCatalogue action=new DaoCatalogue();
	public AddCategorie() {

		super("Ajouter Categorie");
		pPrenom.add(lPrenom);
		pInfo.add(pPrenom);
		
		
		
		pInfo.add(tPrenom);
		
		PHaut.add(pInfo, BorderLayout.CENTER);
		PHaut.add(pAjout, BorderLayout.SOUTH);
		pAjout.add(ajouter);
		pAjout.add(annuler);
		PHaut.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Ajouter Categorie"));
		setVisible(true);
		this.add(PHaut, BorderLayout.NORTH);
	//	pBas.add(pRechercher, BorderLayout.NORTH);
		pTab.add(jsp);
		pBas.add(pTab, BorderLayout.CENTER);
		pBas.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED),"Liste des categories"));
	
		this.add(pBas, BorderLayout.CENTER);

		setSize(500, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		tm.charger(action.getAllECategorie());
		ajouter.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				

				
				String prenom = tPrenom.getText();
				
		
				if (prenom.equals(""))
					JOptionPane.showMessageDialog(AddCategorie.this,
							"erreur de saisie", "erreur",
							JOptionPane.ERROR_MESSAGE);
				
				else {
					Categorie e = new Categorie(prenom);
					action.addCategorie(e);;		
				//	gestion.ajouterEtudiant(e);
					//gestion.trierListeEtudiantsParNom();
					tm.charger(action.getAllECategorie());}
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

	public static void main(String[] args) {
 
		new AddCategorie();

	}
}
