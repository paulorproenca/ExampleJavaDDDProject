package app;

import application.Person.CreatePersonController;
import domain.Person.Person;

public class test {
    public static void main(String[] args) {

        CreatePersonController ctrl = new CreatePersonController();

        System.out.println("---------------------------------------------------------------------------------");
        
        try {
            Person joe = ctrl.createPerson("9064752-4-02X", "Joe Smith", "joe@mail.upskill.com");
            System.out.println(joe.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------------------------------------------------------------");

        try {
            Person mary = ctrl.createPerson("9564752-4-02X", "Mary Morison", "maryemail");
            System.out.println(mary.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------------------------------------------------------------");

        try {
            Person kim = ctrl.createPerson("9544752-4-02X", "", "Kim@here,com");
            System.out.println(kim.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------------------------------------------------------------");
    }
}
