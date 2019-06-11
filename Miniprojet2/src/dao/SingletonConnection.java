package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class SingletonConnection {
	private static Connection connection;
	public SingletonConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Catalogue?verifyServerCertificate=false&useSSL=true", "root", "");
			System.out.println("connexion On :"+!connection.isClosed());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}
public static Connection getConnection()
{
	return connection;
}
public static void main(String[] args) {

	new SingletonConnection();

}
}
