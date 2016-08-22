package daw.upa.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import daw.upa.dao.DAO;
import daw.upa.modelo.Atendimento;
import daw.upa.modelo.Medico;
import daw.upa.modelo.Paciente;

@ManagedBean
public class AtendimentoBean {
	private Atendimento atendimento = new Atendimento();
	private Medico medico = new Medico();
	private Paciente paciente = new Paciente();
	private List<Atendimento> atendimentos = new DAO<Atendimento>(Atendimento.class).getLista();
	private Long idMedico;
	private Long idPaciente;
	
	public Atendimento getAtendimento() {
		return atendimento;
	}
	
	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public void grava() {
		DAO<Atendimento> dao = new DAO<Atendimento>(Atendimento.class);
		System.out.println();
		if (atendimento.getId() == null) {
			DAO<Medico> daoM = new DAO<Medico>(Medico.class);
			DAO<Paciente> daoP = new DAO<Paciente>(Paciente.class);
			medico = daoM.idPesquisa(idMedico);
			paciente = daoP.idPesquisa(idPaciente);
			atendimento.setMedico(medico);
			atendimento.setPaciente(paciente);
			dao.adicionar(atendimento);
		}
		else
			dao.alterar(atendimento);
		
		this.atendimento = new Atendimento();
		this.atendimentos = dao.getLista();
	}
	
	public void remove(Atendimento atendimento) {
		DAO<Atendimento> dao = new DAO<Atendimento>(Atendimento.class);
		dao.remover(atendimento);
		this.atendimentos = dao.getLista();
	}
	
	public List<Atendimento> getAtendimentos() {
		if (atendimentos == null) {
			atendimentos = new DAO<Atendimento>(Atendimento.class).getLista();
		}
		return atendimentos;
	}
	
	public void cancela() {
		this.atendimento = new Atendimento();
	}
}
