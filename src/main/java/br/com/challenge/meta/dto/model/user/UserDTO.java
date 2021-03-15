package br.com.challenge.meta.dto.model.user;

import br.com.challenge.meta.util.security.BcryptUtil;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

/**
 * Class that implements User data transfer object (DTO)
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserDTO extends RepresentationModel<UserDTO> {

  @Getter
  private UUID id;

  @Getter
  @NotNull(message = "Name cannot be null.")
  @Length(min = 3, max = 255, message = "Name must contain between 3 and 255 characters.")
  private String name;

  @NotNull(message = "Password cannot be null.")
  @Length(min = 6, message = "Password must contain at least 6 characters.")
  private String password;

  @Getter
  @Length(max = 100, message = "Email must be a maximum of 100 characters.")
  @Email(message = "Invalid email.")
  private String email;

  @Getter
  @NotNull(message = "The User access role cannot be null.")
  @Pattern(regexp = "^(ROLE_ADMIN|ROLE_TRIATOR|ROLE_FINISHER)$",
      message = "For the access role only the values ROLE_ADMIN or ROLE_TRIATOR or ROLE_FINISHER are accepted.")
  private String role;

  public String getPassword() {
    return BcryptUtil.getHash(this.password);
  }
}
