package br.com.challenge.meta.exception.User;

/**
 * Class that implements ApprovalProcessingInvalidUpdateException in the API.
 *
 * @author Mariana Azevedo
 * @since 01/04/2020
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
