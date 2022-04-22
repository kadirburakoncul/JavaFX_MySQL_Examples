package database;
import java.sql.*;

import javax.swing.JOptionPane;
public class veritabani {
	
	public Connection baglanti;
	private String databaseismi="Kadir";
	private String kullaniciadi="root";
	private String kullanicisifresi;
	
	public Connection baglan() 
	{
	 String Url="jdbc:mysql://localhost:3306/"+databaseismi;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			baglanti = DriverManager.getConnection(Url,kullaniciadi,kullanicisifresi);
		}catch(Exception hata) 
		{
		JOptionPane.showMessageDialog(null,hata);	
		}
		return baglanti;
	}
	public void kapat() 
	{
		try 
		{
			baglanti.close();	
		}catch(Exception hata) 
		{
			JOptionPane.showMessageDialog(null,hata);	
		}
	}
	
}