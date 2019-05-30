package controlador;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.DatosAlumnos;
import vista.ConPrincipal;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	protected static DatosAlumnos miModel;
	protected static int indice;
	
	@Override
	public void start(Stage primaryStage) {

		miModel = new DatosAlumnos();
		indice = -1;
		
		
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Gestion Notas");
			
// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../vista/Principal.fxml"));
			rootLayout = (AnchorPane) loader.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarVentanaPrincipal(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
		
	}
	
	public void mostrarVentanaSecundaria() {
		try {
			FXMLLoader loader2 = new FXMLLoader();

			loader2.setLocation(Main.class.getResource("../vista/Secundaria.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader2.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			Stage secondaryStage = new Stage();
//            secondaryStage.getIcons().add(new Image("file:resources/images/icon_address.png"));
			secondaryStage.setTitle("Editar Alumno");
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
