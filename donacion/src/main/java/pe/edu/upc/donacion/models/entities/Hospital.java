package pe.edu.upc.donacion.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hospitales")
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 25, nullable = false)
	private String nombre;
	
	@Column(name = "direccion", length = 25, nullable = false)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@Column(name = "numero_telefono", length = 9, nullable = false)
	private String numeroTelefono;
	
	@Column(name = "horario_apartura")
	@Temporal(TemporalType.TIME)
	private Date horarioApertura;
	
	@Column(name = "horario_cierre")
	@Temporal(TemporalType.TIME)
	private Date horarioCierre;
	
	@OneToMany(mappedBy = "hospital")
	private List<Cita> citas;
}