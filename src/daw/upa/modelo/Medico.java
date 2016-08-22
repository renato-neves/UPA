package daw.upa.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Medico {
	@Id
	@SequenceGenerator (name = "medico_id", sequenceName = "medico_seq", allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "medico_id")
	private Long id;
	
	private String crm; //00000000-0/UF
	
	@NotEmpty(message="O campo nome n�o deve ser vazio!")
	private String nome;
	
	@NotEmpty(message="O campo telefone n�o deve ser vazio!")
	private String telefone;
	
	@NotEmpty(message="O campo �rea n�o deve ser vazio!")
	private String area;
	
	private Double salario;
	
	@OneToMany(mappedBy="medico", cascade=CascadeType.ALL)
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
