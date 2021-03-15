package br.com.challenge.meta.exception.User;

/**
 * Class that implements ApprovalProcessingInvalidUpdateException in the API.
 *
   * @author Felipe Santiiago
   * @since 2021-03-15
 */
public class UserInvalidUpdateException extends Exception {

  private static final long serialVersionUID = -6443362632495638948L;

  public UserInvalidUpdateException() {
    super();
  }

  public UserInvalidUpdateException(String msg) {
    super(msg);
  }

  public UserInvalidUpdateException(String msg, Throwable cause) {
    super(msg, cause);
  }

}
