package br.com.challenge.meta.filter;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class ApprovalProcessingFilter extends RepresentationModel<ApprovalProcessingFilter> {
  private UUID id;
}
