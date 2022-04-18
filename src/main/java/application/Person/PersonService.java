package application.Person;

import repository.PersistenceContext;
import repository.Person.PersonRepository;
import domain.Person.Person;

import javax.persistence.*;
import java.util.Optional;

public class PersonService {

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

    public Person findById(Long id){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Optional<Person> p = this.personRepository.findById(id);
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
}
