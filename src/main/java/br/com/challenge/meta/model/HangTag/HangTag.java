package br.com.challenge.meta.model.HangTag;

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
@Table(name = "hang_tag")
public class HangTag implements Serializable {
  private static final long serialVersionUID = 196266143388770099L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "BINARY(16)", updatable = false, unique = true, nullable = false)
  private UUID id;

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
