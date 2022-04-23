package domain.Car;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class YearOfManufacture implements ValueObject {
    private final int theManufactureYear;

    protected YearOfManufacture(int year){
        BusinessValidation.inRange(year,1950,2022," the year must be between 1950 and 2022");
        this.theManufactureYear=year;
    }

    /* For ORM purposes */
    protected YearOfManufacture(){
        this.theManufactureYear=0;
    }

    protected int year(){
        return this.theManufactureYear;
    }

}