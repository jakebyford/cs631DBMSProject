module Dashboard {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	requires com.jfoenix;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
