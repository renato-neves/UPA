package daw.upa.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import daw.upa.dao.DAO;
import daw.upa.modelo.Medico;

@SessionScoped
@ManagedBean
public class MedicoBean {
	private Medico medico = new Medico();
	private List<Medico> medicos = new DAO<Medico>(Medico.class).getLista();
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public void grava() {
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		if (medico.getId() == null) {
			dao.adicionar(medico);
		}
		else
			dao.alterar(medico);
		
		this.medico = new Medico();
		this.medicos = dao.getLista();
	}
	
	public List<Medico> getMedicos() {
		if (medicos == null) {
			medicos = new DAO<Medico>(Medico.class).getLista();
		}
		return medicos;
	}
	
	public void remove(Medico medico) {
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		dao.remover(medico);
		this.medicos = dao.getLista();
	}
	
	public void cancela() {
		this.medico = new Medico();
	}
}
