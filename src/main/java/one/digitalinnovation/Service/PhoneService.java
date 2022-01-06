package one.digitalinnovation.Service;

import one.digitalinnovation.Domain.Phone;
import one.digitalinnovation.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public Phone save(Phone phone){

        return  phoneRepository.save(phone);

    }

    public Phone findById(Integer id){

        Optional<Phone> phone = phoneRepository.findById(id);

        return phone.orElse(null);
    }

}
