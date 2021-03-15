package br.com.challenge.meta.exception.HangTag;

/**
 * Class that implements ApprovalProcessingInvalidUpdateException in the API.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public class HangTagInvalidUpdateException extends Exception {

  private static final long serialVersionUID = -6443362632495638948L;

  public HangTagInvalidUpdateException() {
    super();
  }

  public HangTagInvalidUpdateException(String msg) {
    super(msg);
  }

  public HangTagInvalidUpdateException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
