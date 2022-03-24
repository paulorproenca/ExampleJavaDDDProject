package domain.Person;

import domain.shared.ValueObject;
import util.BusinessValidation;

public class Email implements ValueObject {
    private final String _email;

    public Email(String email){
        BusinessValidation.nonEmpty(email,"email address  should neither be null nor empty");
        BusinessValidation.isEmail(email,"Invalid E-mail format");
        this._email=email;
    }

    /* For ORM purposes */
    protected Email(){
        this._email=null;
    }

    public String email(){
        return this._email;
    }
}
