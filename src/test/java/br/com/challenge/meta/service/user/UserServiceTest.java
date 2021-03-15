package br.com.challenge.meta.service.user;

import br.com.challenge.meta.dto.model.user.UserDTO;
import br.com.challenge.meta.enumeration.RoleEnum;
import br.com.challenge.meta.model.user.User;
import br.com.challenge.meta.repository.user.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class that implements tests of the UserService features.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class })
public class UserServiceTest {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	static final String EMAIL = "email@test.com";

	/**
	 * Method to test the creation of an User.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Test
	@Order(1)
	public void testSave() {
		BDDMockito.given(repository.save(Mockito.any(User.class)))
			.willReturn(getMockUser());
		UserDTO response = service.save(new UserDTO());

		assertNotNull(response);
	}

	/**
	 * Method that test the service that search for an User by the email.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Test
	@Order(2)
	public void testFindByEmail(){

		BDDMockito.given(repository.findByEmail(Mockito.anyString()))
			.willReturn(Optional.of(new User()));

		Optional<User> response = service.findByEmail(EMAIL);
		assertTrue(response.isPresent());
	}

	/**
	 * Method that fill a mock of a User to use as return in the tests.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @return <code>User</code> object
	 */
	private User getMockUser() {
		return new User(UUID.randomUUID(), "Test User", "123", EMAIL, RoleEnum.ROLE_ADMIN);
	}

	/**
	 * Method to remove all User test data.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@AfterAll
	private void tearDown() {
		repository.deleteAll();
	}

}
