package one.digitalinnovation;

import one.digitalinnovation.Domain.Person;
import one.digitalinnovation.Domain.Phone;
import one.digitalinnovation.Repository.PersonRepository;
import one.digitalinnovation.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DioApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	public void run(String... args) throws Exception {


		Person person = new Person(null,"wesley","de souza","16/10/89","234252453");
		Phone phone = new Phone(null,"21321421",person);

		person.getPhones().add(phone);

		personRepository.save(person);
		phoneRepository.save(phone);


	}
}
