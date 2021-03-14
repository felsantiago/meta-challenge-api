package br.com.challenge.meta.exception.ApprovalProcessing;

/**
 * Class that implements ApprovalProcessingNotFoundException in the API
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
public class ApprovalProcessingNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -7139304880555402679L;

  public ApprovalProcessingNotFoundException() {
    super();
  }

  public ApprovalProcessingNotFoundException(String msg) {
    super(msg);
  }

  public ApprovalProcessingNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
