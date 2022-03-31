package user.security.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import user.security.dto.Users;

public class SecurityUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SecurityUser(Users users) {
		super(users.getId(), users.getPassword(), AuthorityUtils.createAuthorityList(users.getRole().toString()));
	}
	
	/*
	 * public SecurityUser(Users users) { super(users.getId(),"{noop}"+
	 * users.getPassword(),
	 * AuthorityUtils.createAuthorityList(users.getRole().toString())); }
	  -->{noop}으로 암호화 하지 않음*/
}
