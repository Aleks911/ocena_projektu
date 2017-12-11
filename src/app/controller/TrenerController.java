package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TrenerController {

    @FXML
    private Button btn_l_kursantów;

    @FXML
    private Button btn_l_projektow;

    @FXML
    private Button btn_l_grup;

    @FXML
    private Button btn_statystyki;

    @FXML
    private Button btn_logout;
    
    Parent parent;

    @FXML
    void listagAction(MouseEvent event) {
    	Stage logStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/GrupaView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		logStage.setScene(scene);
		logStage.setTitle("Sprzedawca - panel logowania");
		logStage.show();

    }

    @FXML
    void listakAction(MouseEvent event) {
    	Stage logStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ListaView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		logStage.setScene(scene);
		logStage.setTitle("Lista Kursantów");
		logStage.show();

    }

    

    @FXML
    void listapAction(MouseEvent event) {
    	Stage logStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ProjektView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		logStage.setScene(scene);
		logStage.setTitle("Lista Projektów");
		logStage.show();
    	

    }

    @FXML
    void logoutAction(MouseEvent event) {
    	Stage logStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/LoginView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		logStage.setScene(scene);
		logStage.setTitle("Panel logowania");
		logStage.show();

    }

    @FXML
    void statystykiAction(MouseEvent event) {
    	Stage logStage = new Stage();
		try {
			parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/StatystykiView.fxml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);
		logStage.setScene(scene);
		logStage.setTitle("--- Statystyki ---");
		logStage.show();

    }

}
