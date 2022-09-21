package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceApp {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PercistenceAppPU");
		EntityManager em = emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			
			//Cliente cliente = new Cliente("Maximiliano", "Rivero Zuin", 41230862);
			//Domicilio domicilio = new Domicilio("Mendoza",5050);
			//cliente.setDomicilio(domicilio);
			
			//em.persist(cliente);
			
			//Domicilio dom = em.find(Domicilio.class, 1L);
			//cliente = em.find(Cliente.class, 1L);
			
			//System.out.println("Cliente de domicilio: " + dom.getCliente().getDni());
			//System.out.println("Domicilio de cliente: " + cliente.getDomicilio().getNombreCalle());
			
			Factura factura1 = new Factura();
			factura1.setNumero(12);
			factura1.setFecha("20/09/2022");
			
			Domicilio dom = new Domicilio("Capital", 5056);
			Cliente cliente = new Cliente("Maximiliano", "Rivero Zuin", 55165489);
			
			cliente.setDomicilio(dom);
			dom.setCliente(cliente);
			
			em.persist(cliente);
			
			factura1.setCliente(cliente);
			
			Categoria perecederos = new Categoria("Perecederos");
			Categoria lacteos = new Categoria("Lacteos");
			Categoria limpieza = new Categoria ("Limpieza");
			
			Articulo articulo1 = new Articulo(200,"chocolate", 20);
			Articulo articulo2 = new Articulo(300,"mister musculo",80);
			
			articulo1.getCategorias().add(perecederos);
			articulo1.getCategorias().add(lacteos);
			
			lacteos.getArticulos().add(articulo1);
			perecederos.getArticulos().add(articulo1);
			
			articulo2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(articulo2);
			
			DetalleFactura det1 = new DetalleFactura();
			
			det1.setArticulo(articulo1);
			det1.setCantidad(2);
			det1.setSubtotal(40);
			
			articulo1.getDetalle().add(det1);
			factura1.getDetalles().add(det1);
			det1.setFactura(factura1);
			
			DetalleFactura det2 = new DetalleFactura();
			
			det2.setArticulo(articulo2);
			det2.setCantidad(1);
			det2.setSubtotal(80);
			
			articulo2.getDetalle().add(det2);
			factura1.getDetalles().add(det2);
			det2.setFactura(factura1);
			
			
			
			factura1.setTotal(120);
			
			 em.persist(factura1);
			
			
			em.flush();
			em.getTransaction().commit();
			
		}catch(Exception e) {
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
	}
}
