package one.digitalinnovation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoudException extends Exception{


    public PersonNotFoudException(Integer id){

        super("Person not found ID" + id);

    }
}
