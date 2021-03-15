package br.com.challenge.meta.service.approvalProcessing;

import br.com.challenge.meta.model.approvalProcessing.ApprovalProcessing;
import br.com.challenge.meta.repository.ApprovalProcessing.ApprovalProcessingRepository;
import br.com.challenge.meta.service.approvalProcessing.impl.ApprovalProcessingServiceImpl;
import br.com.challenge.meta.service.mapper.approvalProcessing.ApprovalProcessingMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ServerErrorException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class ApprovalProcessingServiceTest {

  @MockBean
  ApprovalProcessingRepository repository;
  @MockBean
  ApprovalProcessingMapper mapper;
  @MockBean
  private ApprovalProcessingService approvalProcessingService;

  @BeforeEach
  public void setUp() {
    this.approvalProcessingService = new ApprovalProcessingServiceImpl(repository, mapper);
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

}
