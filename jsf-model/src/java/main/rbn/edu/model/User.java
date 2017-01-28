package rbn.edu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USR_USER")
@AttributeOverrides({ @AttributeOverride(name = AbstracEntity.PK, column = @Column(name = User.USR_ID)) })
public class User extends AbstracEntity<Long> {

    private static final long serialVersionUID = 1391921840247909984L;

    public static final String USR_ID = "USR_ID";

    @Column(name = "USR_LOGIN", nullable = false, length = 20, unique = true)
    private String login;

    @Column(name = "USR_PASSWORD", nullable = false, length = 60)
    private String password;

    @Column(name = "USR_ENABLE", nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserLevel> userLevels = new HashSet<UserLevel>();

    public User() {
    }

    public User(String login, String password, Boolean enabled) {
	this.login = login;
	this.password = password;
	this.enabled = enabled;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public Set<UserLevel> getUserLevels() {
	return userLevels;
    }

    public void setUserLevels(Set<UserLevel> userLevels) {
	this.userLevels = userLevels;
    }

    @Override
    public boolean equals(Object obj) {
	User user = (User) obj;
	if (this.id.intValue() == user.getId().intValue()) {
	    return true;
	}
	return false;
    }

}