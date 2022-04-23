package application.Car;

import domain.Car.Car;
import repository.Car.CarRepository;
import repository.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

public class CarService {

    private CarRepository carRepository;
    private EntityManager entityManager = PersistenceContext.Factory("UPskillPU");

    public CarService(){
        this.carRepository= new CarRepository(this.entityManager);
    }

    public void save(Car c){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Car nc = this.carRepository.save(c);
        tx.commit();
    }

    public Car findById(String name){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Optional<Car> c = this.carRepository.findById(name);
        tx.commit();
        return(c.get());
    }

    public Car findByPlate(String plate){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Optional<Car> c = this.carRepository.findByPlate(plate);
        tx.commit();
        return(c.get());
    }

    public Iterable<Car> findAll(){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Iterable<Car> c = this.carRepository.findAll();
        tx.commit();
        return(c);
    }

    public void removePerson(Car c){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        this.carRepository.delete(c);
        tx.commit();
    }
}
