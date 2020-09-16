package pe.edu.upc.donacion.models.entities;

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

@Entity
@Table(name = "donantes")
public class Donante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "contraseña", nullable = false)
	private String contraseña;
	
	@Column(name = "nombres_apellidos", length = 50, nullable = false)
	private String nombresApellidos;
	
	@Column(name = "numero_documento", length = 12, unique = true, nullable = false)
	private String numeroDocumento;
	
	@Column(name = "fecha_nacimiento", length = 10, nullable = false) //DD-MM-AAAA
	private String fechaNacimiento;
	
	@Column(name = "direccion", length = 30, nullable = false)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "tipoSangre_id")
	private TipoSangre tipoSangre;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@OneToMany(mappedBy = "donante")
	private List<RegistroDonacion> registroDonaciones;
	
	@OneToMany(mappedBy = "donante")
	private List<FichaMedica> fichasMedica;
	
	@OneToMany(mappedBy = "donante")
	private List<Cita> citas;
}
