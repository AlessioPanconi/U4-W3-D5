package alessiopanconi.dao;

import alessiopanconi.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {

    private EntityManager entityManager;
    public PrestitoDAO(EntityManager entityManager) {this.entityManager = entityManager;}

    public void salvaPrestito(Prestito nuovoPrestito)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(nuovoPrestito);
        transaction.commit();

        System.out.println("L'utente: " + nuovoPrestito.getUtente().getNomeUtente() + nuovoPrestito.getUtente().getCognomeUtente()+ " ha correttamente preso in prestito: "+ nuovoPrestito.getElementoPrestabile().getTitolo());
    }


}
