package domain.Driver;

import javax.persistence.*;

@Entity
public class Driver {

    @EmbeddedId
    private DriverLicense driverLicense;
    private DriverName driverName;

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public Driver(final String name, final long licenseNumber, final String licenseDate){
        this.driverName=new DriverName(name);
        this.driverLicense = new DriverLicense(licenseNumber, licenseDate);
    }

    protected Driver(){}

    public boolean sameAs(Object other) {
        return false;
    }

    public Long identity() {
        return  (long) this.driverLicense.hashCode();
    }

    public String toString()
    {
        return "Driver( " +  this.driverName.name() +  " | " + this.driverLicense.toString() + " )";
    }
}
