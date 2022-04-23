package domain.Driver;

import domain.Person.IdentificationNumber;
import domain.shared.ValueObject;
import util.BusinessValidation;
import util.HashCoder;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

@Embeddable
public class DriverLicense implements ValueObject, Comparable<DriverLicense>{
    private final long licenseNumber;
    private final String licenseDate;

    public DriverLicense(final long num, final String date){
        BusinessValidation.nonValid(String.valueOf(num),"^[1-9][0-9]{5,8}$","Driver licence number is not valid");
        this.licenseNumber=num;
        this.licenseDate=date;
    }

    protected DriverLicense(){
        this.licenseDate=null;
        this.licenseNumber=0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DriverLicense)) {
            return false;
        }

        final DriverLicense other = (DriverLicense) o;
        return (licenseNumber == other.licenseNumber) && (licenseDate.equals(other.licenseDate));
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(licenseNumber).with(licenseDate).code();
    }

    @Override
    public int compareTo(final DriverLicense o) {
        return licenseDate.compareTo(o.licenseDate);
    }

    @Override
    public String toString()
    {
        return "License( " +  this.licenseNumber +  " | " + this.licenseDate + " )";
    }
}
