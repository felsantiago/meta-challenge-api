package br.com.challenge.meta.controller.v1;

import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
import br.com.challenge.meta.exception.ApprovalProcessing.ApprovalProcessingNotFoundException;
import br.com.challenge.meta.exception.NotParsableContentException;
import br.com.challenge.meta.filter.ApprovalProcessingFilter;
import br.com.challenge.meta.service.ApprovalProcessing.ApprovalProcessingService;
import br.com.challenge.meta.util.MetaApiUtil;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
  public ResponseEntity<List<ApprovalProcessingDTO>> findAll(
      ApprovalProcessingFilter filter,
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @PageableDefault(page = 1, size = 10, sort = {"id"}) Pageable pageable,
      @ApiIgnore ServerHttpResponse response) {
    return null;
  }

  @PostMapping
  @ApiOperation(
      httpMethod = "POST",
      value = "Create approval processing",
      response = ApprovalProcessingDTO.class)
  public ResponseEntity<ApprovalProcessingDTO> store(
      @RequestBody @Valid ApprovalProcessingDTO dto,
      BindingResult result,
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey) throws NotParsableContentException {
    return null;
  }

  @DeleteMapping("/{id}")
  @ApiOperation(
      httpMethod = "DELETE",
      value = "Delete approval processing",
      response = ApprovalProcessingDTO.class)
  public ResponseEntity<Boolean> delete(
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @PathVariable UUID id) throws ApprovalProcessingNotFoundException {
    return null;
  }

  @PutMapping("/{id}")
  @ApiOperation(
      httpMethod = "PUT",
      value = "Update approval processing information",
      response = ApprovalProcessingDTO.class)
  public ResponseEntity<ApprovalProcessingDTO> update(
      @RequestHeader(value = MetaApiUtil.HEADER_META_API_VERSION, defaultValue = "${api.version}") String apiVersion,
      @RequestHeader(value = MetaApiUtil.HEADER_API_KEY, defaultValue = "${api.key}") String apiKey,
      @RequestBody @Valid ApprovalProcessingDTO dto,
      @PathVariable UUID id,
      BindingResult result) throws ApprovalProcessingNotFoundException, ApprovalProcessingNotFoundException, NotParsableContentException {
    return null;
  }
}
