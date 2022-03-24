package application.Person;

import domain.Person.Person;

public class CreatePersonController {

    public Person createPerson(final String idnumber, final String name, final String email) {
        final Person person = new Person(idnumber, name, email);
        return person;
    }

}
