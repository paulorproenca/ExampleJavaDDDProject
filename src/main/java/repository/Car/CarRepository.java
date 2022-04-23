package repository.Car;

import domain.Car.Car;
import domain.Person.Person;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.Optional;

public class CarRepository extends BaseRepository<String, Car>
{
    private EntityManager entityManager;

    public CarRepository(EntityManager theEntityManager){
        super(theEntityManager);
        this.entityManager=theEntityManager;
    }

    public Optional<Car> findByPlate(String plate){
        return Optional.ofNullable((Car)this.entityManager.createQuery("SELECT e FROM Car e WHERE e.carPlate.thePlate = :plate")
                .setParameter("plate",plate)
                .setLockMode(LockModeType.PESSIMISTIC_READ)
                .getSingleResult());
    }
}



