package br.com.challenge.meta.exception.HangTag;

/**
 * Class that implements ApprovalProcessingNotFoundException in the API
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
public class HangTagNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -7139304880555402679L;

  public HangTagNotFoundException() {
    super();
  }

  public HangTagNotFoundException(String msg) {
    super(msg);
  }

  public HangTagNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
