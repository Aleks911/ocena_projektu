package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Kursanci;
import app.model.OcenaProjekt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class KursantController {

    @FXML
    private TableView<Kursanci> t_kursant;

    @FXML
    private TableColumn<Kursanci, Integer> t_id_k;

    @FXML
    private TableColumn<Kursanci, String> t_imie;

    @FXML
    private TableColumn<Kursanci, String> t_nazwisko;

    @FXML
    private TableColumn<Kursanci, String> t_id_g;

    @FXML
    private TableColumn<Kursanci, String> t_email;

    @FXML
    private TableColumn<Kursanci, String> t_telefon;

    @FXML
    private TableColumn<Kursanci, String> t_gh_link;

    @FXML
    private TableView<OcenaProjekt> t_projekt_kursanta;

    @FXML
    private TableColumn<OcenaProjekt, Integer> tp_id_k;

    @FXML
    private TableColumn<OcenaProjekt, Integer> tp_id_p;

    @FXML
    private TableColumn<OcenaProjekt, String> tp_temat;

    @FXML
    private TableColumn<OcenaProjekt, String> tp_opis;

    @FXML
    private TableColumn<OcenaProjekt, String> tp_deadline;

    @FXML
    private TableColumn<OcenaProjekt, String> tp_data_od;

    @FXML
    private TableColumn<OcenaProjekt, String> tp_ocena;

    @FXML
    private Button btn_data;

    @FXML
    private TextField tf_data;

    @FXML
    private Button btn_pass;

    @FXML
    private Button btn_logout;
    
    @FXML
    private TextField tf_pass;
    
    
    int id_selected;
    @FXML
    void addDataAction(MouseEvent event) {
    	if(!tf_data.getText().equals("")) {
        	DBConnector db = new DBConnector();
        	Connection conn =db.connInit();
        	 	try {
        	id_selected = t_projekt_kursanta.getSelectionModel().getSelectedItem().getId_p();
        	} catch (Exception e) {
        		Alert a = new Alert(AlertType.ERROR);
    			a.setTitle("B³¹d przy dodwaniu daty");
    			a.setHeaderText("Nale¿y zaznaczyæ projekt do którego datê chcemy dodaæ");
    			a.showAndWait();
        	}
        	try {
    			ps = conn.prepareStatement("UPDATE ocena SET data_od = ? WHERE id_p = ?;");
    			ps.setString(1, tf_data.getText());
    			ps.setInt(2, id_selected);
    			ps.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println("blad");
    			e.printStackTrace();
    		}
    	
        	} else {
        		Alert a = new Alert(AlertType.ERROR);
    			a.setTitle("B³¹d dodawaniu grupy");
    			a.setHeaderText("Nazwa grupy nie mo¿e byæ pusta");
    			a.showAndWait();
        	}
    	selectProjekt();

        }

    

    @FXML
    void logOutAction(MouseEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void updatePassAction(MouseEvent event) {
    	if(!tf_pass.getText().equals("")) {
        	DBConnector db = new DBConnector();
        	Connection conn =db.connInit();
        	try {
    			ps = conn.prepareStatement("UPDATE logowanie SET haslo = ? WHERE id_k = ?;");
    			ps.setString(1, tf_pass.getText());
    			ps.setInt(2, logController.id_k);
    			ps.executeUpdate();
    		} catch (SQLException e) {
    				e.printStackTrace();
    		}
    	
        	} else {
        		Alert a = new Alert(AlertType.ERROR);
    			a.setTitle("B³¹d przy zmianie has³a");
    			a.setHeaderText("Has³o nie mo¿e byæ puste");
    			a.showAndWait();
        	}
    	

        }

    
    
    Connection conn;
    private void connection() {
 		DBConnector db = new DBConnector();
 		db = new DBConnector();
 		conn = db.connInit();
 	}
    
    PreparedStatement ps;
    public ObservableList<Kursanci> dane = FXCollections.observableArrayList(); 
    private void selectDane() {
 	   connection();
 		dane.clear();
 		t_kursant.setItems(dane);
 		try {
 			ps = conn.prepareStatement("select * from kursant where id_k = ?;");
 			ps.setInt(1, logController.id_k);
 			ResultSet rs = ps.executeQuery();

 			
 			while (rs.next()) {
 				dane.add(new Kursanci(rs.getInt("id_k"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("id_g"), rs.getString("email"), rs.getString("telefon"), rs.getString("gh_link")));
 			}

 			t_id_k.setCellValueFactory(new PropertyValueFactory<Kursanci, Integer>("id_k"));
 			t_imie.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("imie"));
 			t_nazwisko.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("nazwisko"));
 			t_id_g.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("id_g"));
 			t_email.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("email"));
 			t_telefon.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("telefon"));
 			t_gh_link.setCellValueFactory(new PropertyValueFactory<Kursanci, String>("gh_link"));
 			
 	    	
 	    	t_kursant.setItems(dane);

 			

 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	   
    }
    public ObservableList<OcenaProjekt> daneProjekt = FXCollections.observableArrayList(); 
    private void selectProjekt() {
  	   connection();
  		daneProjekt.clear();
  		t_projekt_kursanta.setItems(daneProjekt);
  		try {
  			ps = conn.prepareStatement("select * from ocena_projektu_kursanta where id_k = ?;");
  			ps.setInt(1, logController.id_k);
  			ResultSet rs = ps.executeQuery();

  			
  			while (rs.next()) {
  				daneProjekt.add(new OcenaProjekt(rs.getInt("id_k"), rs.getInt("id_p"), rs.getString("temat"), rs.getString("opis"), rs.getString("deadline"), rs.getString("data_od"), rs.getString("ocena")));
  			}

  			tp_id_k.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, Integer>("id_k"));
  			tp_id_p.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, Integer>("id_p"));
  			tp_temat.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("temat"));
  			tp_opis.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("opis"));
  			tp_deadline.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("deadline"));
  			tp_data_od.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("data_od"));
  			tp_ocena.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("ocena"));
  						
  	    	
  	    	t_projekt_kursanta.setItems(daneProjekt);

  			

  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  	   
     }
     
 	public void initialize() {
 		selectDane();
 		selectProjekt();
 	}

}
