package domain.Contract;

import domain.Car.Car;
import domain.Driver.Driver;
import domain.Person.Person;
import application.Car.CarService;
import application.Person.PersonService;

import java.util.ArrayList;
import java.util.List;

public class ContractBuilder {
    protected Car car;
    protected Person person;
    protected List<Driver> drivers= new ArrayList<>();

    public ContractBuilder(){    }

    public ContractBuilder withCar(final String plate){
        CarService theCarService = new CarService();
        this.car = theCarService.findByPlate(plate);
        return this;
    }

    public ContractBuilder withPerson(final String personID){
        PersonService thePersonService = new PersonService();
        this.person = thePersonService.findByIdNumber(personID);
        return this;
    }

    public ContractBuilder withDriver(String n, long dlnum, String dldate){
        drivers.add(new Driver(n, dlnum, dldate));
        return this;
    }

    public Contract build(){
        return new Contract(this);
    }
}

