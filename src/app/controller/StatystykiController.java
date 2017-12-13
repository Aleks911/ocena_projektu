package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Statystyki;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StatystykiController {

    @FXML
    private TableView<Statystyki> t_statystyki;

    @FXML
    private TableColumn<Statystyki, Integer> t_id_k;

    @FXML
    private TableColumn<Statystyki, String> t_imie;

    @FXML
    private TableColumn<Statystyki, String>t_nazwisko;

    @FXML
    private TableColumn<Statystyki, Integer>  t_id_p;

    @FXML
    private TableColumn<Statystyki, String> t_temat;

    @FXML
    private TableColumn<Statystyki, String> t_deadline;

    @FXML
    private TableColumn<Statystyki, Integer>  t_id_gr;

    @FXML
    private TableColumn<Statystyki, String> t_data_od;

    @FXML
    private TableColumn<Statystyki, String> t_ocena;

    @FXML
    private Button btn_all;

    @FXML
    private Button btn_kursant;

    @FXML
    private TextField tf_kursant;

    @FXML
    private Button btn_grupy;

    @FXML
    private TextField tf_grupy;

    @FXML
    private Button btn_b_oceny;
    
    Connection conn;
    PreparedStatement ps;
    public ObservableList<Statystyki> statystyki = FXCollections.observableArrayList(); 
    
    private void connection() {
  		DBConnector db = new DBConnector();
  		db = new DBConnector();
  		conn = db.connInit();
  	}

    @FXML
    void allAction(MouseEvent event) {
 	   	connection();
 		statystyki.clear();
 		t_statystyki.setItems(statystyki);
 		try {
 			ps = conn.prepareStatement("select * from ocena_projektu;");
 			ResultSet rs = ps.executeQuery();

 			
 			while (rs.next()) {
 				statystyki.add(new Statystyki(rs.getInt("id_k"), rs.getString("imie"),
 						rs.getString("nazwisko"), rs.getInt("id_p"), rs.getString("temat"),
 						rs.getString("deadline"), rs.getInt("id_gr"), rs.getString("data_od"),
 						rs.getString("ocena")));
 			}

 			t_id_k.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_k"));
 			t_imie.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("imie"));
 			t_nazwisko.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("nazwisko"));
 			t_id_p.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_p"));
 			t_temat.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("temat"));
 			t_deadline.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("deadline"));
 			t_id_gr.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_gr"));
 			t_data_od.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("data_od"));
 			t_ocena.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("ocena"));
 			
 	    	
 	    	t_statystyki.setItems(statystyki);

 			

 		} catch (SQLException e) {
 			e.printStackTrace();
 		}

    }

    @FXML
    void grupaAction(MouseEvent event) {
    	connection();
 		statystyki.clear();
 		t_statystyki.setItems(statystyki);
 		try {
 			ps = conn.prepareStatement("select * from ocena_projektu where id_gr=?;");
 			ps.setString(1, tf_grupy.getText());
 			ResultSet rs = ps.executeQuery();

 			
 			while (rs.next()) {
 				statystyki.add(new Statystyki(rs.getInt("id_k"), rs.getString("imie"),
 						rs.getString("nazwisko"), rs.getInt("id_p"), rs.getString("temat"),
 						rs.getString("deadline"), rs.getInt("id_gr"), rs.getString("data_od"),
 						rs.getString("ocena")));
 			}

 			t_id_k.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_k"));
 			t_imie.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("imie"));
 			t_nazwisko.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("nazwisko"));
 			t_id_p.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_p"));
 			t_temat.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("temat"));
 			t_deadline.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("deadline"));
 			t_id_gr.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_gr"));
 			t_data_od.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("data_od"));
 			t_ocena.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("ocena"));
 			
 	    	
 	    	t_statystyki.setItems(statystyki);

 			

 		} catch (SQLException e) {
 			e.printStackTrace();
 		}


    }

    @FXML
    void kursantAction(MouseEvent event) {
    	
    	connection();
 		statystyki.clear();
 		t_statystyki.setItems(statystyki);
 		try {
 			ps = conn.prepareStatement("select * from ocena_projektu where id_k=?;");
 			ps.setString(1, tf_kursant.getText());
 			ResultSet rs = ps.executeQuery();

 			
 			while (rs.next()) {
 				statystyki.add(new Statystyki(rs.getInt("id_k"), rs.getString("imie"),
 						rs.getString("nazwisko"), rs.getInt("id_p"), rs.getString("temat"),
 						rs.getString("deadline"), rs.getInt("id_gr"), rs.getString("data_od"),
 						rs.getString("ocena")));
 			}

 			t_id_k.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_k"));
 			t_imie.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("imie"));
 			t_nazwisko.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("nazwisko"));
 			t_id_p.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_p"));
 			t_temat.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("temat"));
 			t_deadline.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("deadline"));
 			t_id_gr.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_gr"));
 			t_data_od.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("data_od"));
 			t_ocena.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("ocena"));
 			
 	    	
 	    	t_statystyki.setItems(statystyki);

 			

 		} catch (SQLException e) {
 			e.printStackTrace();
 		}

    }

    @FXML
    void ocenaAction(MouseEvent event) {
    	
    	connection();
 		statystyki.clear();
 		t_statystyki.setItems(statystyki);
 		try {
 			ps = conn.prepareStatement("select * from ocena_projektu where ocena is null and data_od is not null;");
 			ResultSet rs = ps.executeQuery();

 			
 			while (rs.next()) {
 				statystyki.add(new Statystyki(rs.getInt("id_k"), rs.getString("imie"),
 						rs.getString("nazwisko"), rs.getInt("id_p"), rs.getString("temat"),
 						rs.getString("deadline"), rs.getInt("id_gr"), rs.getString("data_od"),
 						rs.getString("ocena")));
 			}

 			t_id_k.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_k"));
 			t_imie.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("imie"));
 			t_nazwisko.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("nazwisko"));
 			t_id_p.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_p"));
 			t_temat.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("temat"));
 			t_deadline.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("deadline"));
 			t_id_gr.setCellValueFactory(new PropertyValueFactory<Statystyki, Integer>("id_gr"));
 			t_data_od.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("data_od"));
 			t_ocena.setCellValueFactory(new PropertyValueFactory<Statystyki, String>("ocena"));
 			
 	    	
 	    	t_statystyki.setItems(statystyki);

 			

 		} catch (SQLException e) {
 			e.printStackTrace();
 		}

    }
    
    


}

