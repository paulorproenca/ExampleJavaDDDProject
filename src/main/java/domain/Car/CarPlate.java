package domain.Car;

import domain.shared.Identifiable;
import domain.shared.ValueObject;
import util.BusinessValidation;
import util.HashCoder;
import javax.persistence.Embeddable;

@Embeddable
public class CarPlate implements ValueObject, Comparable<CarPlate> {

    private final String thePlate;

    /**
     * Protected constructor. To construct a new CarPlate instance use the
     * {@link #valueOf(String)} method.
     *
     * @param plate
     */
    public CarPlate(final String plate) {
        BusinessValidation.nonEmpty(plate,"Car plate should neither be null nor empty");
        this.thePlate = plate;
    }

    // for ORM
    protected CarPlate() {
        this.thePlate = null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarPlate)) {
            return false;
        }

        final CarPlate other = (CarPlate) o;
        return thePlate.equals(other.thePlate);
    }

    @Override
    public String toString() {
        return plate();
    }

    public String plate() {
        return this.thePlate;
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(thePlate).code();
    }

    @Override
    public int compareTo(final CarPlate o) {
        return thePlate.compareTo(o.thePlate);
    }

}
