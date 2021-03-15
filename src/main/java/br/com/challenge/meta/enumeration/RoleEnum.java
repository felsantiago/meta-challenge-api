package br.com.challenge.meta.enumeration;

/**
 * Enum that represents the two types of roles in the API: ROLE_ADMIN and ROLE_USER.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public enum RoleEnum {

	ROLE_ADMIN("ROLE_ADMIN"),
	ROLE_TRIATOR("ROLE_TRIATOR"),
	ROLE_FINISHER("ROLE_FINISHER");

	private String value;

	private RoleEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
