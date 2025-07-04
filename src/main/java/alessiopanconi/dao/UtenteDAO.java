package alessiopanconi.dao;

import alessiopanconi.entities.Utente;
import alessiopanconi.entities.exceptions.ElementoNonTrovatoPerIdException;
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

        System.out.println("L'utente: " + nuovoUtente.getNomeUtente() +""+ nuovoUtente.getCognomeUtente() + " è stato creato correttamente");
    }
    public Utente trovaUtentePerId (long utenteId)
    {
        Utente found = entityManager.find(Utente.class, utenteId);
        if (found == null) throw new ElementoNonTrovatoPerIdException(utenteId);
        return found;
    }
}
