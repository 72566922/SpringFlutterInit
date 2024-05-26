package com.jorgecolors.jorgecolors.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<String> createPersona(@RequestBody Person person){
        try {
            personService.createPersona(person);
            return ResponseEntity.ok("Persona created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating persona");
        }
    }

    @GetMapping
    public ResponseEntity<Person> getPerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        Person person = personService.getPerson(firstName, lastName, email);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
