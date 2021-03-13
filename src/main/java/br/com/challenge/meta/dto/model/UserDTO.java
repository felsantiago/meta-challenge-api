package br.com.challenge.meta.dto.model;

import br.com.challenge.meta.enumeration.AccessEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDTO {
  private UUID id;
  private AccessEnum access;
  private String name;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
