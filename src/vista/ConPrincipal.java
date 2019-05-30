package vista;

import controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Alumno;

public class ConPrincipal extends Main {
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnEditar;
	@FXML
	private Button btnBorrar;

	@FXML
	private TableView<Alumno> table;
	@FXML
	private TableColumn<Alumno, String> colNombre;
	@FXML
	private TableColumn<Alumno, String> colApellido;
	@FXML
	private TableColumn<Alumno, String> colMedia;

	private Alert alert;

	@FXML
	public void initialize() {

		colNombre.setCellValueFactory(new PropertyValueFactory<Alumno, String>("Nombre"));
		colApellido.setCellValueFactory(new PropertyValueFactory<Alumno, String>("Apellido"));
		colMedia.setCellValueFactory(new PropertyValueFactory<Alumno, String>("Media"));
		refrescarTabla();

	}

	public void refrescarTabla() {
		table.setItems(miModel.getAlumnos());
	}

	public void mostrarAlerta() {
		alert = new Alert(AlertType.WARNING);
		alert.setTitle("NO HAY SELECCION");
		alert.setHeaderText("No ha seleccionado ningun alumno");
		alert.setContentText("Debes selecionar un alumno de la tabla para poder realizar esa accion");
		alert.showAndWait();
	}

	public void editar() {
		if (table.getSelectionModel().isEmpty()) {
			mostrarAlerta();
		} else {
			indice = table.getSelectionModel().getSelectedIndex();
			mostrarVentanaSecundaria();
		}
	}

	public void borrar() {
		if (table.getSelectionModel().isEmpty()) {
			mostrarAlerta();
		}else {
			miModel.getAlumnos().remove(table.getSelectionModel().getSelectedIndex());
			refrescarTabla();
		}
	}

	public void nuevo() {
		indice = -1;
		mostrarVentanaSecundaria();

	}
}
