package br.com.challenge.meta.exception.User;

/**
 * Class that implements ApprovalProcessingNotFoundException in the API
 *
 * @author Felipe Santiago
 * @since 2021-03-12
 */
public class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -7139304880555402679L;

  public UserNotFoundException() {
    super();
  }

  public UserNotFoundException(String msg) {
    super(msg);
  }

  public UserNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
