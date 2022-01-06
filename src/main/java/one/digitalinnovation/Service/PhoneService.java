package one.digitalinnovation.Service;

import one.digitalinnovation.Domain.Phone;
import one.digitalinnovation.Repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public Phone save(Phone phone){

        return  phoneRepository.save(phone);

    }

}
