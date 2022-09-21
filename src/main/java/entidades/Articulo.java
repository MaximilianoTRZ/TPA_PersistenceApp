package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "articulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Articulo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cantidad")
	@NonNull private int cantidad;
	
	@Column(name= "denominacion")
	@NonNull private String denominacion;
	
	@Column(name = "precio")
	@NonNull private int precio;

	@OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
//	@NotAudited //Se coloca cuando no queremos auditar la relacion.
	private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name= "articulo_categoria",
			joinColumns= @JoinColumn(name = "articulo_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	

	
	//CON LOMBOK ESTO YA NO ES NECESARIO
	
//	public Articulo() {}
//	
//	public Articulo(int cantidad, String denominacion, int precio) {
//		this.cantidad = cantidad;
//		this.denominacion = denominacion;
//		this.precio = precio;
//	}
//
//
//
//
//
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public int getCantidad() {
//		return cantidad;
//	}
//
//	public void setCantidad(int cantidad) {
//		this.cantidad = cantidad;
//	}
//
//	public String getDenominacion() {
//		return denominacion;
//	}
//
//	public void setDenominacion(String denominacion) {
//		this.denominacion = denominacion;
//	}
//
//	public int getPrecio() {
//		return precio;
//	}
//
//	public void setPrecio(int precio) {
//		this.precio = precio;
//	}
//
//	public List<DetalleFactura> getDetalle() {
//		return detalle;
//	}
//
//	public void setDetalle(List<DetalleFactura> detalle) {
//		this.detalle = detalle;
//	}
//
//	public List<Categoria> getCategorias() {
//		return categorias;
//	}
//
//	public void setCategorias(List<Categoria> categorias) {
//		this.categorias = categorias;
//	}
	
	
	

}
