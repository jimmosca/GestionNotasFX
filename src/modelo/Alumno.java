package modelo;

import javafx.scene.image.Image;

public class Alumno {

	private String nombre;
	private String apellido;
	private double[] notas;
	private String media;
	private Image imagen;

	public Alumno(String nombre, String apellido, double fol, double ssii, double prog, double ends, double lmsgi,
			double bbdd, Image imagen) {
		this.nombre = nombre;
		this.apellido = apellido;
		notas = new double[] { fol, ssii, prog, ends, lmsgi, bbdd };
		setMedia();
		this.imagen = imagen;

	}

	private void setMedia() {
		double aux = 0;

		for (double d : notas)
			aux += d;

		aux /= notas.length;
		media = String.format("%.1f", aux).replace(',', '.');

	}

	

	/**
	 * @return the imagen
	 */
	public Image getImagen() {
		return imagen;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return the notas
	 */
	public double[] getNotas() {
		return notas;
	}

	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

}
