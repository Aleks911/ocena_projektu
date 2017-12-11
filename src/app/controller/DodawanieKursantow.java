package app.controller;

import java.io.IOException;
import java.sql.Connection;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DodawanieKursantow {

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_return;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_last;

    @FXML
    private TextField tf_grupa;

    @FXML
    private TextField tf_mail;

    @FXML
    private TextField tf_tel;

    @FXML
    private TextField tf_git;

    @FXML
    void addAction(MouseEvent event) {
    	
    	DBConnector db = new DBConnector();
		Connection conn = db.connInit(); 

    }

    @FXML
    void returnAction(MouseEvent event) throws IOException {
    	Stage stage = new Stage();
    	Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ListaKursantowView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Lista Kursantów");
		stage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();		

    }
    	
}
