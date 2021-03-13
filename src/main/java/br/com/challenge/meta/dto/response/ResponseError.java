package br.com.challenge.meta.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Class that implements a generic response error object to the API end-points.
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseError {
  @NotNull(message="Timestamp cannot be null")
  private LocalDateTime timestamp;

  @NotNull(message="Details cannot be null")
  private String details;
}
