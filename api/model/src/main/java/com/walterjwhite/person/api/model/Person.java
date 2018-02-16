package com.walterjwhite.person.api.model;

import com.walterjwhite.datastore.api.model.entity.AbstractEntity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;

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

  public Person(String firstName, String middleName, String lastName, LocalDate birthDate) {
    super();
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public Person() {
    super();
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null)
      return false;
    if (middleName != null ? !middleName.equals(person.middleName) : person.middleName != null)
      return false;
    if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null)
      return false;
    return birthDate != null ? birthDate.equals(person.birthDate) : person.birthDate == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
    return result;
  }
}
