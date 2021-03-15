package br.com.challenge.meta.service.security.impl;

import br.com.challenge.meta.model.security.JwtUserFactory;
import br.com.challenge.meta.model.user.User;
import br.com.challenge.meta.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class that implements UserDetailsService interface which loads user-specific data.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@Service
@RequiredArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	/**
	 * @see UserDetailsService#loadUserByUsername(String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userService.findByEmail(username);

		if (user.isPresent()) {
			return JwtUserFactory.create(user.get());
		}

		throw new UsernameNotFoundException("User/Email not found.");
	}

}
