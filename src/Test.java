/**
 * 
 * @author Maytal Twig
 * @mtwig95@gmail.com
 * @date 05/12/2021 
 * Main class for javaFX
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

	public void start(Stage stage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Test.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Countries quiz");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}