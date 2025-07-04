package alessiopanconi.dao;

import alessiopanconi.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private EntityManager entityManager;
    public UtenteDAO(EntityManager entityManager) {this.entityManager = entityManager;}

    public void salvaUtente(Utente nuovoUtente)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(nuovoUtente);
        transaction.commit();

        System.out.println("L'utente: " + nuovoUtente.getNomeUtente() + nuovoUtente.getCognomeUtente() + " è stato creato correttamente");
    }
}
