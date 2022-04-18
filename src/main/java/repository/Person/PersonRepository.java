package repository.Person;

import domain.Person.Person;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;

public class PersonRepository extends BaseRepository<Long, Person>
{
    public PersonRepository(EntityManager theEntityManager){
        super(theEntityManager);
    }
}



