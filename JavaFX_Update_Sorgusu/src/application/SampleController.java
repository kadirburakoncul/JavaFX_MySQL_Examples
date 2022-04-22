package application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.veritabani;
import javafx.fxml.*;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML
	TextField ID_TextField;
	@FXML
	TextField Email_TextField;
	@FXML
	TextField Isim_TextField;
	@FXML
	TextField Sifre_TextField;
	
	veritabani db = new veritabani();
	PreparedStatement ps;
	ResultSet rs;
	
	@FXML
	public void KontrolEt() 
	{
		try 
		{
			db.baglan();
			String sorgu="SELECT * FROM deneme WHERE id=?";
			ps = db.baglanti.prepareStatement(sorgu);
			ps.setInt(1, Integer.parseInt(ID_TextField.getText()));
			rs = ps.executeQuery();
			while(rs.next()) 
			{
				Email_TextField.setText(rs.getString("email"));
				Isim_TextField.setText(rs.getString("isim"));
				Sifre_TextField.setText(rs.getString("sifre"));
			}
			db.kapat();
			ps.close();
			rs.close();
		}catch(Exception hata) 
		{
			JOptionPane.showMessageDialog(null, hata);
		}
	}
	
	@FXML
	public void Guncelle() 
	{
		try 
		{
			db.baglan();
			String sorgu="UPDATE deneme SET email=? , isim=? , sifre=? WHERE id=?";
			ps = db.baglanti.prepareStatement(sorgu);
			
			ps.setString(1, Email_TextField.getText());
			ps.setString(2, Isim_TextField.getText());
			ps.setString(3, Sifre_TextField.getText());
			ps.setInt(4,Integer.parseInt(ID_TextField.getText()));
			ps.executeUpdate();
			
			db.kapat();
			ps.close();
			rs.close();
			
			JOptionPane.showMessageDialog(null,"Baþarýyla Güncellendi");
			
		}catch(Exception hata) 
		{
			JOptionPane.showMessageDialog(null, hata);
			JOptionPane.showMessageDialog(null,"Bilgiler Güncellenemedi");
		}
	}
	
}
