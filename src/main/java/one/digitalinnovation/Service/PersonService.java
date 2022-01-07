package one.digitalinnovation.Service;

import one.digitalinnovation.Domain.Person;
import one.digitalinnovation.Exception.PersonNotFoudException;
import one.digitalinnovation.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findById(Integer id) throws PersonNotFoudException {

        Optional<Person> obj = personRepository.findById(id);

        if(obj.isEmpty()){

            throw new PersonNotFoudException(id);

        }

        return obj.orElse(null);

    }

    public Person save(Person person){

       return personRepository.save(person);
       
    }

    public List<Person> findAll(){

        return personRepository.findAll();
    }

    public void deletById(Integer id){

        personRepository.deleteById(id);
    }

}
