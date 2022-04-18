package domain.Person;

import domain.shared.Identifiable;
import domain.shared.ValueObject;
import util.BusinessValidation;
import util.HashCoder;
import javax.persistence.Embeddable;

@Embeddable
public class IdentificationNumber implements ValueObject, Comparable<IdentificationNumber> {

    private final String theIdNumber;

    /**
     * Protected constructor. To construct a new IdentificationNumber instance use the
     * {@link #valueOf(String)} method.
     *
     * @param idNumebr
     */
    protected IdentificationNumber(final String idNumber) {
        BusinessValidation.nonEmpty(idNumber,"identification number should neither be null nor empty");
        this.theIdNumber = idNumber;
    }

    // for ORM
    protected IdentificationNumber() {
        this.theIdNumber = null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IdentificationNumber)) {
            return false;
        }

        final IdentificationNumber other = (IdentificationNumber) o;
        return theIdNumber.equals(other.theIdNumber);
    }

    @Override
    public String toString() {
        return theIdNumber;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(theIdNumber).code();
    }

    @Override
    public int compareTo(final IdentificationNumber o) {
        return theIdNumber.compareTo(o.theIdNumber);
    }

}
