package pe.edu.upc.donacion.models.entities;

import java.util.ArrayList;
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
	
	public Donante() {
		registroDonaciones = new ArrayList<RegistroDonacion>();
		fichasMedica = new ArrayList<FichaMedica>();
		citas = new ArrayList<Cita>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TipoSangre getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(TipoSangre tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<RegistroDonacion> getRegistroDonaciones() {
		return registroDonaciones;
	}

	public void setRegistroDonaciones(List<RegistroDonacion> registroDonaciones) {
		this.registroDonaciones = registroDonaciones;
	}

	public List<FichaMedica> getFichasMedica() {
		return fichasMedica;
	}

	public void setFichasMedica(List<FichaMedica> fichasMedica) {
		this.fichasMedica = fichasMedica;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
}
