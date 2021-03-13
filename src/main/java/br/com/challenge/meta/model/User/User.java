package br.com.challenge.meta.model.User;

import br.com.challenge.meta.enumeration.AccessEnum;
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
@Table(name = "user")
public class User implements Serializable {
  private static final long serialVersionUID = 196266143388770099L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
  private UUID id;

  @Column(name = "active", length = 1)
  @Enumerated(EnumType.ORDINAL)
  private AccessEnum access;

  @Size(max = 120)
  @Column(length = 120)
  private String name;

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
