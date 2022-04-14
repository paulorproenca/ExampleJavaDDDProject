package repository;

import domain.Person.Person;
import javax.persistence.*;

public class PersonRepositiry
{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("UPskillPU");

    public PersonRepositiry(){}

    public void add(Person p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        em.close();
    }

}



