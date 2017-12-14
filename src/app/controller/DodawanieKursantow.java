package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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

    Connection conn;
    PreparedStatement ps;
    @FXML
    void addAction(MouseEvent event) throws SQLException {
    	
    	if (!tf_name.getText().equals("")&&!tf_last.getText().equals("")&&!tf_grupa.getText().equals("")
    			&&!tf_mail.getText().equals("")&&!tf_tel.getText().equals("")&&!tf_git.getText().equals("")) {
    		
    	    	DBConnector db = new DBConnector();
    	    	conn = db.connInit();
    	    	
    	    	ps = conn.prepareStatement("insert into kursant (imie, nazwisko, id_g, email, telefon, gh_link) values (?,?,?,?,?,?)");
				ps.setString(1, tf_name.getText());
				ps.setString(2, tf_last.getText());
				ps.setString(3, tf_grupa.getText());				
				ps.setString(4, tf_mail.getText());
				ps.setString(5, tf_tel.getText());
				ps.setString(6, tf_git.getText());	
				
				ps.executeUpdate();    	    	
    	    	
    	    } else {
    	    Alert insertError = new Alert(AlertType.ERROR);
    		insertError.setTitle("B��d danych");
    		insertError.setHeaderText("B��d wpisywania");
    		insertError.setContentText("Aby wys�a� doda� kursanta, wype�nij wszystkie pola");
    		insertError.showAndWait();
    		}
    	}
    	
 


    @FXML
    void returnAction(MouseEvent event) throws IOException {
    	Stage stage = new Stage();
    	Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ListaKursantowView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Lista Kursant�w");
		stage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();		

    }
    	
}
