package app;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) {

		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/logView.fxml"));
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ProjektView.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Projekty");
=======
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Logowanie");
>>>>>>> e35fb1d1d02188f92523cf0db86fe27855f12e2d
			stage.show();
			
		} catch (IOException e) {

	}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}