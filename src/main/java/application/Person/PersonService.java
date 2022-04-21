package application.Person;

import domain.Person.IdentificationNumber;
import repository.PersistenceContext;
import repository.Person.PersonRepository;
import domain.Person.Person;

import javax.persistence.*;
import java.util.Optional;

public class PersonService{

    private PersonRepository personRepository;
    private EntityManager entityManager = PersistenceContext.Factory("UPskillPU");

    public PersonService(){
        this.personRepository= new PersonRepository(this.entityManager);
    }

    public void save(Person person){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Person p = this.personRepository.save(person);
        tx.commit();
    }

    public Person findById(String id) {
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Optional<Person> p = this.personRepository.findById(new IdentificationNumber(id));
        tx.commit();
        return(p.get());
    }

    public Iterable<Person> findAll(){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Iterable<Person> p = this.personRepository.findAll();
        tx.commit();
        return(p);
    }

    public void removePerson(Person p){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        this.personRepository.delete(p);
        tx.commit();
    }

    public Person updateEmail(Person p, String email){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        try {
            System.out.printf("Sleeping...");
            Thread.sleep(30000);
            System.out.printf("Waking up!");
        }
        catch(InterruptedException e){}
        p.email(email);
        tx.commit();
        return p;
    }
}
