package domain.Person;

import domain.shared.ValueObject;
import util.BusinessValidation;

public class Email implements ValueObject {
    private final String _email;

    protected Email(String email){
        BusinessValidation.nonEmpty(email,"email address  should neither be null nor empty");
        BusinessValidation.isEmail(email,"Invalid E-mail format");
        this._email=email;
    }

    /* For ORM purposes */
    protected Email(){
        this._email=null;
    }

    protected String email(){
        return this._email;
    }
}
