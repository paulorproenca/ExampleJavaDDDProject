package domain.Car_Group;

import javax.persistence.*;

@Entity
public class CarGroup {
    @EmbeddedId
    private GroupName groupName;
    private NumberOfDoors numDoors;
    private Price groupPrice;

    public CarGroup(String name, int doors, double price){
        this.groupName = new GroupName(name);
        this.numDoors=new NumberOfDoors(doors);
        this.groupPrice=new Price(price);
    }

    /* For ORM purposes */
    protected CarGroup(){}

    public boolean sameAs(Object other) {
        return false;
    }

    public String identity() {
        return this.groupName.name();
    }

    public String toString()
    {
        return "Car_Group( " + this.groupName.name() + " | " + this.numDoors.doors() +  " | " + this.groupPrice.price() + " )";
    }
}

