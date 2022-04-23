package application.Contract;

import domain.Car.Car;
import domain.Contract.Contract;
import domain.Person.Person;
import repository.Contract.ContractRepository;
import repository.PersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

public class ContractService {

    private ContractRepository contractRepository;
    private EntityManager entityManager = PersistenceContext.Factory("UPskillPU");

    public ContractService(){
        this.contractRepository= new ContractRepository(this.entityManager);
    }

    public void save(Contract c){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Contract ncontract = this.contractRepository.save(c);
        tx.commit();
    }

    public Contract findById(Long cId){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Optional<Contract> c = this.contractRepository.findById(cId);
        tx.commit();
        return(c.get());
    }

    public Iterable<Contract> findAll(){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        Iterable<Contract> c = this.contractRepository.findAll();
        tx.commit();
        return(c);
    }

    public void removeContract(Contract c){
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        this.contractRepository.delete(c);
        tx.commit();
    }
}
