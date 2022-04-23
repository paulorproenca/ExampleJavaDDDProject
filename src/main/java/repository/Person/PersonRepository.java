package repository.Person;

import domain.Person.Person;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.swing.text.html.Option;
import java.util.Optional;

public class PersonRepository extends BaseRepository<Long, Person>
{
    private EntityManager entityManager;

    public PersonRepository(EntityManager theEntityManager){
        super(theEntityManager);
        this.entityManager=theEntityManager;
    }

    public Optional<Person> findByIdNumber(String idNumber){
        return Optional.ofNullable((Person)this.entityManager.createQuery("SELECT e FROM Person e WHERE e.personidentificationNumber.theIdNumber = :number")
                .setParameter("number",idNumber)
                .setLockMode(LockModeType.PESSIMISTIC_READ)
                .getSingleResult());
    }
}



