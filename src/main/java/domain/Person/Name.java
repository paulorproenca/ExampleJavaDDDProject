package domain.Person;

import domain.shared.ValueObject;
import util.BusinessValidation;

public class Name implements ValueObject {
    private final String _name;

    protected Name(String name){
        BusinessValidation.nonEmpty(name,"person name should neither be null nor empty");
        this._name=name;
    }

    /* For ORM purposes */
    protected Name(){
        this._name=null;
    }

    protected String name(){
        return this._name;
    }

}
