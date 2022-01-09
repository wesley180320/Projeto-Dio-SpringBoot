package one.digitalinnovation.Service;

import one.digitalinnovation.Domain.Person;
import one.digitalinnovation.Domain.Phone;
import one.digitalinnovation.Dto.PersonDto;
import one.digitalinnovation.Exception.PersonNotFoudException;
import one.digitalinnovation.Repository.PersonRepository;
import one.digitalinnovation.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public Person findById(Integer id) throws PersonNotFoudException {

        Optional<Person> obj = personRepository.findById(id);

        if(obj.isEmpty()){

            throw new PersonNotFoudException(id);

        }

        return obj.orElse(null);

    }

    @Transactional
    public Person save(Person person){

        person.setId(null);
        person = personRepository.save(person);
        phoneRepository.saveAll(person.getPhones());


        return person;
    }


    public Person personFromDto(PersonDto personDto){


    Person person = new Person(null,personDto.getFirstname(),personDto.getLastname(),personDto.getBirthdate(),personDto.getCpf());
    Phone phone = new Phone(null,personDto.getNumero(),person);

    person.getPhones().add(phone);

    return person ;

    }

    public List<Person> findAll(){

        return personRepository.findAll();
    }

    public void deletById(Integer id){

        personRepository.deleteById(id);
    }

}
