package br.com.challenge.meta.dto.model;

import br.com.challenge.meta.enumeration.AccessEnum;
import br.com.challenge.meta.enumeration.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ApprovalProcessingDTO {
  private UUID id;
  private AccessEnum access;
  private StatusEnum status;
  private UserDTO responsible;
  private LocalDateTime dueDate;
  Set<HangTagDTO> hangTags;
  private String buyerName;
  private String buyerEmail;
  private String purchaseOrderName;
  private String description;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
