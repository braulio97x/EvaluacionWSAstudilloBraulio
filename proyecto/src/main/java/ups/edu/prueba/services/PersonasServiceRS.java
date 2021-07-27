package ups.edu.prueba.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ups.edu.prueba.business.ClientesON;
import ups.edu.prueba.modelo.Cliente;
import ups.edu.prueba.services.modelo.ClienteTemp;




@Path("personas")
public class PersonasServiceRS {
	@Inject
	private ClientesON clientesON;

	@PUT
	@Path("/registrar")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String registrarCliente(Cliente cliente) {
		try {
			clientesON.insertCliente(cliente);
			return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
	}

	

	@GET
	@Path("clientes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteTemp> getClientes() {
		List<Cliente> listado = clientesON.getClientes();
		List<ClienteTemp> clientes=new ArrayList<ClienteTemp>();
		for (Cliente c : listado) {
			ClienteTemp ct = new ClienteTemp();
			ct.setCedula(c.getCedula());
			ct.setNombre(c.getNombre());
			ct.setApellido(c.getApellido());
			ct.setNombreCompleto(c.getApellido()+ " " + c.getNombre());
			clientes.add(ct);
		}
		return clientes;
	}
}
