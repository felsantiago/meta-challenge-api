package br.com.challenge.meta.exception.ApprovalProcessing;

/**
 * Class that implements ApprovalProcessingInvalidUpdateException in the API.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public class ApprovalProcessingInvalidUpdateException extends RuntimeException {

  private static final long serialVersionUID = -6443362632495638948L;

  public ApprovalProcessingInvalidUpdateException() {
    super();
  }

  public ApprovalProcessingInvalidUpdateException(String msg) {
    super(msg);
  }

  public ApprovalProcessingInvalidUpdateException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
