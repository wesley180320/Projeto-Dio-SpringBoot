package one.digitalinnovation.Resources;

import one.digitalinnovation.Domain.Phone;
import one.digitalinnovation.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/phone")
public class PhoneResources {


    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity<Phone> save(@RequestBody Phone phone){

        Phone obj = phoneService.save(phone);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
