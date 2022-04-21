package repository.Person;

import domain.Person.*;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;

public class PersonRepository extends BaseRepository<IdentificationNumber, Person>
{
    public PersonRepository(EntityManager theEntityManager){
        super(theEntityManager);
    }
}



