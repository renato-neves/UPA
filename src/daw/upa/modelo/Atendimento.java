package daw.upa.modelo;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Atendimento {
	@Id
	@SequenceGenerator (name = "atendimento_id", sequenceName = "atendimento_seq", allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "atendimento_id")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataConsulta = Calendar.getInstance();
	
	@NotEmpty(message="O campo receita não deve ser vazio!")
	private String receita;
	
	@NotEmpty(message="O campo recomendações não deve ser vazio!")
	private String recomendacoes;
	
	@NotEmpty(message="O campo enfermeiro não deve ser vazio!")
	private String enfermeiro;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Medico medico;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Paciente paciente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return dataConsulta;
	}

	public void setData(Calendar data) {
		this.dataConsulta = data;
	}

	public String getReceita() {
		return receita;
	}

	public void setReceita(String receita) {
		this.receita = receita;
	}

	public String getRecomendacoes() {
		return recomendacoes;
	}

	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getEnfermeiro() {
		return enfermeiro;
	}

	public void setEnfermeiro(String enfermeiro) {
		this.enfermeiro = enfermeiro;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
