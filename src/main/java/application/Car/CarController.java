package application.Car;

import application.Car_Group.CarGroupService;
import domain.Car_Group.CarGroup;
import domain.Car.Car;


public class CarController {

    private final CarService theService = new CarService();

    public CarController(){}

    public Car createCar(final String plate, final String brand, final String model, final int cylinder, final int yaq, final int ymanuf, final String group) {

        CarGroupService theCarGroupService = new CarGroupService();
        CarGroup carGroup=theCarGroupService.findByGroupName(group);

        final Car car = new Car(plate, brand, model, cylinder, yaq, ymanuf, carGroup);
        this.theService.save(car);
        return car;
    }

    public Car findCar(final String plate) {
        return this.theService.findById(plate);
    }

    public Iterable<Car> findAllCar(){
        return this.theService.findAll();
    }

    public void removeCar(Car c){
        this.theService.removePerson(c);
    }
}
