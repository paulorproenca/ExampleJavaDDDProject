package domain.Car_Group;

import domain.Person.IdentificationNumber;
import domain.shared.ValueObject;
import util.BusinessValidation;
import util.HashCoder;

import javax.persistence.Embeddable;

@Embeddable
public class GroupName implements ValueObject, Comparable<GroupName>  {
    private final String theName;

    protected GroupName(String name){
        BusinessValidation.nonEmpty(name,"Group name should neither be null nor empty");
        this.theName=name;
    }

    /* For ORM purposes */
    protected GroupName(){
        this.theName=null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GroupName)) {
            return false;
        }

        final GroupName other = (GroupName) o;
        return theName.equals(other.theName);
    }
    @Override
    public int hashCode() {
        return new HashCoder().with(theName).code();
    }

    @Override
    public int compareTo(final GroupName o) {
        return theName.compareTo(o.theName);
    }

    @Override
    public String toString() {
        return this.name();
    }

    protected String name(){
        return this.theName;
    }
}
