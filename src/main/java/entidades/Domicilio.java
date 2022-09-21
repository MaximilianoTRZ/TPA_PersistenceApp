package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
@Table(name = "domicilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_calle")
	@NonNull private String nombreCalle;
	
	@Column(name = "numero")
	@NonNull private int numero;
	
	@OneToOne(mappedBy="domicilio")
	private Cliente cliente;
	
	
	
	//CON LOMBOK ESTO YA NO ES NECESARIO
	
	
//	public Domicilio() {
//		
//	}
//	
//	public Domicilio (String nombreCalle, int numero) {
//		this.nombreCalle = nombreCalle;
//		this.numero = numero;
//	}
//	
//	public Domicilio (String nombreCalle, int numero, Cliente cliente) {
//		this.nombreCalle = nombreCalle;
//		this.numero = numero;
//		this.cliente = cliente;
//	}
//
//
//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//
//	public String getNombreCalle() {
//		return nombreCalle;
//	}
//
//
//	public void setNombreCalle(String nombreCalle) {
//		this.nombreCalle = nombreCalle;
//	}
//
//
//	public int getNumero() {
//		return numero;
//	}
//
//
//	public void setNumero(int numero) {
//		this.numero = numero;
//	}
//
//
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
	
	
}
