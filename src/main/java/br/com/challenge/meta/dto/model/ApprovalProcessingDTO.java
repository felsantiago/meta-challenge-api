package br.com.challenge.meta.dto.model;

import br.com.challenge.meta.enumeration.AccessEnum;
import br.com.challenge.meta.enumeration.StatusEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zero_x_baadf00d.partialize.annotation.Partialize;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Partialize(allowedFields = {"id", "access", "status", "responsible", "dueDate", "hangTags", "hangTags", "buyerName", "buyerEmail", "purchaseOrderName", "description", "createdAt", "updatedAt"},
    defaultFields = {"id", "access", "status", "responsible"})
public class ApprovalProcessingDTO extends RepresentationModel<ApprovalProcessingDTO> {
  private UUID id;
  private AccessEnum access;
  private StatusEnum status;
  private UserDTO responsible;
  private LocalDateTime dueDate;
  private String buyerName;
  private String buyerEmail;
  private String purchaseOrderName;
  private String description;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
