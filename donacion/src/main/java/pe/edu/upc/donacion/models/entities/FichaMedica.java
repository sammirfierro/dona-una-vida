package pe.edu.upc.donacion.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fichas_medicas")
public class FichaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "donante_id")
	private Donante donante;
	
	@Column(name = "ets", nullable = false)
	private Boolean ets;
	
	@Column(name = "hemoglobina", nullable = false)
	private Float hemoglobina;
	
	@Column(name = "estado", nullable = false)
	private Boolean estado;
}