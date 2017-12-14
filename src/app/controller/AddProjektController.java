package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
    static int z;
    ArrayList<Integer> lista = new ArrayList <Integer> ();
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
	    	ps = conn.prepareStatement("select id_p from projekt where temat=? and opis=? and deadline=? and id_gr=?");
	    	ps.setString(1, tf_temat.getText());
	    	ps.setString(2, ta_opis.getText());
	    	ps.setString(3, tf_deadline.getText());
	    	ps.setString(4, tf_grupa.getText());
	    	ResultSet rs = ps.executeQuery();
	    	while (rs.next()) {
	    		z = rs.getInt("id_p");
	    		System.out.println(z);
	    	}
	    	ps = conn.prepareStatement("select id_k from kursant where id_g = (select id_gr from projekt where id_p = ?);");
	    	ps.setInt(1, z);
	    	ResultSet rs2 = ps.executeQuery();
	    	while (rs2.next()) {
	    		lista.add(rs.getInt("id_k"));
	    	}
	    	System.out.println(lista);
	    	
	    	
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
