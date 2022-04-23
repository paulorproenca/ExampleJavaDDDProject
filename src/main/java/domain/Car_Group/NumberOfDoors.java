package domain.Car_Group;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class NumberOfDoors implements ValueObject {
    private final int theNumber;

    protected NumberOfDoors(int number){
        BusinessValidation.inRange(number,2,7,"Number of doors should be between 2 and 7");
        this.theNumber=number;
    }

    /* For ORM purposes */
    protected NumberOfDoors(){
        this.theNumber=0;
    }

    protected int doors(){
        return this.theNumber;
    }
}
