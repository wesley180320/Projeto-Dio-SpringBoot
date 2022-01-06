package one.digitalinnovation.Domain;



import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
