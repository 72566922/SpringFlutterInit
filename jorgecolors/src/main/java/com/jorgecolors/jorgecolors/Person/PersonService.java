//SPRINGBOOTFLUTTER/jorgecolors/src/main/java/com/jorgecolors/jorgecolors/Person/PersonService
package com.jorgecolors.jorgecolors.Person;

import java.util.List;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;

    public void createPersona(Person person){
        personRepo.save(person);
    }

    public List<Person> obtenerTodasPerson() {
        return personRepo.findAll();
    }
}
