package one.digitalinnovation.Service;

import one.digitalinnovation.Domain.Person;
import one.digitalinnovation.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findById(Integer id){

        Optional<Person> obj = personRepository.findById(id);

        return obj.orElse(null);

    }

    public Person save(Person person){

       return personRepository.save(person);
       
    }

}
