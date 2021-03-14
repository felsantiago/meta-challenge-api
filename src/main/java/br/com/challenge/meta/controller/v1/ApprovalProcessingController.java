package br.com.challenge.meta.controller.v1;

import br.com.challenge.meta.dto.form.ApprovalProcessingForm;
import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
import br.com.challenge.meta.dto.response.Response;
import br.com.challenge.meta.filter.ApprovalProcessingFilter;
import br.com.challenge.meta.model.ApprovalProcessing.ApprovalProcessing;
import br.com.challenge.meta.service.ApprovalProcessing.ApprovalProcessingService;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingNotFoundException;
import br.com.challenge.meta.exception.NotParsableContentException;
import br.com.challenge.meta.util.MetaApiUtil;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Log4j2
@RestController
@RequestMapping("/api/v1/approval-processing")
@AllArgsConstructor
public class ApprovalProcessingController {

  private final ApprovalProcessingService service;

  @GetMapping
  @ApiOperation(
      httpMethod = "GET",
      value = "Search approval processing based on filter",
      response = ApprovalProcessingDTO.class,
      responseContainer = "List")
  public ResponseEntity<Response<List<ApprovalProcessingDTO>>> findAll(
      ApprovalProcessingFilter filter,
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @PageableDefault(page = 1, size = 10, sort = {"id"}) Pageable pageable) {

    List<ApprovalProcessingDTO> body = service.findAll(filter, pageable);
    Response<List<ApprovalProcessingDTO>> response = new Response<>();
    response.setData(body);

    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);
    headers.add(MetaApiUtil.HEADER_API_KEY, apiKey);

    return new ResponseEntity<>(response, headers, HttpStatus.OK);
  }

  @PostMapping
  @ApiOperation(
      httpMethod = "POST",
      value = "Create approval processing",
      response = ApprovalProcessingDTO.class)
  public ResponseEntity<Response<ApprovalProcessingDTO>> create(
      @RequestBody @Valid ApprovalProcessingForm form,
      BindingResult result,
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey) {

    Response<ApprovalProcessingDTO> response = new Response<>();

    if (result.hasErrors()) {
      result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
      return ResponseEntity.badRequest().body(response);
    }

    ApprovalProcessingDTO dtoSaved = service.save(form);
    response.setData(dtoSaved);

    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);
    headers.add(MetaApiUtil.HEADER_API_KEY, apiKey);

    return new ResponseEntity<>(response, headers, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  @ApiOperation(
      httpMethod = "DELETE",
      value = "Delete approval processing",
      response = ApprovalProcessingDTO.class)
  public ResponseEntity<Response> delete(
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @PathVariable UUID id) throws ApprovalProcessingNotFoundException {

    Response<String> response = new Response<>();
    service.delete(id);

    response.setData("Approval Processing id=" + id + " successfully deleted");

    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);
    headers.add(MetaApiUtil.HEADER_API_KEY, apiKey);

    return new ResponseEntity<>(response, headers, HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  @ApiOperation(
      httpMethod = "PUT",
      value = "Update approval processing information",
      response = ApprovalProcessingDTO.class)
  public ResponseEntity<Response<ApprovalProcessingDTO>> update(
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @RequestBody @Valid ApprovalProcessingForm form,
      @PathVariable UUID id,
      BindingResult result) throws ApprovalProcessingNotFoundException, ApprovalProcessingNotFoundException, NotParsableContentException {

    Response<ApprovalProcessingDTO> response = new Response<>();

    if (result.hasErrors()) {
      result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
      return ResponseEntity.badRequest().body(response);
    }

    ApprovalProcessingDTO approvalProcessingUpdated = service.update(form, id);
    response.setData(approvalProcessingUpdated);

    MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
    headers.add(MetaApiUtil.HEADER_META_API_VERSION, apiVersion);
    headers.add(MetaApiUtil.HEADER_API_KEY, apiKey);

    return new ResponseEntity<>(response, headers, HttpStatus.OK);
  }

  /**
   * Method that creates a self link to travel object
   *
   * @param approvalProcessing                          - ApprovalProcessing
   * @param approvalProcessingDTO                       - ApprovalProcessingDTO
   * @author Felipe Santiago
   * @since 2021-03-14
   */
  private void createSelfLink(ApprovalProcessing approvalProcessing, ApprovalProcessingDTO approvalProcessingDTO) {
    Link selfLink = WebMvcLinkBuilder.linkTo(ApprovalProcessingController.class).slash(approvalProcessing.getId()).withSelfRel();
    approvalProcessingDTO.add(selfLink);
  }

  /**
   * Method that creates a self link in a collection of travels
   *
   * @param apiVersion                                  - API version at the moment
   * @param apiKey                                      - API Key to access the routes
   * @param approvalProcessingFilter                    - filter
   * @throws ApprovalProcessingNotFoundException        - throws
   * @author Felipe Santiago
   * @since 2021-03-14
   */
  private void createSelfLinkInCollections(final ApprovalProcessingFilter approvalProcessingFilter, String apiVersion, String apiKey)
      throws ApprovalProcessingNotFoundException {
    Link selfLink = linkTo(methodOn(ApprovalProcessingController.class).findAll(approvalProcessingFilter, apiVersion, apiKey, null))
        .withSelfRel().expand();
    approvalProcessingFilter.add(selfLink);
  }
}
