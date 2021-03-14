package br.com.challenge.meta.exception;

/**
 * Class that implements NotParsableContentException in the API
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
public class NotParsableContentException extends Exception {

  private static final long serialVersionUID = 6208890125157318839L;

  public NotParsableContentException(String msg) {
    super(msg);
  }

  public NotParsableContentException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
