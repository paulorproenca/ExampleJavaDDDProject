package domain.Car;

import domain.shared.ValueObject;
import util.BusinessValidation;

import javax.persistence.Embeddable;


    @Embeddable
    public class Cylinder implements ValueObject {
        private final int theCylinder;

        protected Cylinder(int cylinder){
            BusinessValidation.nonNegative((double) cylinder,"Cylinder must be positive");
            this.theCylinder=cylinder;
        }

        /* For ORM purposes */
        protected Cylinder(){
            this.theCylinder=0;
        }

        protected int cylinder(){
            return this.theCylinder;
        }

    }