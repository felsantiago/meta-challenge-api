package br.com.challenge.meta.model.security;

import br.com.challenge.meta.enumeration.RoleEnum;
import br.com.challenge.meta.model.user.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements a factory to create a JwtUser.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUserFactory {

	/**
	 * Method to create a JwtUser.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param user
	 * @return JwtUser object
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), createGrantedAuthorities(user.getRole()));
	}

	/**
	 * Method to grant authorities to a JwtUser.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @param role
	 * @return List<GrantedAuthority>
	 */
	private static List<GrantedAuthority> createGrantedAuthorities(RoleEnum role) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));
		return authorities;
	}

}
