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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class logController {

    @FXML
    private TextField tf_login;

    @FXML
    private PasswordField tf_pass;

    @FXML
    private Button btn_login;
    
    DBConnector db;
    PreparedStatement ps;
    Parent parent;
    // stworzyæ zmienn¹ statyczn¹, która przechowuje dane id_k
    static int id_k;

    @FXML
    void loginAction(MouseEvent event) {
    	db = new DBConnector();
		Connection conn = db.connInit();
		
		try {
			ps = conn.prepareStatement("select permission, id_k from logowanie where login=? and haslo=?;");
			ps.setString(1, tf_login.getText());
			ps.setString(2, tf_pass.getText());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String perm = rs.getString("permission");
				id_k = rs.getInt("id_k");
				if (perm.equals("1")) {
					Stage stageUser = new Stage();
					
					try {
						parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/KursantView.fxml"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Scene scene = new Scene(parent);
					stageUser.setScene(scene);
					stageUser.setTitle("Panel Kursanta");
					stageUser.show();
					
				} else {
					Stage stageAdmin = new Stage();
					
					try {
						parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/TrenerView.fxml"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					Scene scene = new Scene(parent);
					stageAdmin.setScene(scene);
					stageAdmin.setTitle("Admin");
					stageAdmin.show();
				}
				
			}else {
			Alert loginError = new Alert(AlertType.ERROR);
			loginError.setTitle("B³¹d logowania");
			loginError.setHeaderText("B³¹d logowania!");
			loginError.setContentText("Has³o lub login s¹ niepoprwane. \nSpróbuj ponownie lub skontatktuj siê z Administratorem.");
			loginError.showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }

}