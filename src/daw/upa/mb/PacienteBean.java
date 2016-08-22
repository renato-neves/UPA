package daw.upa.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import daw.upa.dao.DAO;
import daw.upa.modelo.Paciente;

@SessionScoped
@ManagedBean
public class PacienteBean {
	private Paciente paciente = new Paciente();
	private List<Paciente> pacientes = new DAO<Paciente>(Paciente.class).getLista();
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void grava() {
		DAO<Paciente> dao = new DAO<Paciente>(Paciente.class);
		if (paciente.getId() == null) {
			validarCpf(paciente.getCpf());
			dao.adicionar(paciente);
			
		}
		else
			dao.alterar(paciente);
		
		this.paciente = new Paciente();
		this.pacientes = dao.getLista();
	}
	
	public List<Paciente> getPacientes() {
		if (pacientes == null) {
			pacientes = new DAO<Paciente>(Paciente.class).getLista();
		}
		return pacientes;
	}
	
	public void cancela() {
		this.paciente = new Paciente();
	}
	
	public void remove(Paciente paciente) {
		DAO<Paciente> dao = new DAO<Paciente>(Paciente.class);
		dao.remover(paciente);
		this.pacientes = dao.getLista();
	}
	
	private boolean validarCpf(String cpf) {
		  if (cpf.equals("11111111111") || cpf.equals("22222222222")
			       || cpf.equals("33333333333")
			       || cpf.equals("44444444444")
			       || cpf.equals("55555555555")
			       || cpf.equals("66666666666")
			       || cpf.equals("77777777777")
			       || cpf.equals("88888888888")
			       || cpf.equals("99999999999")) {

			              return true;
			         }

			     return false;
	}
}
