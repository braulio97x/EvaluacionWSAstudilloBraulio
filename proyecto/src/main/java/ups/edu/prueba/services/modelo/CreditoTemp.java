package ups.edu.prueba.services.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class CreditoTemp {

	private int idCred;
	private Double monto;
	private int numMeses;
	private Date fechaPrimerPago;

	public int getIdCred() {
		return idCred;
	}

	public void setIdCred(int idCred) {
		this.idCred = idCred;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public int getNumMeses() {
		return numMeses;
	}

	public void setNumMeses(int numMeses) {
		this.numMeses = numMeses;
	}

	public Date getFechaPrimerPago() {
		return fechaPrimerPago;
	}

	public void setFechaPrimerPago(Date fechaPrimerPago) {
		this.fechaPrimerPago = fechaPrimerPago;
	}

}
