package br.com.challenge.meta.repository;

import br.com.challenge.meta.model.HangTag.HangTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface HangTagRepository
    extends JpaRepository<HangTag, UUID>, JpaSpecificationExecutor<HangTag> {}
