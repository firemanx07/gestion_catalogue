package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Categorie;
import metier.Produit;

public class DaoCatalogue implements IDaoCatalogue {

	@Override
	public void addCategorie(Categorie e) {
		//new SingletonConnection();
	Connection cnx=SingletonConnection.getConnection();
	try {
	PreparedStatement st=cnx.prepareStatement("insert into categorie(nom_cat) values(?)");
		
		st.setString(1, e.getNom_cat());
		st.executeUpdate();
		st.close();
	}
	catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
	}

	@Override
	public void addProduit(Produit e) {
		//new SingletonConnection();
	Connection cnx=SingletonConnection.getConnection();
	try {
	PreparedStatement st=cnx.prepareStatement("insert into produit(nom_prod,prix_prod,qte_stock,code) values(?,?,?,?)");
		
		st.setString(1, e.getNom());
		st.setInt(2, e.getPrix_prod());
		st.setInt(3, e.getQte_stock());
		st.setInt(4, e.getC().getCode());
		st.executeUpdate();
		st.close();
	
	}
	catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
	}
	 
	public String CatAtID(int code)
	{
		
		List<Categorie> l=new ArrayList<Categorie>();
		
		l=this.getAllECategorie();
		for(Categorie e:l)
		{
		if(e.getCode()==code)
			return e.getNom_cat();
		}
		
		return null;
		
		
	}
	public int CodeAtCat(String code)
	{
		
		List<Categorie> l=new ArrayList<Categorie>();
		
		l=this.getAllECategorie();
		for(Categorie e:l)
		{
		if(e.getNom_cat().equals(code))
			return e.getCode();
		}
		
		return -1;
		
	}
	public boolean ExistCat(int i)
	{
		List<Categorie> l=new ArrayList<Categorie>();
		
			l=this.getAllECategorie();
			for(Categorie e:l)
			{
			if(e.getCode()==i)
				return true;
			}
				
		return false;
		
	}

	@Override
	public List<Categorie> getAllECategorie() {
		//new SingletonConnection();
		Connection cnx=SingletonConnection.getConnection();
		List<Categorie> l=new ArrayList<Categorie>();
		try {
			PreparedStatement st=cnx.prepareStatement("select * from categorie");
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				Categorie e=new Categorie();
				e.setCode(rs.getInt(1));
				e.setNom_cat(rs.getString(2));
				
				l.add(e);
			}
			st.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
public String[] AllCatname() {
	
	List<Categorie> ar=new ArrayList<Categorie>();
	int i = 1;
	
	ar=this.getAllECategorie();
	String msg[] =new String[ar.size()+1];
	msg[0]="All";
	for(Categorie e:ar) {
        msg[i]=e.getNom_cat();
        i++;
	}
        return msg;
    
}
	
	@Override
	public List<Produit> getAllProduit() {
		//new SingletonConnection();
		Connection cnx=SingletonConnection.getConnection();
		List<Produit> l=new ArrayList<Produit>();
		try {
			PreparedStatement st=cnx.prepareStatement("select * from produit");
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				Categorie c=new Categorie();
				Produit e=new Produit();
				e.setId(rs.getInt(1));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getInt(3));
				e.setQte_stock(rs.getInt(4));
				c.setCode(rs.getInt(5));
				c.setNom_cat(this.CatAtID(rs.getInt(5)));
				e.setC(c);
				
				l.add(e);
			}
			st.close();
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<Produit> getAllProduitParC(int code) {
		// TODO Auto-generated method stub
	//	new SingletonConnection();
		Connection cnx=SingletonConnection.getConnection();
		List<Produit> l=new ArrayList<Produit>();
		try {
			PreparedStatement st=cnx.prepareStatement("select * from produit where code=?");
			st.setInt(1, code);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				Produit e=new Produit();
				e.setId(rs.getInt(1));
				e.setNom(rs.getString(2));
				e.setPrenom(rs.getInt(3));
				e.setQte_stock(rs.getInt(4));
				Categorie c=new Categorie();
				c.setCode(rs.getInt(5));
				c.setNom_cat(this.CatAtID(rs.getInt(5)));
				e.setC(c);
				l.add(e);
			}
			st.close();
			rs.close();
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	

}
