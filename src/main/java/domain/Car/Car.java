package domain.Car;

import domain.Car_Group.CarGroup;

import javax.persistence.*;

@Entity
public class Car {
    @EmbeddedId
    private CarPlate carPlate;
    private Brand carBrand;
    private CarModel carModel;
    private Cylinder carCylinder;
    private YearOfAcquisition yearOfAquisition;
    private YearOfManufacture yearOfManufacture;
    @OneToOne
    private CarGroup carGroup;

    public Car(String plate, String brand, String model,int cylinder, int yAcquisition, int yManufacture, CarGroup group){
        this.carPlate = new CarPlate(plate);
        this.carBrand = new Brand(brand);
        this.carModel = new CarModel(model);
        this.carCylinder = new Cylinder(cylinder);
        this.yearOfAquisition = new YearOfAcquisition(yManufacture);
        this.yearOfManufacture = new YearOfManufacture(yAcquisition);

        this.carGroup=group;
    }

    /* For ORM purposes */
    protected Car(){}


    public boolean sameAs(Object other) {
        return false;
    }


    public String identity() {
        return this.carPlate.plate();
    }

    public String toString()
    {
        return "Car( " + this.carPlate.plate() + " | " + this.carBrand.brand() +  " | " + this.carModel.model() +  " | " + this.carCylinder.cylinder() +  " | " +this.carGroup.toString() + " )";
    }
}

