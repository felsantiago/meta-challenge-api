package br.com.challenge.meta.controller.v1.account;

import br.com.challenge.meta.dto.model.account.AccountDTO;
import br.com.challenge.meta.dto.model.approvalProcessing.ApprovalProcessingDTO;
import br.com.challenge.meta.dto.response.Response;
import br.com.challenge.meta.exception.AccountNotFoundException;
import br.com.challenge.meta.model.account.Account;
import br.com.challenge.meta.service.account.AccountService;
import br.com.challenge.meta.util.MetaApiUtil;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Log4j2
@RestController
@RequestMapping("/api/v1/accounts")
@AllArgsConstructor
public class AccountController {

  private final AccountService service;

  @PostMapping
  @ApiOperation(
      httpMethod = "POST",
      value = "Create approval processing",
      response = ApprovalProcessingDTO.class)
  public ResponseEntity<Response<AccountDTO>> create(
      @RequestBody @Valid AccountDTO dto,
      BindingResult result,
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion) {

    Response<AccountDTO> response = new Response<>();

    if (result.hasErrors()) {
      result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
      return ResponseEntity.badRequest().body(response);
    }

    AccountDTO dtoSaved = service.save(dto);
    response.setData(dtoSaved);

    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);

    return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
  }

  @GetMapping(value = "/byAccountNumber/{number}")
  @ApiOperation(value = "Route to find account by the Account Number in the API")
  public ResponseEntity<Response<AccountDTO>> findByAccountNumber(
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @PathVariable("number") String accountNumber) throws AccountNotFoundException {

    Response<AccountDTO> response = new Response<>();
    Optional<AccountDTO> accountDTO = service.findByAccountNumber(accountNumber);

    if (accountDTO.isPresent()) {
      try {
        createSelfLinkInCollections(apiVersion, apiKey, accountDTO.get());

        response.setData(accountDTO.get());
      } catch (AccountNotFoundException e) {
        log.error("There are no accounts registered with the accountNumber= {}", accountNumber);
      }
    }

    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);
    headers.add(MetaApiUtil.HEADER_API_KEY, apiKey);

    return new ResponseEntity<>(response, headers, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  @ApiOperation(value = "Route to find a account by your id in the API")
  public ResponseEntity<Response<AccountDTO>> findById(
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @PathVariable("id") UUID accountId) throws AccountNotFoundException {

    Response<AccountDTO> response = new Response<>();
    AccountDTO dto = service.findById(accountId);
    Account entity = service.toEntity(dto);

    createSelfLink(entity, dto);
    response.setData(dto);

    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);
    headers.add(MetaApiUtil.HEADER_API_KEY, apiKey);

    return new ResponseEntity<>(response, headers, HttpStatus.OK);
  }

  /**
   * Method that creates a self link to account object
   *
   * @param account
   * @param accountDTO
   * @author Felipe Santiiago
   * @since 2021-03-15
   */
  private void createSelfLink(Account account, AccountDTO accountDTO) {
    Link selfLink = WebMvcLinkBuilder.linkTo(AccountController.class).slash(account.getId()).withSelfRel();
    accountDTO.add(selfLink);
  }

  /**
   * Method that creates a self link in a collection of accounts
   *
   * @param apiVersion - API version at the moment
   * @param apiKey     - API Key to access the routes
   * @param accountDTO
   * @throws AccountNotFoundException
   * @author Felipe Santiiago
   * @since 2021-03-15
   */
  private void createSelfLinkInCollections(String apiVersion, String apiKey, final AccountDTO accountDTO)
      throws AccountNotFoundException {
    Link selfLink = linkTo(methodOn(AccountController.class).findById(apiVersion, apiKey, accountDTO.getId()))
        .withSelfRel().expand();
    accountDTO.add(selfLink);
  }
}
