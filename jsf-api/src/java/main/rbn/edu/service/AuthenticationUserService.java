package rbn.edu.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rbn.edu.dao.UserDAO;
import rbn.edu.dao.UserLevelDAO;
import rbn.edu.enums.UserAuthorizationType;
import rbn.edu.model.User;
import rbn.edu.model.UserLevel;

@Service("userDetailsService")
public class AuthenticationUserService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserLevelDAO userLevelDAO;

    public boolean isUsuarioLogado() {
	String login = null;
	SecurityContext context = SecurityContextHolder.getContext();
	Authentication authentication = context.getAuthentication();
	try {
	    login = (String) authentication.getPrincipal();
	} catch (ClassCastException e) {
	    login = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
	}
	return login.equals("anonymousUser") ? false : true;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

	User appUser = userDAO.findUserByLogin(login);
	if (appUser == null && login.equals("adm")) {
	    addAdmUser();
	    appUser = userDAO.findUserByLogin(login);
	}

	List<GrantedAuthority> authorities = buildUserAuthority(appUser.getUserLevels());

	return buildUserForAuthentication(appUser, authorities);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
	    List<GrantedAuthority> authorities) {
	return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
		user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserLevel> usuarioNiveis) {

	Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

	// Build user's authorities
	for (UserLevel usuarioNivel : usuarioNiveis) {
	    setAuths.add(new SimpleGrantedAuthority(usuarioNivel.getAuthority()));
	}

	List<GrantedAuthority> lista = new ArrayList<GrantedAuthority>(setAuths);

	return lista;
    }

    @Transactional
    public void addAdmUser() {
	User user = new User();
	user.setEnabled(true);
	user.setLogin("adm");
	user.setPassword(new BCryptPasswordEncoder().encode("adm"));

	userDAO.add(user);

	for (UserAuthorizationType auth : UserAuthorizationType.getValues()) {
	    userLevelDAO.add(new UserLevel(auth, user));
	}

    }

}
