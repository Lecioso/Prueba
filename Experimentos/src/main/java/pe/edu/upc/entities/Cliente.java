package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private int idCliente;

	@Column(name = "dniCliente")
	private String dniCliente;

	@Column(name = "nombreCliente")
	private String nombreCliente;

	@Column(name = "apellidoCliente")
	private String apellidoCliente;

	@Column(name = "correoCliente")
	private String correoCliente;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, String dniCliente, String nombreCliente, String apellidoCliente,
			String correoCliente) {
		super();
		this.idCliente = idCliente;
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.correoCliente = correoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

}
