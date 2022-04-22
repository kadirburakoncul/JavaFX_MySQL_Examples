package application;


import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import database.veritabani;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class SampleController {
	
	@FXML
	TextField ID_TextField;
	@FXML
	Button Sil_Button;
	
	veritabani db = new veritabani(); 
	PreparedStatement ps;
	
	@FXML
	public void Sil_Button_Action() 
	{
		try 
		{
			db.baglan();
			String sorgu = "DELETE FROM deneme WHERE id = ?";
			ps = db.baglanti.prepareStatement(sorgu);
			ps.setInt(1, Integer.parseInt(ID_TextField.getText()));
			
			ps.execute();
			
			db.kapat();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Kayýt Silindi.");
			
			
		}catch(Exception hata) 
		{
			JOptionPane.showMessageDialog(null, "Kayýt Silinemedi.");
		}
	}
	
}
