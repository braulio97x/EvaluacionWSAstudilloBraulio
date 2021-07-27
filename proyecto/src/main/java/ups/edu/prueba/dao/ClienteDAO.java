package ups.edu.prueba.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.prueba.modelo.Cliente;

@Stateless
public class ClienteDAO {
@PersistenceContext
private EntityManager em;

public void insert(Cliente cliente) {
	em.persist(cliente);
}

public void update(Cliente cliente) {
	em.merge(cliente);
}

public Cliente read(String cedula) {
	Cliente p = em.find(Cliente.class, cedula);
	return p;
}

public void delete(String cedula) {
	Cliente p = em.find(Cliente.class, cedula);
	em.remove(p);
}

public List<Cliente> getClientes(String nombre){
	
	String jpql2="SELECT p FROM Cliente p WHERE nombre LIKE ?1";
	
	nombre= nombre+"%";
	Query query= em.createQuery(jpql2, Cliente.class);
	query.setParameter(1, nombre);
	
	List<Cliente> clientes=query.getResultList();
	return clientes;
	
}
}
