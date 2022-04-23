package domain.Car_Group;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class Price implements ValueObject {
    private final double theValue;

    protected Price(double value){
        BusinessValidation.nonNegative(value,"Price should not be negative");
        this.theValue=value;
    }

    /* For ORM purposes */
    protected Price(){
        this.theValue=0;
    }

    protected double price(){
        return this.theValue;
    }

}
