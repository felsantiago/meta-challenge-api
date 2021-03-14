package br.com.challenge.meta.handler;

import br.com.challenge.meta.dto.response.Response;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingInvalidUpdateException;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingNotFoundException;
import br.com.challenge.meta.exception.InvalidParamException;
import br.com.challenge.meta.exception.NotParsableContentException;
import br.com.challenge.meta.exception.User.UserNotFoundException;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ServerErrorException;

/**
 * Class that implements a handler of exceptions and errors in the API, using {@ControllerAdvice}
 * and sending the proper response to the client.
 *
 * @param <T>
 * @author Felipe Santiago
 * @since 2021-03-12
 */
@ControllerAdvice
public class ResourceExceptionHandler<T> {

  /**
   * Method that handles with a ApprovalProcessingInvalidUpdateException and returns an error with
   * status code = 403.
   *
   * @param exception ApprovalProcessingInvalidUpdateException
   * @return ResponseEntity<Response < T>>
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @ExceptionHandler(value = {ApprovalProcessingInvalidUpdateException.class})
  protected ResponseEntity<Response<T>> handleApprovalProcessingInvalidUpdateException(ApprovalProcessingInvalidUpdateException exception) {

    Response<T> response = new Response<>();
    response.addErrorMsgToResponse(exception.getLocalizedMessage());

    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
  }

  /**
   * Method that handles with a ApprovalProcessingNotFoundException and returns an error with
   * status code = 404.
   *
   * @param exception ApprovalProcessingNotFoundException
   * @return ResponseEntity<Response < T>>
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @ExceptionHandler(value = {ApprovalProcessingNotFoundException.class})
  protected ResponseEntity<Response<T>> handleApprovalProcessingNotFoundException(ApprovalProcessingNotFoundException exception) {

    Response<T> response = new Response<>();
    response.addErrorMsgToResponse(exception.getLocalizedMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  /**
   * Method that handles with a UserNotFoundException and returns an error with
   * status code = 404.
   *
   * @param exception UserNotFoundException
   * @return ResponseEntity<Response < T>>
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @ExceptionHandler(value = {UserNotFoundException.class})
  protected ResponseEntity<Response<T>> handleUserNotFoundException(UserNotFoundException exception) {

    Response<T> response = new Response<>();
    response.addErrorMsgToResponse(exception.getLocalizedMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

	/**
	 * Method that handles with a InvalidParamException and returns an error with
	 * status code = 404.
	 *
	 * @param exception InvalidParamException
	 * @return ResponseEntity<Response < T>>
	 * @author Felipe Santiago
	 * @since 2021-03-12
	 */
	@ExceptionHandler(value = {InvalidParamException.class})
	protected ResponseEntity<Response<T>> handleInvalidParamException(InvalidParamException exception) {

		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

  /**
   * Method that handles with a HttpClientErrorException and returns a Conflict
   * error with status code = 409.
   *
   * @param exception HttpClientErrorException
   * @return ResponseEntity<Response < T>>
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @ExceptionHandler(value = {HttpClientErrorException.Conflict.class})
  protected ResponseEntity<Response<T>> handleConflictException(HttpClientErrorException exception) {

    Response<T> response = new Response<>();
    response.addErrorMsgToResponse(exception.getLocalizedMessage());

    return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
  }

  /**
   * Method that handles with a HttpMessageNotReadableException or JsonParseException and
   * returns an Unprocessable Entity error with status code = 422.
   *
   * @param exception Exception
   * @return ResponseEntity<Response < T>>
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @ExceptionHandler(value = {HttpMessageNotReadableException.class, JsonParseException.class, NotParsableContentException.class})
  protected ResponseEntity<Response<T>> handleMessageNotReadableException(Exception exception) {

    Response<T> response = new Response<>();
    response.addErrorMsgToResponse(exception.getLocalizedMessage());

    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
  }

  /**
   * Method that handles with a HttpClientErrorException and returns a TooManyRequests error
   * with status code = 429.
   *
   * @param exception HttpClientErrorException
   * @return ResponseEntity<Response < T>>
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @ExceptionHandler(value = {HttpClientErrorException.TooManyRequests.class})
  protected ResponseEntity<Response<T>> handleTooManyRequestException(HttpClientErrorException exception) {

    Response<T> response = new Response<>();
    response.addErrorMsgToResponse(exception.getLocalizedMessage());

    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(response);
  }

  /**
   * Method that handles with a TravelsJavaAPIException and returns an Internal Server Error
   * with status code = 500.
   *
   * @param exception ServerErrorException
   * @return ResponseEntity<Response < T>>
   * @author Felipe Santiago
   * @since 2021-03-12
   */
  @ExceptionHandler(value = {ServerErrorException.class})
  protected ResponseEntity<Response<T>> handleAPIException(ServerErrorException exception) {

    Response<T> response = new Response<>();
    response.addErrorMsgToResponse(exception.getLocalizedMessage());

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

}
