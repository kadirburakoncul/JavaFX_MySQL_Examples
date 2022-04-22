module JavaFX_Delete_Sorgusu {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.swing;
	
	opens application to javafx.graphics, javafx.fxml;
}
