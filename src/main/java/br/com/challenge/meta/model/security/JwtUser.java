package br.com.challenge.meta.model.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

/**
 * Class that implements UserDetails from SpringFramework Security Core
 * for authentication purposes.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public class JwtUser implements UserDetails {

	private static final long serialVersionUID = -8328911063439191378L;

	private UUID id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUser(UUID id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public JwtUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * @see UserDetails#getAuthorities()
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * @see UserDetails#getPassword()
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 * @see UserDetails#getUsername()
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * @see UserDetails#isAccountNonExpired()
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * @see UserDetails#isAccountNonLocked()
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * @see UserDetails#isCredentialsNonExpired()
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * @see UserDetails#isEnabled()
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * Method to get the Id from an JwtUser
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @return Long - Id
	 */
	public UUID getId() {
		return id;
	}

}
