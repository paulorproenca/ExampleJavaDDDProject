package app;

import application.Car_Group.CarGroupController;
import application.Car.CarController;
import application.Person.PersonController;
import application.Contract.ContractController;
import domain.Car_Group.CarGroup;
import domain.Car.Car;
import domain.Contract.Contract;
import domain.Person.Person;
import domain.Contract.ContractBuilder;

public class testRentOnWeels {
    public static void main(String[] args) {

        CarGroupController ctrl = new CarGroupController();

        System.out.println("\nCREATE 5 Car Groups Expected: Success-----------------------------------------");
        
        try {
            CarGroup cg1 = ctrl.createCarGroup("Luxury", 4, 100);
            CarGroup cg2 = ctrl.createCarGroup("Utility", 2, 40);
            CarGroup cg3 = ctrl.createCarGroup("Sports", 2, 90);
            CarGroup cg4 = ctrl.createCarGroup("SUV", 4, 80);
            CarGroup cg5 = ctrl.createCarGroup("Commercial", 2, 35);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFINDALL Expected: 5 car groups-------------------------------------------------");

        try {
            Iterable<CarGroup> crowd = ctrl.findAllCarGroup();
            for (CarGroup p : crowd) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCREATE 7 Cars Expected: Success-----------------------------------------");

        CarController carctrl = new CarController();

        try {
            Car c1 = carctrl.createCar("AA-11-BB","BMW", "840",3500,2019,2019,"Sports");
            Car c2 = carctrl.createCar("AB-88-BA","FIAT", "777",2000, 2020, 2015, "SUV");
            Car c3 = carctrl.createCar("AC-12-BC","MERCEDES BENZ", "Serie E",2800, 2017, 2015,"SUV");
            Car c4 = carctrl.createCar("XY-00-UY","LANCIA", "Y",900, 2005, 2000, "Utility");
            Car c5 = carctrl.createCar("XY-12-UY","AUDI", "A4",1600, 2008, 2005, "Utility");
            Car c6 = carctrl.createCar("XY-34-UY","AUDI", "A8",3000, 2015, 2015,"Luxury");
            Car c7 = carctrl.createCar("XP-10-RT","OPEL", "CORSA",1100, 1998, 1995, "Utility");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFINDALL Expected: 7 car groups-------------------------------------------------");

        try {
            Iterable<Car> fleet = carctrl.findAllCar();
            for (Car car : fleet) {
                System.out.println(car.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCREATE [JOE SMITH] Expected: Success-----------------------------------------");

        PersonController ctrlPerson = new PersonController();
        try {
            Person joe = ctrlPerson.createPerson("9064752-4-02X", "Joe Smith", "joe@mail.upskill.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCREATE CONTRACT [JOE SMITH, AB-88-BA] Expected: Success-----------------------------------------");

        ContractController ctrlContract = new ContractController();
        try {
            Contract newOne = ctrlContract.createContract(new ContractBuilder()
                                                                .withPerson("9064752-4-02X")
                                                                .withCar("AB-88-BA")
                                                                .withDriver("Kim Joe",123456,"12-09-2034")
                                                                .withDriver("John White",537612,"01-05-2025")
                                                                .withDriver("Ben Hugh",312421,"09-12-2041")
                                                                .build());
            System.out.println(newOne.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
