package br.com.challenge.meta.service.user;

import br.com.challenge.meta.dto.model.user.UserAccountDTO;
import br.com.challenge.meta.enumeration.AccountTypeEnum;
import br.com.challenge.meta.enumeration.RoleEnum;
import br.com.challenge.meta.model.account.Account;
import br.com.challenge.meta.model.user.User;
import br.com.challenge.meta.model.user.UserAccount;
import br.com.challenge.meta.repository.user.UserAccountRepository;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Class that implements tests of the UserAccountService features.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class })
public class UserAccountServiceTest {

	static final String EMAIL = "email@test.com";
	static final String ACCOUNT_NUMBER = "1234560";

	@Autowired
	private UserAccountService userAccountService;

	@MockBean
	private UserAccountRepository userAccRepository;

	/**
	 * Method to test the creation of an UserAccount.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Test
	@Order(1)
	public void testSave() {

		BDDMockito.given(userAccRepository.save(Mockito.any(UserAccount.class)))
			.willReturn(getMockUserAccount());
		UserAccountDTO userAccount = userAccountService.save(new UserAccountDTO());

		assertNotNull(userAccount);
	}

	/**
	 * Method that fill a mock of an Account to use as return in the tests.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @return <code>Account</code> object
	 */
	private Account getMockAccount() {
		return new Account(UUID.randomUUID(), ACCOUNT_NUMBER, AccountTypeEnum.BASIC);
	}

	/**
	 * Method that fill a mock of an User to use as return in the tests.
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
	 * Method that fill a mock of an UserAccount to use as return in the tests.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @return <code>UserAccount</code> object
	 */
	private UserAccount getMockUserAccount() {
		return new UserAccount(null, getMockUser(), getMockAccount());
	}

}
