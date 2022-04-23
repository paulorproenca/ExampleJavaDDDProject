package application.Car_Group;

import domain.Car_Group.CarGroup;
import repository.PersistenceContext;
import repository.Car_Group.CarGroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

public class CarGroupService {

    private CarGroupRepository carGroupRepository;
    private EntityManager entityManager = PersistenceContext.Factory("UPskillPU");

    public CarGroupService(){
        this.carGroupRepository= new CarGroupRepository(this.entityManager);
    }

    public void save(CarGroup cg){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        CarGroup p = this.carGroupRepository.save(cg);
        tx.commit();
    }

    public CarGroup findByGroupName(String name){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Optional<CarGroup> cg = this.carGroupRepository.findByGroupName(name);
        tx.commit();
        return(cg.get());
    }

    public Iterable<CarGroup> findAll(){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Iterable<CarGroup> cg = this.carGroupRepository.findAll();
        tx.commit();
        return(cg);
    }

    public void removePerson(CarGroup cg){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        this.carGroupRepository.delete(cg);
        tx.commit();
    }
}
