package br.com.challenge.meta.specification;

import br.com.challenge.meta.model.user.User;
import br.com.challenge.meta.model.user.User_;
import br.com.challenge.meta.specification.filter.UserFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<User> {

  private final UserFilter filter;

  public UserSpecification(UserFilter filter) {
    this.filter = filter;
  }

  @Override
  public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();

    if (filter.getId() != null)
      predicates.add(criteriaBuilder.equal(root.get(User_.id), filter.getId()));

    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
  }
}
