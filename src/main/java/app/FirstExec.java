package app;

import application.Person.PersonController;
import domain.Person.Person;

public class FirstExec {
    public static void main(String[] args) {

        PersonController ctrl = new PersonController();


        System.out.println("\nUPDATE [ANNA JONES] Expected: Success----------------------------------------");

        try {
            Person newAnna = ctrl.updateEmail("40t2234-5-04X","annajones@mail.upskill.com");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFIND [ANNA JONES] Expected: Success----------------------------------------");

        try {
            Person anna = ctrl.findPerson("40t2234-5-04X");
            System.out.println(anna.toString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
