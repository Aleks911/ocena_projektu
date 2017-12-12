package app.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.database.DBConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class addProjektController {

    @FXML
    private TextField tf_temat;

    @FXML
    private TextArea ta_opis;

    @FXML
    private TextField tf_deadline;

    @FXML
    void actionClear(MouseEvent event) {
    	ta_opis.clear();
    	tf_temat.clear();
    	tf_deadline.clear();
    }

    @FXML
    void actionInsert(MouseEvent event) {
    	
    	tf_temat.getText();
    	ta_opis.getText();
    	tf_deadline.getText();
    	
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
	    	ps.executeUpdate();
//	    	czyszczenie okna pod wys³aniu ankiety
	    	ActionEvent ae = new ActionEvent();
	    	clearAction(ae);
	    	
		} catch (SQLException e) {
			e.printStackTrace();
			}
    	
    	
    }

	private void clearAction(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	}

}
