package br.com.challenge.meta.dto.form;

import br.com.challenge.meta.enumeration.AccessEnum;
import br.com.challenge.meta.enumeration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApprovalProcessingForm {
  private AccessEnum access;
  private StatusEnum status;
  private UUID responsible;
  private LocalDateTime dueDate;
  private String buyerName;
  private String buyerEmail;
  private String purchaseOrderName;
  private String description;
}
