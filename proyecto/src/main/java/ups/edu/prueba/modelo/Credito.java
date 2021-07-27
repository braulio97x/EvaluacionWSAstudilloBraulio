package ups.edu.prueba.modelo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credito {
	@Id
	private int idCred;
	@Column(length = 20, name = "idCredito")
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
