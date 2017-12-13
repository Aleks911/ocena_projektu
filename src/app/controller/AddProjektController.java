package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import app.database.DBConnector;
import app.model.Projekt;
import app.database.DBConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class AddProjektController {

    @FXML
    private TextField tf_temat;

    @FXML
    private TextArea ta_opis;

    @FXML
    private TextField tf_deadline;

    @FXML
    private TextField tf_grupa;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_clear;

    @FXML
    private Button btn_goback;

    
    @FXML

    void actionClear(MouseEvent event) {
    	ta_opis.clear();
    	tf_temat.clear();
    	tf_deadline.clear();
    	tf_grupa.clear();
    }

    @FXML
    void actionInsert(MouseEvent event) {
    	
    	tf_temat.getText();
    	ta_opis.getText();
    	tf_deadline.getText();
    	tf_grupa.getText();

    	
    	DBConnector db = new DBConnector();
    	Connection conn = db.connInit();
    	PreparedStatement ps;
		try {
			ps = conn.prepareStatement(
					"insert into projekt (temat, opis, deadline, id_gr)" 
					+ "values (?,?,?,?)");
			ps.setString(1, tf_temat.getText());
	    	ps.setString(2, ta_opis.getText());
	    	ps.setString(3, tf_deadline.getText());
	    	ps.setString(4, tf_grupa.getText());
	    	ps.executeUpdate();
	    	
	    	System.out.println();
	    	
//	    	czyszczenie okna pod wys³aniu ankiety
	    	ActionEvent ae = new ActionEvent();
	    	clearAction(ae);
	    	
		} catch (SQLException e) {
			e.printStackTrace();
			}

    }
    
    
    @FXML
    void actionGoBack(MouseEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @FXML
    void actionRefresh(MouseEvent event) {
    	select();
    }
    
    
    
    
    
//     private void select() {
//    	connection();
//    	String dane;
//    	dane.clear();
//    	t_projekty.setItems(dane);
////    	try {
//    	ps = conn.prepareStatement("SELECT * FROM projekt;");
//        ResultSet rs = ps.executeQuery();
//    	while(rs.next()) {
//    			dane.add(new Projekt(
//    					rs.getInt("id_p"),
//    					rs.getString("temat"),
//    					rs.getString("opis"),
//    					rs.getString("deadline"),
//    					rs.getInt("id_gr")));
//    	}
//    	
////    	wpisujemy vartoœci do obiektów kolumn tabeli
//    	t_id_p.setCellValueFactory(new PropertyValueFactory<Projekt,Integer>("id_p"));
//    	t_temat.setCellValueFactory(new PropertyValueFactory<Projekt,String>("temat"));
//    	t_opis.setCellValueFactory(new PropertyValueFactory<Projekt,String>("opis"));
//    	t_deadline.setCellValueFactory(new PropertyValueFactory<Projekt,String>("deadline"));
//    	t_id_gr.setCellValueFactory(new PropertyValueFactory<Projekt,Integer>("id_gr"));
//    	
////    	dodanie danych do tabeli view w postaci obiektu ObservableList
//    	t_projekty.setItems(null);
//    	t_projekty.setItems(dane);
//    	}
//    	catch (SQLException e) {
//    		e.printStackTrace();
//    	}
    	
    	
    	
    Connection conn;
    
    private void connection() {
    	
       		DBConnector db = new DBConnector();
     		db = new DBConnector();
     		conn = db.connInit();
     	}
    	


	private void clearAction(ActionEvent ae) {

		
	}

	
	   private void select() {
	    	connection();
	    	    	}
	    
	    public void initialize() {
	    	select();
	    }
	    	
	
	
	
	
	
	
	
	
}
