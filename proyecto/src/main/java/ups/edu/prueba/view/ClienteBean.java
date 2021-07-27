package ups.edu.prueba.view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.prueba.business.ClientesON;
import ups.edu.prueba.modelo.Cliente;

@Named
@RequestScoped
public class ClienteBean {
	
	private Cliente newCliente = new Cliente();
	private List<Cliente> clientes;
	@Inject
	private ClientesON clientesON;

	public Cliente getNewCliente() {
		return newCliente;
	}

	public void setNewCliente(Cliente newCliente) {
		this.newCliente = newCliente;
	}
	
	
	public String guardarCliente() {

		try {
			clientesON.insertCliente(newCliente);
			System.out.println("Inserto cliente");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	

}
