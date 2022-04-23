package repository.Contract;

import domain.Contract.Contract;
import repository.Shared.BaseRepository;

import javax.persistence.EntityManager;

public class ContractRepository extends BaseRepository<Long, Contract>
{
    public ContractRepository(EntityManager theEntityManager){
        super(theEntityManager);
    }
}



