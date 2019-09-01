package com.walterjwhite.person.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractEntity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(doNotUseGetters = true)
@AllArgsConstructor
@NoArgsConstructor
// @PersistenceCapable
@Entity
public class Person extends AbstractEntity {
  @Column(nullable = false, updatable = false)
  protected String firstName;

  @Column(nullable = false, updatable = false)
  protected String middleName;

  @Column(nullable = false, updatable = false)
  protected String lastName;

  // @Encrypted
  @Column(nullable = false, updatable = false)
  protected LocalDate birthDate;

  // protected Set<EmailAccount> emailAccounts;
}
