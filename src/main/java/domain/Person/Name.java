package domain.Person;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class Name implements ValueObject {
    private final String theName;

    protected Name(String name){
        BusinessValidation.nonEmpty(name,"person name should neither be null nor empty");
        this.theName=name;
    }

    /* For ORM purposes */
    protected Name(){
        this.theName=null;
    }

    protected String name(){
        return this.theName;
    }

}
