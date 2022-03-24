package domain.Person;

import domain.shared.Identifiable;
import domain.shared.ValueObject;
import util.BusinessValidation;
import util.HashCoder;

public class IdentificationNumber implements ValueObject, Comparable<IdentificationNumber> {

    private final String _idNumber;

    /**
     * Protected constructor. To construct a new IdentificationNumber instance use the
     * {@link #valueOf(String)} method.
     *
     * @param idNumebr
     */
    protected IdentificationNumber(final String idNumber) {
        BusinessValidation.nonEmpty(idNumber,"identification number should neither be null nor empty");
        this._idNumber = idNumber;
    }

    // for ORM
    protected IdentificationNumber() {
        this._idNumber = null;
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
        return _idNumber.equals(other._idNumber);
    }

    @Override
    public String toString() {
        return _idNumber;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(_idNumber).code();
    }

    @Override
    public int compareTo(final IdentificationNumber o) {
        return _idNumber.compareTo(o._idNumber);
    }

}
