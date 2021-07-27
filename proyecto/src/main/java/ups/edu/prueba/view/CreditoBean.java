package ups.edu.prueba.view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.prueba.business.ClientesON;
import ups.edu.prueba.business.CreditosON;
import ups.edu.prueba.modelo.Cliente;
import ups.edu.prueba.modelo.Credito;

@Named
@RequestScoped
public class CreditoBean {
	
	private Credito newCredito = new Credito();
	private List<Credito> creditos;
	@Inject
	private CreditosON creditosON;

	public Credito getNewCredito() {
		return newCredito;
	}

	public void setNewCredito(Credito newCredito) {
		this.newCredito = newCredito;
	}
	
	
	public String guardarCredito() {

		try {
			creditosON.insertCredito(newCredito);
			System.out.println("Inserto credito");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	public List<Credito> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}
	
	
	

}
