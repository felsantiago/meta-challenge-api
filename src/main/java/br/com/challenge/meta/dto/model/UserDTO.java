package br.com.challenge.meta.dto.model;

import br.com.challenge.meta.enumeration.AccessEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserDTO extends RepresentationModel<UserDTO> {
  private UUID id;
  private AccessEnum access;
  private String name;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
