package rbn.edu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USU_USUARIO", catalog = "projeto_psc")
public class UsuarioVO {

    public static final String USU_ID = "USU_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = USU_ID)
    private Integer id;

    @Column(name = "USU_LOGIN", nullable = false, length = 20, unique = true)
    private String login;

    @Column(name = "USU_SENHA", nullable = false, length = 60)
    private String senha;

    @Column(name = "USU_HABILITADO", nullable = false)
    private boolean habilitado;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private Set<UsuarioNivelVO> usuarioNiveis = new HashSet<UsuarioNivelVO>();

    public UsuarioVO() {
    }

    public UsuarioVO(String login, String senha, Boolean habilitado) {
	this.login = login;
	this.senha = senha;
	this.habilitado = habilitado;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public boolean isHabilitado() {
	return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
	this.habilitado = habilitado;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Set<UsuarioNivelVO> getUsuarioNiveis() {
	return usuarioNiveis;
    }

    public void setUsuarioNiveis(Set<UsuarioNivelVO> usuarioNiveis) {
	this.usuarioNiveis = usuarioNiveis;
    }

    public String getNiveis() {
	String niveis = "";
	for (UsuarioNivelVO nivel : this.usuarioNiveis) {
	    niveis += nivel.getNivel().toString() + ",";
	}
	return niveis.substring(0, niveis.length() - 1);
    }

    @Override
    public boolean equals(Object obj) {
	UsuarioVO usuario = (UsuarioVO) obj;
	if (this.id.intValue() == usuario.getId().intValue()) {
	    return true;
	}
	return false;
    }

}