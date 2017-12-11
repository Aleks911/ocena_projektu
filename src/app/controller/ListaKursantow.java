package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListaKursantow {

    @FXML
    private TableView<?> t_kursanci;

    @FXML
    private TableColumn<?, ?> t_id;

    @FXML
    private TableColumn<?, ?> t_name;

    @FXML
    private TableColumn<?, ?> t_last;

    @FXML
    private TableColumn<?, ?> t_grupa;

    @FXML
    private TableColumn<?, ?> t_mail;

    @FXML
    private TableColumn<?, ?> t_tel;

    @FXML
    private TableColumn<?, ?> t_git;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_del;

    @FXML
    private Button btn_cor;

    @FXML
    private Button btn_rate;

    @FXML
    void addAction(MouseEvent event) throws IOException {
		Stage stage = new Stage();
    	Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/DodawanieKursantowView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Dodawanie Kursantów");
		stage.show();		
		((Node)(event.getSource())).getScene().getWindow().hide();
    }
    

    @FXML
    void correctAction(MouseEvent event) {

    }

    @FXML
    void deleteAction(MouseEvent event) {

    }

    @FXML
    void rateAction(MouseEvent event) throws IOException {
    	Stage stage = new Stage();
    	Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/RateView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Ocena Kursantów");
		stage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();	

    }

}
