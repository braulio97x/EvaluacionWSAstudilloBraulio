package ups.edu.prueba.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.prueba.modelo.Cliente;
import ups.edu.prueba.modelo.Credito;

@Stateless
public class CreditoDAO {
@PersistenceContext
private EntityManager em;

public void insert(Credito credito) {
	em.persist(credito);
}

public void update(Credito credito) {
	em.merge(credito);
}

public Credito read(int idCredito) {
	Credito p = em.find(Credito.class, idCredito);
	return p;
}

public void delete(int idCredito) {
	Credito p = em.find(Credito.class, idCredito);
	em.remove(p);
}

public List<Credito> getCreditos(String idCredito){
	
	String jpql2="SELECT p FROM Creditos p WHERE nombre LIKE ?1";
	
	idCredito= idCredito+"%";
	Query query= em.createQuery(jpql2, Cliente.class);
	query.setParameter(1, idCredito);
	
	List<Credito> creditos=query.getResultList();
	return creditos;
	
}
}
