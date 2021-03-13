package br.com.challenge.meta.dto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class HangTagDTO {
  private UUID id;
  private String name;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
