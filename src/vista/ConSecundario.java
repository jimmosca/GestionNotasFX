package vista;

import controlador.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Alumno;

public class ConSecundario extends Main {
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtMedia;
	@FXML
	private TextField txtFol;
	@FXML
	private TextField txtSsii;
	@FXML
	private TextField txtProg;
	@FXML
	private TextField txtEnds;
	@FXML
	private TextField txtLmsgi;
	@FXML
	private TextField txtBbdd;

	@FXML
	private ImageView imgPerfil;

	private Alert alert;

	@FXML
	public void initialize() {
		
		if (indice != -1) {
			Alumno miAlumno = miModel.getAlumnos().get(indice);
			txtNombre.setText(miAlumno.getNombre());
			txtApellido.setText(miAlumno.getApellido());
			txtMedia.setText(miAlumno.getMedia());
			txtFol.setText(String.format("%.1f", miAlumno.getNotas()[0]).replace(',', '.'));
			txtSsii.setText(String.format("%.1f", miAlumno.getNotas()[1]).replace(',', '.'));
			txtProg.setText(String.format("%.1f", miAlumno.getNotas()[2]).replace(',', '.'));
			txtEnds.setText(String.format("%.1f", miAlumno.getNotas()[3]).replace(',', '.'));
			txtLmsgi.setText(String.format("%.1f", miAlumno.getNotas()[4]).replace(',', '.'));
			txtBbdd.setText(String.format("%.1f", miAlumno.getNotas()[5]).replace(',', '.'));
			imgPerfil.setImage(miAlumno.getImagen());
		}else
			imgPerfil.setImage(setImagen());
		txtMedia.setDisable(true);
	}
	private Image setImagen() {
		int aux = (int) (Math.random() * 3);
		return new Image("file:../../resources/img/img"+aux+".png", false);
	}

	public void aceptar(ActionEvent event) {
		if (txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtFol.getText().equals("")
				|| txtSsii.getText().equals("") || txtProg.getText().equals("") || txtEnds.getText().equals("")
				|| txtLmsgi.getText().equals("") || txtBbdd.getText().equals("") || comprobarNumeros()) {
			mostrarAlerta();
		} else {
			if (indice != -1) {
				miModel.getAlumnos().set(indice,
						new Alumno(txtNombre.getText(), txtApellido.getText(), Float.parseFloat(txtFol.getText()),
								Float.parseFloat(txtSsii.getText()), Float.parseFloat(txtProg.getText()),
								Float.parseFloat(txtEnds.getText()), Float.parseFloat(txtLmsgi.getText()),
								Float.parseFloat(txtBbdd.getText()), imgPerfil.getImage()));
			} else {
				miModel.getAlumnos()
						.add(new Alumno(txtNombre.getText(), txtApellido.getText(), Float.parseFloat(txtFol.getText()),
								Float.parseFloat(txtSsii.getText()), Float.parseFloat(txtProg.getText()),
								Float.parseFloat(txtEnds.getText()), Float.parseFloat(txtLmsgi.getText()),
								Float.parseFloat(txtBbdd.getText()), imgPerfil.getImage()));
			}
			mostrarVentanaPrincipal(event);
		}
	}

	public void mostrarAlerta() {
		alert = new Alert(AlertType.WARNING);
		alert.setTitle("CAMPOS INCORRECTOS");
		alert.setHeaderText("No ha completado debidamente todos los campos");
		alert.setContentText("Compruebe que todos los campos estan rellenados y que las notas están entre 0 y 10");
		alert.showAndWait();
	}

	public void cancelar(ActionEvent event) {
		mostrarVentanaPrincipal(event);
	}

	private boolean comprobarNumeros() {
		boolean check = false;

		try {
			Float[] arrNotas = { Float.parseFloat(txtFol.getText()), Float.parseFloat(txtSsii.getText()),
					Float.parseFloat(txtProg.getText()), Float.parseFloat(txtEnds.getText()),
					Float.parseFloat(txtLmsgi.getText()), Float.parseFloat(txtBbdd.getText()) };
			for (int i = 0; i < arrNotas.length; i++) {
				if (arrNotas[i] > 10 || arrNotas[i] < 0) 
					check = true;
			}
		} catch (NumberFormatException e) {
			check = true;
		}
		return check;
	}

}
