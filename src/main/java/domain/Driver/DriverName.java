package domain.Driver;

import domain.shared.ValueObject;
import util.BusinessValidation;

public class DriverName implements ValueObject {
    private final String theDriverName;

    protected DriverName(String name){
        BusinessValidation.nonEmpty(name,"Driver name should neither be null nor empty");
        this.theDriverName=name;
    }

    /* For ORM purposes */
    protected DriverName(){
        this.theDriverName=null;
    }

    protected String name(){
        return this.theDriverName;
    }
}
