package pe.edu.upc.donacion.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "unidades_sangre")
public class UnidadSangre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fecha_vencimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date FechaVencimiento;
	
	@Column(name = "numero_lote", unique = true,  nullable = false)
	private String NumeroLote;
	
	@OneToOne
	@JoinColumn(name = "donacion_id")
	private Donacion donacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaVencimiento() {
		return FechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}

	public String getNumeroLote() {
		return NumeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		NumeroLote = numeroLote;
	}

	public Donacion getDonacion() {
		return donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}
}