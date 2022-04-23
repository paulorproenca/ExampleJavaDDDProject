package domain.Car;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class Brand implements ValueObject {
    private final String theBrand;

    protected Brand(String name){
        BusinessValidation.nonEmpty(name,"A car brand should neither be null nor empty");
        this.theBrand=name;
    }

    /* For ORM purposes */
    protected Brand(){
        this.theBrand=null;
    }

    protected String brand(){
        return this.theBrand;
    }

}