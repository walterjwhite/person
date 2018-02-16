package com.walterjwhite.person.api.service;

import com.walterjwhite.datastore.criteria.AbstractRepository;
import com.walterjwhite.datastore.criteria.CriteriaQueryConfiguration;
import com.walterjwhite.person.api.model.Person;
import com.walterjwhite.person.api.model.Person_;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

/** Wrapper around external queue service */
public class PersonRepository extends AbstractRepository<Person> {
  @Inject
  protected PersonRepository(EntityManager entityManager, CriteriaBuilder criteriaBuilder) {
    super(entityManager, criteriaBuilder, Person.class);
  }

  public List<Person> findByName(String name) {
    final CriteriaQueryConfiguration<Person> messageCriteriaQueryConfiguration = getCriteriaQuery();

    Predicate firstNameCondition =
        criteriaBuilder.like(
            messageCriteriaQueryConfiguration.getRoot().get(Person_.firstName), name);

    Predicate lastNameCondition =
        criteriaBuilder.like(
            messageCriteriaQueryConfiguration.getRoot().get(Person_.lastName), name);

    Predicate middleNameCondition =
        criteriaBuilder.like(
            messageCriteriaQueryConfiguration.getRoot().get(Person_.middleName), name);

    messageCriteriaQueryConfiguration
        .getCriteriaQuery()
        .where(criteriaBuilder.or(firstNameCondition, lastNameCondition, middleNameCondition));
    return (entityManager
        .createQuery(messageCriteriaQueryConfiguration.getCriteriaQuery())
        .getResultList());
  }
}
