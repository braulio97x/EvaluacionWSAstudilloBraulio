package ups.edu.prueba.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ups.edu.prueba.dao.ClienteDAO;
import ups.edu.prueba.modelo.Cliente;

@Stateless
public class ClientesON {
@Inject

private ClienteDAO daoCliente;

public void insertCliente(Cliente cliente) throws Exception {

	daoCliente.insert(cliente);
}

public void updateCliente(Cliente cliente) throws Exception {

	daoCliente.update(cliente);
}

public void deleteCliente(Cliente cliente) throws Exception {
	String com = String.valueOf(cliente.getCedula());
	daoCliente.delete(com);
}

public List<Cliente> getClientes() {

	

	return daoCliente.getClientes("%");
}

public Cliente getCliente(String cedula) {
	Cliente p = daoCliente.read(cedula);
	return p;
}
}
