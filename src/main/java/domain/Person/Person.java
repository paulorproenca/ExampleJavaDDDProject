package domain.Person;

import domain.shared.AggregateRoot;
import javax.persistence.*;

@Entity
public class Person implements AggregateRoot<IdentificationNumber> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private IdentificationNumber _identificationNumber;
    private Name _nome;
    private Email _email;

    public Person(String identificationNumber, String name, String email){
        this._identificationNumber = new IdentificationNumber(identificationNumber);
        this._nome = new Name(name);
        this._email = new Email(email);
    }

    /* For ORM purposes */
    protected Person(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public IdentificationNumber identity() {
        return this._identificationNumber;
    }

    public String toString()
    {
        return "Person( " + this._nome.name() + " | " + this._email.email() +  " | " + this._identificationNumber.toString() + " )";
    }
}

