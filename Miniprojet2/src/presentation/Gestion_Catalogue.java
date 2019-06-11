package presentation;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dao.SingletonConnection;

public class Gestion_Catalogue  extends JFrame {
	JButton ajouterp = new JButton(new ImageIcon("C:\\Users\\WIKI\\eclipse-workspace\\Miniprojet2\\src\\presentation\\image\\addp.png"));
	JButton ajouterc = new JButton(new ImageIcon("C:\\Users\\WIKI\\eclipse-workspace\\Miniprojet2\\src\\presentation\\image\\addc.png"));
	JButton rechercher = new JButton(new ImageIcon("C:\\Users\\WIKI\\eclipse-workspace\\Miniprojet2\\src\\presentation\\image\\searchb.png"));
	JButton Fermer = new JButton(new ImageIcon("C:\\Users\\WIKI\\eclipse-workspace\\Miniprojet2\\src\\presentation\\image\\close.png"));
	JPanel pack=new JPanel(new GridLayout(1,3,10,10));
	public Gestion_Catalogue() {
		super("Gestion catalogue");
		pack.add(ajouterp);
		pack.add(ajouterc);
		pack.add(rechercher);
		pack.add(Fermer);
		this.add(pack);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(0, 0);;
		this.setVisible(true);
		this.pack();
		new SingletonConnection();
		ajouterp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddProduit();
				dispose();
				// TODO Auto-generated method stub
				
			}}
			
		);
		
		this.ajouterc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCategorie();
				dispose();
				// TODO Auto-generated method stub
				
			}}
			
		);
		this.Fermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SingletonConnection.getConnection().close();
					System.out.println("connexion On :"+!SingletonConnection.getConnection().isClosed());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				
				dispose();
				// TODO Auto-generated method stub
				
			}}
			
		);
		this.rechercher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchPerCat();
				
				dispose();
				// TODO Auto-generated method stub
				
			}}
			
		);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		 
		new Gestion_Catalogue();
		
	}

}



