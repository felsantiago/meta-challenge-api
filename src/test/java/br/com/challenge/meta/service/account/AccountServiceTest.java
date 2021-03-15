package br.com.challenge.meta.service.account;

import br.com.challenge.meta.dto.model.account.AccountDTO;
import br.com.challenge.meta.enumeration.AccountTypeEnum;
import br.com.challenge.meta.exception.AccountNotFoundException;
import br.com.challenge.meta.model.account.Account;
import br.com.challenge.meta.repository.account.AccountRepository;
import br.com.challenge.meta.service.account.impl.AccountServiceImpl;
import br.com.challenge.meta.service.mapper.account.AccountMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
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
 * Class that implements tests of the AccountService features.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class })
public class AccountServiceTest {

	@MockBean
	private AccountService service;

	@MockBean
	private AccountRepository repository;

	@MockBean
	private AccountMapper mapper;

	static final String ACCOUNT_NUMBER = "123456";

	@BeforeEach
	public void setUp() {
		this.service = new AccountServiceImpl(mapper, repository);
	}

	/**
	 * Method to test the creation of an Account.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Test
	@Order(1)
	public void testSave() {
		BDDMockito.given(repository.save(Mockito.any(Account.class)))
			.willReturn(getMockAccount());
		AccountDTO response = service.save(new AccountDTO());

		assertNotNull(response);
	}

	/**
	 * Method that test the service that search for an Account by the account
	 * number.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@Test
	@Order(2)
	public void testFindByAccountNumber() throws AccountNotFoundException {

		BDDMockito.given(repository.findByAccountNumber(Mockito.anyString()))
			.willReturn(Optional.of(new Account()));

		Optional<AccountDTO> response = service.findByAccountNumber(ACCOUNT_NUMBER);
		assertTrue(response.isPresent());
	}

	/**
	 * Method to remove all Account test data.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 */
	@AfterAll
	private void tearDown() {
		repository.deleteAll();
	}

	/**
	 * Method that fill a mock of a Account to use as return in the tests.
	 *
   * @author Felipe Santiiago
   * @since 2021-03-15
	 *
	 * @return <code>Account</code> object
	 */
	private Account getMockAccount() {
		return new Account(UUID.randomUUID(), ACCOUNT_NUMBER, AccountTypeEnum.BASIC);
	}

}
