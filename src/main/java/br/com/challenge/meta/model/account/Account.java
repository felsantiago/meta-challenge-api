package br.com.challenge.meta.model.account;

import br.com.challenge.meta.enumeration.AccountTypeEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

/**
 * Class that implements the Account structure.
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account implements Serializable {

	private static final long serialVersionUID = -6762432601286928295L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	@NotNull
	@Column(name = "account_number")
	private String accountNumber;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "account_type")
	private AccountTypeEnum accountType;
	
	public Account(UUID id) {
		this.id = id;
	}
}
