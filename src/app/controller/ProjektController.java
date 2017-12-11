package app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ProjektController {

    @FXML
    private TableView<?> t_projekty;

    @FXML
    private TableColumn<?, ?> t_id_p;

    @FXML
    private TableColumn<?, ?> t_temat;

    @FXML
    private TableColumn<?, ?> t_opis;

    @FXML
    private TableColumn<?, ?> t_deadline;

    @FXML
    private Button btn_dodaj;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;

    @FXML
    void addAction(MouseEvent event) {

    }

    @FXML
    void deleteAction(MouseEvent event) {

    }

    @FXML
    void editAction(MouseEvent event) {

    }

}
