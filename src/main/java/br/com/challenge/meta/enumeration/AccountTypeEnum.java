package br.com.challenge.meta.enumeration;

/**
 * Enum that classifies the account's type in the API.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 *
 */
public enum AccountTypeEnum {

	FREE("FREE"),
	BASIC("BASIC"),
	PREMIUM("PREMIUM");

	private String value;

	private AccountTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
