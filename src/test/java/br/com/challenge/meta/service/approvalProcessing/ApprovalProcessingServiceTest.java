package br.com.challenge.meta.service.approvalProcessing;

import br.com.challenge.meta.dto.model.approvalProcessing.ApprovalProcessingDTO;
import br.com.challenge.meta.enumeration.AccessEnum;
import br.com.challenge.meta.enumeration.AccountTypeEnum;
import br.com.challenge.meta.enumeration.StatusEnum;
import br.com.challenge.meta.model.account.Account;
import br.com.challenge.meta.model.approvalProcessing.ApprovalProcessing;
import br.com.challenge.meta.repository.ApprovalProcessing.ApprovalProcessingRepository;
import br.com.challenge.meta.service.approvalProcessing.impl.ApprovalProcessingServiceImpl;
import br.com.challenge.meta.service.mapper.approvalProcessing.ApprovalProcessingMapper;
import br.com.challenge.meta.specification.ApprovalProcessingSpecification;
import br.com.challenge.meta.specification.filter.ApprovalProcessingFilter;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ServerErrorException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.Silent.class)
public class ApprovalProcessingServiceTest {

  @Mock
  private ApprovalProcessingRepository repository;

  @Mock
  private ApprovalProcessingMapper mapper;

  @InjectMocks
  private ApprovalProcessingServiceImpl approvalProcessingService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Should findAll the ApprovalProcessing record successfully.")
  public void shouldFindAllTheApprovalProcessingRecordSuccessfully() {
    List<ApprovalProcessingDTO> approvalProcessingDTOS = new ArrayList<>();
    approvalProcessingDTOS.add(getApprovalProcessingDTO());
    List<ApprovalProcessing> approvalProcessing = new ArrayList<>();
    approvalProcessing.add(getApprovalProcessing());
    Page<ApprovalProcessing> pagedResponse = new PageImpl(approvalProcessing);

    ApprovalProcessingFilter filter = new ApprovalProcessingFilter();
    Pageable pageable = PageRequest.of(0, 8);

    ArgumentCaptor<ApprovalProcessingSpecification> specificationsCaptor = ArgumentCaptor.forClass(ApprovalProcessingSpecification.class);
    BDDMockito.given(repository.findAll(specificationsCaptor.capture(), Matchers.eq(pageable))).willReturn(pagedResponse);
    Mockito.when(mapper.toDto(Matchers.anyListOf(ApprovalProcessing.class))).thenReturn(approvalProcessingDTOS);

    List<ApprovalProcessingDTO> response = approvalProcessingService.findAll(filter, pageable);
    assertNotNull(response);
    assertEquals(response.size(), approvalProcessingDTOS.size());
  }

  @Test
  @DisplayName("Should delete the ApprovalProcessing record successfully.")
  public void shouldDeleteTheApprovalProcessingRecordSuccessfully() {
    Optional<ApprovalProcessing> approvalProcessing = Optional.of(ApprovalProcessing.builder().build());
    Mockito.when(repository.findById(Mockito.any())).thenReturn(approvalProcessing);

    ApprovalProcessingService service = Mockito.mock(ApprovalProcessingService.class);
    Mockito.doNothing().when(service).delete(Mockito.any());
    service.delete(Mockito.any());

    Mockito.verify(service, Mockito.times(1)).delete(Mockito.any());
  }

  @Test
  @DisplayName("Should save the ApprovalProcessing record successfully.")
  public void shouldSaveTheApprovalProcessingRecordSuccessfully() {
    ApprovalProcessingDTO dto = getApprovalProcessingDTO();
    ApprovalProcessing approvalProcessing = getApprovalProcessing();

    Mockito.when(repository.save(Mockito.any(ApprovalProcessing.class))).thenReturn(approvalProcessing);
    Mockito.when(mapper.toEntity(Mockito.any(ApprovalProcessingDTO.class))).thenReturn(approvalProcessing);
    Mockito.when(mapper.toDto(Mockito.any(ApprovalProcessing.class))).thenReturn(dto);

    ApprovalProcessingDTO response = approvalProcessingService.save(dto);

    assertNotNull(response);
    assertEquals(dto.getId(), response.getId());
  }

  @Test
  @DisplayName("Should throw exception for Register not found.")
  public void shouldThrowExceptionForInvalidId() {
    Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.empty());
    RuntimeException assertThrows = assertThrows(RuntimeException.class, () -> {
      this.approvalProcessingService.delete(Mockito.any());
    });

    assertEquals("Register not found.", assertThrows.getMessage());
  }

  @Test
  @DisplayName("Should throw exception by error in the database.")
  public void shouldThrowExceptionByErrorInTheDatabase() {
    Optional<ApprovalProcessing> approvalProcessing = Optional.of(ApprovalProcessing.builder().build());
    Mockito.when(repository.findById(Mockito.any())).thenReturn(approvalProcessing);

    Mockito.doThrow(new ServerErrorException("")).when(repository).deleteById(Mockito.any());
    ServerErrorException resultThrows = assertThrows(ServerErrorException.class, () -> {
      this.approvalProcessingService.delete(Mockito.any());
    });

    assertEquals("Failed delete approvalProcessing. Error: 500 INTERNAL_SERVER_ERROR \"\"", resultThrows.getReason());
  }

  private ApprovalProcessing getApprovalProcessing() {
    return new ApprovalProcessing(
        UUID.randomUUID(),
        AccessEnum.ACTIVE,
        StatusEnum.APPROVED,
        LocalDateTime.now(),
        "test",
        "test@test.com",
        "Order 1",
        "Product 1",
        new Account(UUID.randomUUID(), "635241", AccountTypeEnum.BASIC),
        LocalDateTime.now(),
        LocalDateTime.now());
  }

  private ApprovalProcessingDTO getApprovalProcessingDTO() {
    return new ApprovalProcessingDTO(
        UUID.randomUUID(),
        AccessEnum.ACTIVE,
        StatusEnum.APPROVED,
        LocalDateTime.now(),
        "test",
        "test@test.com",
        "Order 1",
        "Product 1",
        UUID.randomUUID(),
        LocalDateTime.now(),
        LocalDateTime.now());
  }
}
