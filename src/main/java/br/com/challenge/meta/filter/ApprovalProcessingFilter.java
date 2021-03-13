package br.com.challenge.meta.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder", builderMethodName = "newBuilder")
public class ApprovalProcessingFilter {
  private UUID id;
}
