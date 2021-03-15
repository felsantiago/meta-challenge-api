package br.com.challenge.meta.model.approvalProcessing;

import br.com.challenge.meta.enumeration.AccessEnum;
import br.com.challenge.meta.enumeration.StatusEnum;
import br.com.challenge.meta.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "approval_processing")
@Builder
public class ApprovalProcessing implements Serializable {
  private static final long serialVersionUID = 196266143388770099L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
  private UUID id;

  @Column(name = "active", length = 1)
  @Enumerated(EnumType.ORDINAL)
  private AccessEnum access;

  @Column
  @Enumerated(EnumType.ORDINAL)
  private StatusEnum status;

  @Column(name = "due_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime dueDate;

  @Size(max = 200)
  @Column(length = 200)
  private String buyerName;

  @Size(max = 120)
  @Column(length = 120)
  private String buyerEmail;

  @Size(max = 200)
  @Column(length = 200)
  private String purchaseOrderName;

  @Size(max = 200)
  @Column(length = 200)
  private String description;

  @JoinColumn(name = "account_id", referencedColumnName = "id")
  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @Column(name = "created_at", columnDefinition = "TIMESTAMP")
  private LocalDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private LocalDateTime updatedAt;

  @PreUpdate
  public void preUpdate() {
    updatedAt = LocalDateTime.now();
  }

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }
}
