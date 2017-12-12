package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Grupa;
import app.model.Kursanci;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StaryKursantController {

    @FXML
    private TableView<Kursanci> t_kursant;

    @FXML
    private TableColumn<Kursanci, String> tbl_imie;

    @FXML
    private TableColumn<Kursanci, String> tbl_nazwisko;

    @FXML
    private TableColumn<Kursanci, String> tbl_telefon;

    @FXML
    private TableColumn<Kursanci, String> tbl_email;

    @FXML
    private TableColumn<Kursanci, String> tbl_github;

    @FXML
    private TableView<?> t_projekt_kursanta;

    @FXML
    private TableColumn<?, ?> tp_id_k;

    @FXML
    private TableColumn<?, ?> tp_id_p;

    @FXML
    private TableColumn<?, ?> tp_temat;

    @FXML
    private TableColumn<?, ?> tp_opis;

    @FXML
    private TableColumn<?, ?> tp_deadline;

    @FXML
    private TableColumn<?, ?> tp_data_od;

    @FXML
    private TableColumn<?, ?> tp_ocena;

    @FXML
    private Button btn_data;

    @FXML
    private TextField tf_data;

    @FXML
    private Button btn_pass;

    @FXML
    private Button btn_logout;

    @FXML
    void addDataAction(MouseEvent event) {

    }

    @FXML
    void logOutAction(MouseEvent event) {

    }

    @FXML
    void updatePassAction(MouseEvent event) {

    }

    
   PreparedStatement ps;
   public ObservableList<Kursanci> dane = FXCollections.observableArrayList(); 
   Connection conn;
   
   private void connection() {
		DBConnector db = new DBConnector();
		db = new DBConnector();
		conn = db.connInit();
	}
   
   
   private void selectDane() {
	   connection();
		dane.clear();
		t_kursant.setItems(dane);
		try {
			ps = conn.prepareStatement("select * from kursant where id_k = ?;");
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()) {
				dane.add(new Kursanci(rs.getInt("id_k"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("id_g"), rs.getString("email"), rs.getString("telefon"), rs.getString("gh_link")));
			}

		/*	// id z tabeli, <Model, typ> ("nazwa kolumny w bazie danych")
			t_id_g.setCellValueFactory(new PropertyValueFactory<Grupa, Integer>("id_gr"));
			t_nazwa_gr.setCellValueFactory(new PropertyValueFactory<Grupa, String>("nazwa_gr"));
			// dodanie danych do TableView w postaci utworzenia obiektu ObservableList
			t_grupy.setItems(dane);*/

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
   }
    
	public void initialize() {
		selectDane();
	}

}
