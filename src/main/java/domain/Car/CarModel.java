package domain.Car;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class CarModel implements ValueObject {
    private final String theModel;

    protected CarModel(String name){
        BusinessValidation.nonEmpty(name,"A car model should neither be null nor empty");
        this.theModel=name;
    }

    /* For ORM purposes */
    protected CarModel(){
        this.theModel=null;
    }

    protected String model(){
        return this.theModel;
    }

}