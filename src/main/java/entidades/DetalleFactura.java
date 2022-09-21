package entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "detalle_factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleFactura implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cantidad")
	@NonNull private int cantidad;
	
	
	@Column(name = "subtotal")
	@NonNull private int subtotal;
	
	//bidireccional
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_factura")
	private Factura factura;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_articulo")
	private Articulo articulo;
	
	
	//CON LOMBOK ESTO YA NO ES NECESARIO
	
//	public DetalleFactura() {
//		
//	}
//	
//	public DetalleFactura(int cantidad, int subtotal) {
//		this.cantidad = cantidad;
//		this.subtotal = subtotal;
//	}
//	
//	public DetalleFactura(int cantidad, int subtotal, Factura factura) {
//		this.cantidad = cantidad;
//		this.subtotal = subtotal;
//		this.factura = factura;
//	}
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
//	public int getSubtotal() {
//		return subtotal;
//	}
//
//	public void setSubtotal(int subtotal) {
//		this.subtotal = subtotal;
//	}
//
//	public Factura getFactura() {
//		return factura;
//	}
//
//	public void setFactura(Factura factura) {
//		this.factura = factura;
//	}
//
//	public Articulo getArticulo() {
//		return articulo;
//	}
//
//	public void setArticulo(Articulo articulo) {
//		this.articulo = articulo;
//	}

	
	
}
