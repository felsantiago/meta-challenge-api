package br.com.challenge.meta.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Class that implements a generic response to the API end-points.
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 *
 * @param <T>
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

  private T data;
  private Object errors;

  /**
   * Method that formats an error message to the HTTP response.
   *
   * @author Felipe Santiago
   * @since 2021-03-12
   *
   * @param msgError
   */
  public void addErrorMsgToResponse(String msgError) {
    ResponseError error = ResponseError.builder().details(msgError).timestamp(LocalDateTime.now()).build();
    setErrors(error);
  }
}
