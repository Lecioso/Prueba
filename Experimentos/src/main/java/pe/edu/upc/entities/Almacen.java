package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Almacen")
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlmacen")
	private int idAlmacen;

	@NotEmpty
	@Column(name = "nombreAlmacen")
	private String nombreAlmacen;

	@NotEmpty
	@Column(name = "descripcionAlmacen")
	private String descripcionAlmacen;

	@NotEmpty
	@Column(name = "direccionAlmacen")
	private String direccionAlmacen;

	public Almacen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Almacen(int idAlmacen, String nombreAlmacen, String descripcionAlmacen, String direccionAlmacen) {
		super();
		this.idAlmacen = idAlmacen;
		this.nombreAlmacen = nombreAlmacen;
		this.descripcionAlmacen = descripcionAlmacen;
		this.direccionAlmacen = direccionAlmacen;
	}

	public int getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(int idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getDescripcionAlmacen() {
		return descripcionAlmacen;
	}

	public void setDescripcionAlmacen(String descripcionAlmacen) {
		this.descripcionAlmacen = descripcionAlmacen;
	}

	public String getDireccionAlmacen() {
		return direccionAlmacen;
	}

	public void setDireccionAlmacen(String direccionAlmacen) {
		this.direccionAlmacen = direccionAlmacen;
	}

}
