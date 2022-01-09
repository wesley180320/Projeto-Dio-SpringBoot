package one.digitalinnovation.Domain;




import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Person_id")
    private Person person;

    public Phone(){}

    public Phone(Integer id, String numero, Person person) {
        this.id = id;
        this.numero = numero;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumerous() {
        return numero;
    }

    public void setNumerous(String numerous) {
        this.numero = numerous;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return getId().equals(phone.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
