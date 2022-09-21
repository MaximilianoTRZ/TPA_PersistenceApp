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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;



@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	@NonNull private String nombre;
	
	@Column(name = "apellido")
	@NonNull private String apellido;
	
	@Column(name = "dni", unique = true)
	@NonNull private int dni;
	
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas = new ArrayList<Factura>();
	
	
	
	//CON LOMBOK ESTO YA NO ES NECESARIO
	
	
//	public Cliente() {}
//	public Cliente (String nombre,String apellido, int dni) {
//		this.apellido = apellido;
//		this.dni= dni;
//		this.nombre = nombre;
//	}
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
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//
//	public String getApellido() {
//		return apellido;
//	}
//	public Domicilio getDomicilio() {
//		return domicilio;
//	}
//	public void setDomicilio(Domicilio domicilio) {
//		this.domicilio = domicilio;
//	}
//	public void setApellido(String apellido) {
//		this.apellido = apellido;
//	}
//	public int getDni() {
//		return dni;
//	}
//	public void setDni(int dni) {
//		this.dni = dni;
//	}
	

}
