package domain.Contract;

import domain.Car.Car;
import domain.Driver.Driver;
import domain.Person.Person;
import util.BusinessValidation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contractID;
    @OneToOne
    private Car car;
    @OneToOne
    private Person person;
    @OneToMany
    private List<Driver> drivers= new ArrayList<>();

    public Contract(ContractBuilder builder){
        this.person=builder.person;
        this.car=builder.car;
        this.drivers=builder.drivers;
    }

    /* For ORM purposes */
    protected Contract(){}

    public boolean sameAs(Object other) {
        return false;
    }

    public Long identity() {
        return this.contractID;
    }

    private String listdrivers()
    {
        String str = "";
        for (Driver d : this.drivers) {
            str = str + "\n\t" + d.toString();
        }
        return str;
    }

    public String toString()
    {
        return "Contact( " +  this.person.toString() +  " | " + this.car.toString() +  " | " + this.listdrivers() + " )";
    }
}

