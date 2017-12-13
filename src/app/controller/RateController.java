package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Kursanci;
import app.model.Projekt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RateController {

    @FXML
    private TableView<Projekt> t_ocena;

    @FXML
    private TableColumn<Projekt, Integer> t_id;

    @FXML
    private TableColumn<Projekt, String> t_topic;

    @FXML
    private TableColumn<Projekt, String> t_descr;

    @FXML
    private TableColumn<Projekt, String> t_deadline;
    
    @FXML
    private TableColumn<Projekt, Integer> t_grupa;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_return;

    @FXML
    void addAction(MouseEvent event) {   	
    	

    }

    static int id_selected;
    ListaKursantow tk = new ListaKursantow();
    
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
    
    ObservableList<Projekt> listaP;
    PreparedStatement ps;
    private void select() throws SQLException {
    
    	ps = conn.prepareStatement("select * from ocena_projektu where id_k = ?");
    	ps.setInt(1, ListaKursantow.id_selected);
    	System.out.println(id_selected);
    	ResultSet rs = ps.executeQuery();
    	try {
			listaP = FXCollections.observableArrayList();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	while(rs.next()) {
    		listaP.add(new Projekt(
    				rs.getInt("id_p"), 
    				rs.getString("temat"), 
    				rs.getString("opis"),
    				rs.getString("deadline"),
    				rs.getInt("id_gr")
    				));
    	}
    	t_id.setCellValueFactory(new PropertyValueFactory<Projekt, Integer>("id_p"));
    	t_topic.setCellValueFactory(new PropertyValueFactory<Projekt, String>("temat"));
    	t_descr.setCellValueFactory(new PropertyValueFactory<Projekt, String>("opis"));
    	t_deadline.setCellValueFactory(new PropertyValueFactory<Projekt, String>("deadline"));			
    	t_grupa.setCellValueFactory(new PropertyValueFactory<Projekt, Integer>("id_gr"));			
    	
    	t_ocena.setItems(listaP);
    	
    }
    
    Connection conn;
    public void initialize() throws SQLException {
    	DBConnector db = new DBConnector();
    	conn = db.connInit();
    	select();
    }

}
