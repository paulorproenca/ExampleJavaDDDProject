package domain.Person;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;

@Embeddable
public class Email implements ValueObject {
    private final String theEmail;

    protected Email(String email){
        BusinessValidation.nonEmpty(email,"email address  should neither be null nor empty");
        BusinessValidation.isEmail(email,"Invalid E-mail format");
        this.theEmail=email;
    }

    /* For ORM purposes */
    protected Email(){
        this.theEmail=null;
    }

    protected String email(){
        return this.theEmail;
    }
}
