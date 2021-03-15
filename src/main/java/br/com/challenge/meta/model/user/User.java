package br.com.challenge.meta.model.user;

import br.com.challenge.meta.enumeration.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * Class that implements an User entity in the API.
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 5514528747731992863L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
	private UUID id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	public User(UUID id) {
		this.id = id;	
	}
	
	/**
	 * Method that verifies if the user is admin
	 *
	 * @author Felipe Santiago
	 * @since 2021-03-12
	 * 
	 * @return boolean
	 */
	public boolean isAdmin() {
		return RoleEnum.ROLE_ADMIN.toString().equals(this.role.toString());
	}

}
