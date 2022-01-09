package one.digitalinnovation.Resources;

import one.digitalinnovation.Domain.Person;
import one.digitalinnovation.Domain.Phone;
import one.digitalinnovation.Dto.PersonDto;
import one.digitalinnovation.Exception.PersonNotFoudException;
import one.digitalinnovation.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = {"/"},method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody PersonDto personDto){

        Person obj = personService.personFromDto(personDto);
        obj = personService.save(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> finById(@PathVariable Integer id) throws PersonNotFoudException {

        Person obj = personService.findById(id);

        return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findAll(){

        List<Person> obj = personService.findAll();

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletById(@PathVariable Integer id) {

        personService.deletById(id);

        return ResponseEntity.ok(null);


    }


}
