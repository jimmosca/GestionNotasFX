package modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class DatosAlumnos {
	private ObservableList<Alumno> alumnos;

	public DatosAlumnos() {
		alumnos = FXCollections.observableArrayList();
		alumnos.add(new Alumno("Jaime", "Casado", 10, 8.5, 7, 4, 10, 9.75,
				new Image("file:../../resources/img/img" + 0 + ".png", false)));
	}

	public ObservableList<Alumno> getAlumnos() {
		return alumnos;
	}
}
