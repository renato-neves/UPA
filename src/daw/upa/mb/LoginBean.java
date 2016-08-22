package daw.upa.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import daw.upa.dao.UsuarioDAO;
import daw.upa.modelo.Usuario;

// Permite que os dados do usuário sejam mantidos enquanto ele estiver logado.
@SessionScoped
@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String efetuaLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			return "index?faces-redirect=true";
		}
		else {
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isUsuarioLogado() {
		return usuario.getLogin() != null;
	}
	
	public String logout() {
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
}
