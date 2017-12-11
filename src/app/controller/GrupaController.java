package app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.database.DBConnector;
import app.model.Grupa;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GrupaController {

	@FXML
	private TableView<Grupa> t_grupy;

	@FXML
	private TableColumn<Grupa, Integer> t_id_g;

	@FXML
	private TableColumn<Grupa, String> t_nazwa_gr;

	@FXML
	private Button btn_dodaj;

	@FXML
	private Button btn_usun;

	@FXML
	private Button btn_wyswietl;

	Connection conn;
	Integer id_selected;

	private void connection() {
		DBConnector db = new DBConnector();
		db = new DBConnector();
		conn = db.connInit();
	}

	@FXML
	void dodajAction(MouseEvent event) {
		Stage stage = new Stage();
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/AddGrupaView.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Dodawanie grupy");
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void usunAction(MouseEvent event) {
		try {
			id_selected = t_grupy.getSelectionModel().getSelectedItem().getId_gr();
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle("B³¹d przy usuwaniu");
			a.setHeaderText("B³¹d przy usuwaniu grupy");
			a.setContentText("Aby usun¹æ rekord musisz go zaznaczyæ");
			a.showAndWait();
		}

		connection();
		try {
			ps = conn.prepareStatement("delete from grupa where id_gr=?");
			ps.setInt(1, id_selected);
			ps.executeUpdate();
			select();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@FXML
	void wyswietlAction(MouseEvent event) {

	}

	@FXML
	void refreshAction(MouseEvent event) {
		select();
	}

	PreparedStatement ps;
	public ObservableList<Grupa> dane = FXCollections.observableArrayList();

	private void select() {
		connection();
		dane.clear();
		t_grupy.setItems(dane);
		try {
			ps = conn.prepareStatement("select*from grupa;");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				dane.add(new Grupa(rs.getInt("id_gr"), rs.getString("nazwa_gr")));
			}

			// id z tabeli, <Model, typ> ("nazwa kolumny w bazie danych")
			t_id_g.setCellValueFactory(new PropertyValueFactory<Grupa, Integer>("id_gr"));
			t_nazwa_gr.setCellValueFactory(new PropertyValueFactory<Grupa, String>("nazwa_gr"));
			// dodanie danych do TableView w postaci utworzenia obiektu ObservableList
			t_grupy.setItems(dane);

			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		select();
	}

}
