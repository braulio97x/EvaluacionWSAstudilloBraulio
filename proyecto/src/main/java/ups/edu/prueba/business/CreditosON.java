package ups.edu.prueba.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.prueba.dao.ClienteDAO;
import ups.edu.prueba.dao.CreditoDAO;
import ups.edu.prueba.modelo.Cliente;
import ups.edu.prueba.modelo.Credito;

@Stateless
public class CreditosON {
@Inject

private CreditoDAO daoCredito;

public void insertCredito(Credito credito) throws Exception {

	daoCredito.insert(credito);
}

public void updateCredito(Credito credito) throws Exception {

	daoCredito.update(credito);
}

public void deleteCredito(Credito credito) throws Exception {
	//int com = String.valueOf(credito.getIdCred());
	int com = credito.getIdCred();
	daoCredito.delete(com);
}

public List<Credito> getCreditos() {

	

	return daoCredito.getCreditos("%");
}

public Credito getCreditos(int idCred) {
	Credito p = daoCredito.read(idCred);
	return p;
}
}
