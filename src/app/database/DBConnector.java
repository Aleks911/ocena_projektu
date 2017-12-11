package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
//	koniecznie klasa publiczna bo inaczej siê nie po³¹czymy 
	
	Connection conn;
	
	//tworzymy metodê 
	public DBConnector() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
//			setAutoCommit(true);
		} catch(ClassNotFoundException e) {
			System.out.println("Nie zarejesttrowano klasy sterownika");
		}
	}
	
//  dla ³adniejszego zapisu zmienne do danych logoawnia deklarujemy w String - CASE SENSITIVE!!!!!! piszemy z ma³ych
//	metoda zwracaj¹ca biekt klasy connection
	public Connection connInit() {
		String url = "jdbc:mysql://localhost:3306/ocena_projektu";
		String user = "root";
		String pass = "Kurs2017";
		try {
		conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
		System.out.println("Nie mogê siê po³¹czyæ");
	}
		return conn;
	}
	
//	public static void main(String[] args) {
//		DBConnection db1= new DBConnection();
//		db1.connInit();
//		
//	}
	
	
}
