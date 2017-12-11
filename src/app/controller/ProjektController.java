package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Projekt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ProjektController {

    @FXML
    private TableView<Projekt> t_projekty;

    @FXML
    private TableColumn<Projekt,Integer> t_id_p;

    @FXML
    private TableColumn<Projekt, String> t_temat;

    @FXML
    private TableColumn<Projekt, String> t_opis;

    @FXML
    private TableColumn<Projekt, String> t_deadline;

    
    @FXML
    private TableColumn<Projekt,Integer> t_id_gr;
    
    
    @FXML
    private Button btn_dodaj;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;


    
  public ObservableList<Projekt> dane = FXCollections.observableArrayList();
  PreparedStatement ps;
  DBConnector db;
  Connection conn;
  int id_selected;
    
    
    
    @FXML
    void addAction(MouseEvent event) {
    }

    
    
    
    
    
    @FXML
    void deleteAction(MouseEvent event) {
    	
    	try {
    	    	id_selected = t_projekty.getSelectionModel().getSelectedItem().getId_p(); 
    	    	}
    	    	catch (Exception e) {
    	    		Alert a = new Alert(AlertType.ERROR);
    	        	a.setTitle("B³¹d");
    	        	a.setHeaderText("B³¹d");
    	        	a.setContentText("Aby usun¹æ rekord musisz go najpierw zaznaczyæ");
    	        	a.showAndWait();
    	    	}
    	    	
    	    	connection();
    	    	try {
    	    	ps = conn.prepareStatement("DELETE FROM ankieta WHERE id=?");
    	    	ps.setInt(1, id_selected);
    	    	ps.executeUpdate();
    	    	}
    	    	catch (SQLException e) {
    	    		e.printStackTrace();
    	    	}
    	    	select();

    }

    @FXML
    void editAction(MouseEvent event) {

    }
    
    private void connection() {
 		db = new DBConnector();
 		conn = db.connInit();
     }
    
    
    private void select() {
    	connection();
    	dane.clear();
    	t_projekty.setItems(dane);
    	try {
    	ResultSet rs = ps.executeQuery();
    	while(rs.next()) {
    			dane.add(new Projekt(
    					rs.getInt("id_p"),
    					rs.getString("temat"),
    					rs.getString("opis"),
    					rs.getString("deadline"),
    					rs.getInt("id_gr")));
    	}
    	
//    	wpisujemy vartoœci do obiektów kolumn tabeli
    	t_id_p.setCellValueFactory(new PropertyValueFactory<Projekt,Integer>("id_p") );
    	t_temat.setCellValueFactory(new PropertyValueFactory<Projekt,String>("test") );
    	t_opis.setCellValueFactory(new PropertyValueFactory<Projekt,String>("opis") );
    	t_deadline.setCellValueFactory(new PropertyValueFactory<Projekt,String>("deadline") );
    	t_id_gr.setCellValueFactory(new PropertyValueFactory<Projekt,Integer>("id_gr") );
//    	dodanie danych do tabeli view w postaci obiektu ObservableList
    	t_projekty.setItems(null);
    	t_projekty.setItems(dane);
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	
    	}
    
    
    public void initialize() {
    	select();
    }
    

}
