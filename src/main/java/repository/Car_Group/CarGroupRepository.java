package repository.Car_Group;

import domain.Car_Group.CarGroup;
import domain.Person.Person;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.Optional;

public class CarGroupRepository extends BaseRepository<String, CarGroup>
{
    private EntityManager entityManager;

    public CarGroupRepository(EntityManager theEntityManager){
        super(theEntityManager);
        this.entityManager=theEntityManager;
    }

    public Optional<CarGroup> findByGroupName(String name){
        return Optional.ofNullable((CarGroup)this.entityManager.createQuery("SELECT e FROM CarGroup e WHERE e.groupName.theName = :name")
                .setParameter("name",name)
                .setLockMode(LockModeType.PESSIMISTIC_READ)
                .getSingleResult());
    }
}



