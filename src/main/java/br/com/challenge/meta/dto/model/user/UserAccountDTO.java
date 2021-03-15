package br.com.challenge.meta.dto.model.user;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Class that implements User Account data transfer object (DTO)
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserAccountDTO extends RepresentationModel<UserAccountDTO> {

  private UUID id;

  @NotNull(message = "Id cannot be null")
  private UUID userId;

  @NotNull(message = "Account Id cannot be null")
  private UUID accountId;
}
