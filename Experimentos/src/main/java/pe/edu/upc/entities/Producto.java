package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto")
	private int idProducto;

	@Column(name = "nombreProducto")
	private String nombreProducto;

	@Column(name = "cantidadProducto")
	private Double cantidadProducto;

	@Column(name = "precioUnitProducto")
	private Double precioUnitProducto;

	@Transient
	private double precioProducto;

	@ManyToOne
	@JoinColumn(name = "idAlmacen")
	private Almacen almacen;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int idProducto, String nombreProducto, Double cantidadProducto, Double precioUnitProducto,
			double precioProducto, Almacen almacen, Cliente cliente) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioUnitProducto = precioUnitProducto;
		this.precioProducto = precioProducto;
		this.almacen = almacen;
		this.cliente = cliente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Double cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Double getPrecioUnitProducto() {
		return precioUnitProducto;
	}

	public void setPrecioUnitProducto(Double precioUnitProducto) {
		this.precioUnitProducto = precioUnitProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
