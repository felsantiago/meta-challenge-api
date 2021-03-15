package br.com.challenge.meta.dto.model.account;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountDTO extends RepresentationModel<AccountDTO> {

  private UUID id;

  @NotNull(message = "Account Number cannot be null.")
  @Length(min = 6, message = "Account Number must contain at least 6 numbers.")
  private String accountNumber;

  @NotNull(message = "The Account type cannot be null.")
  @Pattern(regexp = "^(FREE|BASIC|PREMIUM)$",
      message = "For the account type only the values FREE, BASIC, or PREMIUM are accepted.")
  private String accountType;
}
