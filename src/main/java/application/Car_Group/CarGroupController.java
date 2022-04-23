package application.Car_Group;

import application.Car_Group.CarGroupService;
import domain.Car_Group.CarGroup;


public class CarGroupController {

    private final CarGroupService theService = new CarGroupService();

    public CarGroupController(){}

    public CarGroup createCarGroup(final String name, final int doors, final double price) {
        final CarGroup carGroup = new CarGroup(name, doors, price);
        this.theService.save(carGroup);
        return carGroup;
    }

    public CarGroup findCarGroup(final String name) {
        return this.theService.findByGroupName(name);
    }

    public Iterable<CarGroup> findAllCarGroup(){
        return this.theService.findAll();
    }

    public void removeCarGroup(CarGroup cg){
        this.theService.removePerson(cg);
    }
}
