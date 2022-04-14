package application.Person;

import domain.Person.Person;
import repository.PersonRepositiry;

public class CreatePersonController {

    private PersonRepositiry personRepository;

    public CreatePersonController(){
        this.personRepository= new PersonRepositiry();
    }

    public Person createPerson(final String idnumber, final String name, final String email) {
        final Person person = new Person(idnumber, name, email);
        this.personRepository.add(person);
        return person;
    }

}
