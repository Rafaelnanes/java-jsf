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

import rbn.edu.enums.UserAuthorizationType;

@Entity
@Table(name = "USL_USER_LEVEL")
public class UserLevel implements GrantedAuthority {

    public static final String USN_LEVEL = "USL_LEVEL";
    public static final String PK = "USL_ID";
    private static final long serialVersionUID = -4600840153957593563L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = PK, unique = true, nullable = false)
    private Long userLevelId;

    @ManyToOne
    @JoinColumn(name = User.USR_ID, nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = USN_LEVEL, nullable = false, length = 20)
    private UserAuthorizationType level;

    public UserLevel(UserAuthorizationType level, User usuario) {
	this.level = level;
	this.user = usuario;
    }

    public UserLevel() {
    }

    @Override
    public String getAuthority() {
	return level.toString();
    }

}