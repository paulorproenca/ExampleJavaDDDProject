package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceContext {
    private static EntityManager entityManager;

    public static EntityManager Factory(String persistenceUnitName){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        entityManager = emf.createEntityManager();
        return entityManager;
    }

}
