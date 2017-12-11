package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class AddgrController {

    @FXML
    private TextField tf_nazwa_gr;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_close;
    
    PreparedStatement ps;
    @FXML
    void addgrAction(MouseEvent event) {
    	if(!tf_nazwa_gr.getText().equals("")) {
    	DBConnector db = new DBConnector();
    	Connection conn =db.connInit();
    	try {
			ps = conn.prepareStatement("insert into grupa values  (null, ?);");
			ps.setString(1, tf_nazwa_gr.getText());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
    	} else {
    		Alert a = new Alert(AlertType.ERROR);
			a.setTitle("B³¹d dodawaniu grupy");
			a.setHeaderText("Nazwa grupy nie mo¿e byæ pusta");
			a.showAndWait();
    	}

    }

    @FXML
    void closegrAction(MouseEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

}