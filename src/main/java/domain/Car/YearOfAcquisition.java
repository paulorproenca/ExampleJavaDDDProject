package domain.Car;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class YearOfAcquisition implements ValueObject {
    private final int theAcquitionYear;

    protected YearOfAcquisition(int year){
        BusinessValidation.inRange(year,1950,2022," the year must be between 1950 and 2022");
        this.theAcquitionYear=year;
    }

    /* For ORM purposes */
    protected YearOfAcquisition(){
        this.theAcquitionYear=0;
    }

    protected int year(){
        return this.theAcquitionYear;
    }

}