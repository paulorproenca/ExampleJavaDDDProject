package app;

import application.Person.PersonController;
import domain.Person.Person;

public class setup {
    public static void main(String[] args) {

        PersonController ctrl = new PersonController();

        System.out.println("\nCREATE [JOE SMITH] Expected: Success-----------------------------------------");

        try {
            Person joe = ctrl.createPerson("9064752-4-02X", "Joe Smith", "joe@mail.upskill.com");
            System.out.println(joe.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCREATE [ANNA JONES] Expected: Success----------------------------------------");

        try {
            Person kkk = ctrl.createPerson("40t2234-5-04X", "Anna Jones", "ajones@mail.upskill.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFINDALL Expected: Joe & Anna-------------------------------------------------");

        try {
            Iterable<Person> crowd = ctrl.findAllPerson();
            for (Person p : crowd) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
