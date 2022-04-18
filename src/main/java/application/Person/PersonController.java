package application.Person;

        import domain.Person.Person;

public class PersonController {

    private final PersonService personService = new PersonService();;

    public PersonController(){}

    public Person createPerson(final String idnumber, final String name, final String email) {
        final Person person = new Person(idnumber, name, email);
        this.personService.save(person);
        return person;
    }

    public Person findPerson(final Long id) {
        return this.personService.findById(id);
    }

    public Iterable<Person> findAllPerson(){
        return this.personService.findAll();
    }

    public void removePerson(Person p){
        this.personService.removePerson(p);
    }
}
