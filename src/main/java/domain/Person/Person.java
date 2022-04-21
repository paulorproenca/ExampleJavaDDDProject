package domain.Person;

import domain.shared.AggregateRoot;
import javax.persistence.*;

@Entity
public class Person implements AggregateRoot<IdentificationNumber> {
    @EmbeddedId
    private IdentificationNumber personidentificationNumber;
    private Name personName;
    private Email personEmail;

    @Version
    private long version;

    public Person(String identificationNumber, String name, String email){
        this.personidentificationNumber = new IdentificationNumber(identificationNumber);
        this.personName = new Name(name);
        this.personEmail = new Email(email);
    }

    /* For ORM purposes */
    protected Person(){}

    public void email(String e){
        this.personEmail = new Email(e);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public IdentificationNumber identity() {
        return this.personidentificationNumber;
    }

    public String toString()
    {
        return "Person( " + this.personName.name() + " | " + this.personEmail.email() +  " | " + this.personidentificationNumber.toString() + " )";
    }
}

