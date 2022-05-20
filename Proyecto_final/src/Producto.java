import java.io.Serializable;

public class Producto implements Serializable{
	
	protected String nombre;
	protected int id;
	protected double precio;
	protected int cantidad;
	protected String categoria;
	
	public Producto(String nombre,int id, double precio, int cantidad, String categoria) {
		this.nombre=nombre;
		this.cantidad=id;
		this.precio=precio;
		this.cantidad=cantidad;
		this.categoria=categoria;
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", id=" + id + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", categoria=" + categoria + "]";
	}
	
	

}
