package br.com.challenge.meta.repository;

import br.com.challenge.meta.model.ApprovalProcessing.ApprovalProcessing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface ApprovalProcessingRepository
    extends JpaRepository<ApprovalProcessing, UUID>, JpaSpecificationExecutor<ApprovalProcessing> {}
