package one.digitalinnovation.Resources;

import one.digitalinnovation.Domain.Person;
import one.digitalinnovation.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = {"/"},method = RequestMethod.POST)
    public ResponseEntity<Person> save(@RequestBody Person person){

        Person obj = personService.save(person);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
