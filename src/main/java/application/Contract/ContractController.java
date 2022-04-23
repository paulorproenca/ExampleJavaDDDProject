package application.Contract;


import domain.Contract.Contract;



public class ContractController {

    private final ContractService theService = new ContractService();

    public ContractController(){}

    public Contract createContract(Contract contract) {
        this.theService.save(contract);
        return contract;
    }

    public Contract findContract(final Long id) {
        return this.theService.findById(id);
    }

    public Iterable<Contract> findAllCar(){
        return this.theService.findAll();
    }

    public void removeCar(Contract c){
        this.theService.removeContract(c);
    }
}
