package alessiopanconi;

import alessiopanconi.dao.ElementoPrestabileDAO;
import alessiopanconi.dao.PrestitoDAO;
import alessiopanconi.dao.UtenteDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UtenteDAO u = new UtenteDAO(em);
        PrestitoDAO p = new PrestitoDAO(em);
        ElementoPrestabileDAO ep = new ElementoPrestabileDAO(em);




    }
}



