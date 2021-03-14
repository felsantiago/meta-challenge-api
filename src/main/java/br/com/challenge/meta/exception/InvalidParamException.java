package br.com.challenge.meta.exception;

/**
 * Class that implements InvalidParamException in the API
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
public class InvalidParamException extends RuntimeException {

  private static final long serialVersionUID = 6208890125157318839L;

  public InvalidParamException(String msg) {
    super(msg);
  }

  public InvalidParamException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
