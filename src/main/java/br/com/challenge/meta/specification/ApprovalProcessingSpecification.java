package br.com.challenge.meta.specification;

import br.com.challenge.meta.dto.model.ApprovalProcessingDTO;
import br.com.challenge.meta.filter.ApprovalProcessingFilter;
import br.com.challenge.meta.model.ApprovalProcessing.ApprovalProcessing;
import br.com.challenge.meta.model.ApprovalProcessing.ApprovalProcessing_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ApprovalProcessingSpecification implements Specification<ApprovalProcessing> {

  private final ApprovalProcessingFilter filter;

  public ApprovalProcessingSpecification(ApprovalProcessingFilter filter) {
    this.filter = filter;
  }

  @Override
  public Predicate toPredicate(Root<ApprovalProcessing> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();

    if (filter.getId() != null)
      predicates.add(criteriaBuilder.equal(root.get(ApprovalProcessing_.id), filter.getId()));

    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
  }
}
