package rbn.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import rbn.edu.enums.TipoAutorizacaoUsuario;

@Entity
@Table(name = "USN_USUARIO_NIVEL", catalog = "projeto_psc")
public class UsuarioNivelVO implements GrantedAuthority {

    public static final String USN_NIVEL = "USN_NIVEL";
    public static final String PK = "USN_ID";
    private static final long serialVersionUID = -4600840153957593563L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = PK, unique = true, nullable = false)
    private Long usuarioNivelId;

    @ManyToOne
    @JoinColumn(name = UsuarioVO.USU_ID, nullable = false)
    private UsuarioVO usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = USN_NIVEL, nullable = false, length = 10)
    private TipoAutorizacaoUsuario nivel;

    public UsuarioNivelVO(TipoAutorizacaoUsuario nivel, UsuarioVO usuario) {
	this.nivel = nivel;
	this.usuario = usuario;
    }

    public UsuarioNivelVO() {
    }

    public Long getUsuarioNivelId() {
	return usuarioNivelId;
    }

    public void setUsuarioNivelId(Long usuarioNivelId) {
	this.usuarioNivelId = usuarioNivelId;
    }

    public Long getUsuarioId() {
	return usuarioNivelId;
    }

    public void setUsuarioId(Long usuarioId) {
	this.usuarioNivelId = usuarioId;
    }

    public UsuarioVO getUsuario() {
	return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
	this.usuario = usuario;
    }

    public TipoAutorizacaoUsuario getNivel() {
	return nivel;
    }

    public void setNivel(TipoAutorizacaoUsuario nivel) {
	this.nivel = nivel;
    }

    @Override
    public String getAuthority() {
	return nivel.toString();
    }

}