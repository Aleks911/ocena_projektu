package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Kursanci;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListaKursantow {

    @FXML
    private TableView<Kursanci> t_kursanci;

    @FXML
    private TableColumn<Kursanci, Integer> t_id;

    @FXML
    private TableColumn<Kursanci, String> t_name;

    @FXML
    private TableColumn<Kursanci, String> t_last;

    @FXML
    private TableColumn<Kursanci, String> t_grupa;

    @FXML
    private TableColumn<Kursanci, String> t_mail;

    @FXML
    private TableColumn<Kursanci, String> t_tel;

    @FXML
    private TableColumn<Kursanci, String> t_git;

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
    
  static int id_selected;
  static int ids;
  
    
    @FXML
    void correctAction(MouseEvent event) throws IOException {
    	id_selected = t_kursanci.getSelectionModel().getSelectedItem().getId_k();
    	ids = t_kursanci.getSelectionModel().getSelectedItem().getId_k();
    	System.out.println(id_selected);
    	Stage stage = new Stage();
    	Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/EdytowanieKursantowView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Ocena Kursantów");
		stage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void deleteAction(MouseEvent event) throws SQLException, IOException {
    	
    	id_selected = t_kursanci.getSelectionModel().getSelectedItem().getId_k();
    	System.out.println(id_selected);
    	DBConnector db = new DBConnector();
    	conn = db.connInit();
    	System.out.println(id_selected);
    	//ps = conn.prepareStatement("delete from logowanie where id_k=?");
    	//ps.setInt(1, ListaKursantow.id_selected);
    	//ps.executeUpdate();
    	ps = conn.prepareStatement("delete from kursant where id_k=?");
    	ps.setInt(1, id_selected);			
		ps.executeUpdate();
		Stage stage = new Stage();
    	Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ListaKursantowView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Lista Kursantów");
		stage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();	

    }

    @FXML
    void rateAction(MouseEvent event) throws IOException {
    	id_selected = t_kursanci.getSelectionModel().getSelectedItem().getId_k();
    	Stage stage = new Stage();
    	Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/RateView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Ocena Kursantów");
		stage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();	

    }
    ObservableList<Kursanci> listaK;
    PreparedStatement ps;
    private void select() throws SQLException {
    	ps = conn.prepareStatement("select * from kursant");
    	ResultSet rs = ps.executeQuery();
    	try {
			listaK = FXCollections.observableArrayList();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	while(rs.next()) {
    		listaK.add(new Kursanci(rs.getInt("id_k"), 
    				rs.getString("imie"), 
    				rs.getString("nazwisko"), 
    				rs.getString("id_g"),
    				rs.getString("email"), 
    				rs.getString("telefon"), 
    				rs.getString("gh_link")));
    	}
    	t_id.setCellValueFactory(new PropertyValueFactory<Kursanci, Integer>("id_k"));
		t_name.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("imie"));
		t_last.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("nazwisko"));
		t_grupa.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("id_g"));
		t_mail.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("email"));
		t_tel.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("telefon"));
		t_git.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("gh_link"));
		
    	
    	t_kursanci.setItems(listaK);
    	
    }
    
    
    
    Connection conn;
    public void initialize() throws SQLException {
    	DBConnector db = new DBConnector();
    	conn = db.connInit();
    	select();
    }

}
