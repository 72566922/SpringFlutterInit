//SPRINGBOOTFLUTTER/jorgecolors/src/main/java/com/jorgecolors/jorgecolors/Person/PersonController.java
package com.jorgecolors.jorgecolors.Person;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:56315")
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
    public ResponseEntity<List<Person>> getPerson() {
        List<Person> person = personService.obtenerTodasPerson();
        return ResponseEntity.ok(person);
    }
}
