package com.jorgecolors.jorgecolors.Person;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;

    public void createPersona(Person person){
        personRepo.save(person);
    }

    public Person getPerson(String firstName, String lastName, String email) {
        return personRepo.findByFirstNameAndLastNameAndEmail(firstName, lastName, email);
    }
}
