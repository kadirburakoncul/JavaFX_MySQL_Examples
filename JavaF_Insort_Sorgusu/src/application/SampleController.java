package application;


import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import java.sql.*;

import javax.swing.JOptionPane;

import database.veritabani;
public class SampleController {
	@FXML
	TextField Email_TextField;
	@FXML
	TextField Isim_TextField;
	@FXML
	PasswordField Sifre_PasswordField;
	@FXML
	Button Ekle_Button;
	
	veritabani db =new veritabani();
	PreparedStatement ps;
	ResultSet rs;
	public void Ekle_Button_Action() 
	{
		if(Email_TextField.getText().equals("") || Isim_TextField.getText().equals("") || Sifre_PasswordField.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Lütfen Ýstenilen Bilgileri Eksik Olmadan Giriniz.");
		}
		else 
		{
			try 
			{
				db.baglan();
				String sorgu="insert into deneme(email,isim,sifre) value(?,?,?)";
				ps=db.baglanti.prepareStatement(sorgu);
				ps.setString(1, Email_TextField.getText());
				ps.setString(2, Isim_TextField.getText());
				ps.setString(3, Sifre_PasswordField.getText());
				//rs=ps.executeQuery();
				ps.execute();
				db.kapat();
				ps.close();
				//rs.close();
				JOptionPane.showMessageDialog(null, "Kayýt Baþarýyla Eklendi");
				
			}catch(Exception hata)
			{
			JOptionPane.showMessageDialog(null, hata);	
			}
		}
		
	}
	
}
