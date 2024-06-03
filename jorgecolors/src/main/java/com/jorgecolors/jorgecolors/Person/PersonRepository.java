//SPRINGBOOTFLUTTER/jorgecolors/src/main/java/com/jorgecolors/jorgecolors/Person/PersonRepository
package com.jorgecolors.jorgecolors.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
}
