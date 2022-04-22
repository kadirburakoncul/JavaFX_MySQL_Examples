module JavaFX_Update_Sorgusu {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.swing;
	requires javafx.graphics;
	opens application to javafx.graphics, javafx.fxml;
}
