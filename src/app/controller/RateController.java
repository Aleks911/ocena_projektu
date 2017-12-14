package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;

import app.model.OcenaProjekt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RateController {

	@FXML
	private Button btn_add;

	@FXML
	private Button btn_return;

	@FXML
	private TableView<OcenaProjekt> t;

	@FXML
	private TableColumn<OcenaProjekt, Integer> t_idk;

	@FXML
	private TableColumn<OcenaProjekt, Integer> t_idp;

	@FXML
	private TableColumn<OcenaProjekt, String> t_temat;

	@FXML
	private TableColumn<OcenaProjekt, String> t_opis;

	@FXML
	private TableColumn<OcenaProjekt, String> t_deadline;

	@FXML
	private TableColumn<OcenaProjekt, String> t_dataoddania;

	@FXML
	private TableColumn<OcenaProjekt, String> t_ocena;

	ObservableList<String> ocena = FXCollections.observableArrayList("0", "2", "4", "6", "8", "10");
	@FXML
	private ComboBox<String> cb_ocena;

	//String oc = cb_ocena.getValue();

	int ids;

	@FXML
	void addAction(MouseEvent event) throws SQLException {

		ids = t.getSelectionModel().getSelectedItem().getId_p();
		System.out.println(ids);
		String oc = cb_ocena.getValue();
		ps = conn.prepareStatement("UPDATE OCENA SET ocena = ? where id_p =?");
		ps.setString(1, oc);
		ps.setInt(2, ids);
		ps.executeUpdate();
		
		select();

	}

	ListaKursantow tk = new ListaKursantow();

	@FXML
	void returnAction(MouseEvent event) throws IOException {
		Stage stage = new Stage();
		Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ListaKursantowView.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Lista Kursantów");
		stage.show();
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	ObservableList<OcenaProjekt> listaP;
	PreparedStatement ps;

	private void select() throws SQLException {

		ps = conn.prepareStatement("select * from ocena_projektu_kursanta where id_k = ? ");
		ps.setInt(1, ListaKursantow.id_selected);
		ResultSet rs = ps.executeQuery();
		try {
			listaP = FXCollections.observableArrayList();
		} catch (Exception e) {

			e.printStackTrace();
		}
		while (rs.next()) {
			listaP.add(new OcenaProjekt(rs.getInt("id_k"), rs.getInt("id_p"), rs.getString("temat"),
					rs.getString("opis"), rs.getString("deadline"), rs.getString("data_od"), rs.getString("ocena")));
		}
		t_idk.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, Integer>("id_k"));
		t_idp.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, Integer>("id_p"));
		t_temat.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("temat"));
		t_opis.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("opis"));
		t_deadline.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("deadline"));
		t_dataoddania.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("data_od"));
		t_ocena.setCellValueFactory(new PropertyValueFactory<OcenaProjekt, String>("ocena"));

		t.setItems(listaP);

	}

	Connection conn;

	public void initialize() throws SQLException {
		DBConnector db = new DBConnector();
		conn = db.connInit();
		select();
		cb_ocena.setItems(ocena);

	}

}
