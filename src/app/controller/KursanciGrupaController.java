package app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class KursanciGrupaController {

    @FXML
    private TableView<?> t_grkursanci;

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
    void closeAction(MouseEvent event) {

    }

}
