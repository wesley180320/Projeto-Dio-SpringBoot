package one.digitalinnovation.Dto;

import java.io.Serializable;
import java.util.Date;

public class PersonDto implements Serializable {


    private static final long serialVersionUID = 1L;

    private String firstname;
    private String lastname;
    private Date birthdate;
    private String cpf;
    public String numero;

    public PersonDto (){}


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
