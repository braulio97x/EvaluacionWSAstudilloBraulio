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
import ups.edu.prueba.business.CreditosON;
import ups.edu.prueba.modelo.Cliente;
import ups.edu.prueba.modelo.Credito;
import ups.edu.prueba.services.modelo.ClienteTemp;
import ups.edu.prueba.services.modelo.CreditoTemp;

@Path("creditos")
public class CreditosServiceRS {
	@Inject
	private CreditosON creditosON;

	@PUT
	@Path("/registrar")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String registrarCredito(Credito credito) {
		try {
			creditosON.insertCredito(credito);
			return "OK";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
	}

	
	@POST
	@Path("/solicitarCredito/{monto}/{numMeses}/{fecha1raCuota}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public int sumar2(@PathParam("monto") int monto, @PathParam("numMeses") int numMeses, @PathParam("fecha1raCuota") int fecha1raCuota) {
		return monto + numMeses;
	}

	@GET
	@Path("creditos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CreditoTemp> getCreditos() {
		List<Credito> listado = creditosON.getCreditos();
		List<CreditoTemp> creditos=new ArrayList<CreditoTemp>();
		for (Credito c : listado) {
			CreditoTemp ct = new CreditoTemp();
			ct.setIdCred(c.getIdCred());
			ct.setMonto(c.getMonto());
			ct.setNumMeses(c.getNumMeses());
			//ct.setFechaPrimerPago(c.getFechaPrimerPago());
			creditos.add(ct);
		}
		return creditos;
	}
}
