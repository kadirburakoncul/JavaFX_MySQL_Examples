package application;


import java.sql.PreparedStatement;
import java.sql.ResultSet;


import database.veritabani;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.text.*;
public class SampleController {
	@FXML
	Text Getir_txt;
	@FXML
	Button Bul_button;
	
	veritabani db=new veritabani();
	
	PreparedStatement ps;
	ResultSet rs;
	
	@FXML
	public void Bul_button_action() 
	{
		try 
		{
			db.baglan();
			String sorgu="SELECT * FROM deneme WHERE id=1";
			ps=db.baglanti.prepareStatement(sorgu);
			rs= ps.executeQuery();
			
			while(rs.next()) 
			{
				Getir_txt.setText(rs.getString("email"));
			}
			db.kapat();
			rs.close();
			ps.close();
			
		}catch(Exception hata) 
		{
			
		}
	}
}