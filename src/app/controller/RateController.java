package app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RateController {

    @FXML
    private TableView<?> t_ocena;

    @FXML
    private TableColumn<?, ?> t_id;

    @FXML
    private TableColumn<?, ?> t_topic;

    @FXML
    private TableColumn<?, ?> t_descr;

    @FXML
    private TableColumn<?, ?> t_deadline;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_return;

    @FXML
    void addAction(MouseEvent event) {

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
