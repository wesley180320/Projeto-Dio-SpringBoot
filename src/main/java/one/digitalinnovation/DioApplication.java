package one.digitalinnovation;

import one.digitalinnovation.Domain.Person;
import one.digitalinnovation.Domain.Phone;
import one.digitalinnovation.Repository.PersonRepository;
import one.digitalinnovation.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

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
		Person person2 = new Person(null,"joilson","de souza","16/10/79","234252456");
		Phone phone = new Phone(null,"(67) 8734-6798",person);
		Phone phone2 = new Phone(null,"(54) 9940-5088 ",person2);

		person.getPhones().add(phone);
		person2.getPhones().add(phone2);

		personRepository.saveAll(Arrays.asList(person,person2));
		phoneRepository.saveAll(Arrays.asList(phone,phone2));


	}
}
