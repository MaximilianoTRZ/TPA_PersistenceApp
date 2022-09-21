package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "denominacion")
	@NonNull private String denominacion;
	
	
	@ManyToMany(mappedBy = "categorias")
	private List<Articulo> articulos = new ArrayList<Articulo>();
	
	
	
	//CON LOMBOK ESTO YA NO ES NECESARIO
	
//	public Categoria() {
//	
//	}
//	
//	public Categoria(String denominacion) {
//		this.denominacion = denominacion;
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
//	public String getDenominacion() {
//		return denominacion;
//	}
//
//	public void setDenominacion(String denominacion) {
//		this.denominacion = denominacion;
//	}
//
//	public List<Articulo> getArticulos() {
//		return articulos;
//	}
//
//	public void setArticulos(List<Articulo> articulos) {
//		this.articulos = articulos;
//	}
	
	
	
	

}
