package alessiopanconi.dao;

import alessiopanconi.entities.ElementoPrestabile;
import alessiopanconi.entities.exceptions.ElementoNonTrovato;
import alessiopanconi.entities.exceptions.ElementoNonTrovatoPerIdException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElementoPrestabileDAO {

    private EntityManager entityManager;

    public ElementoPrestabileDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvaElementoPrestabile(ElementoPrestabile nuovoElemento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(nuovoElemento);
        transaction.commit();

        System.out.println("L'elemento: " + nuovoElemento.getTitolo() + " è stato aggiunto al catalogo");
    }

    public ElementoPrestabile trovaElementoPrestabilePerId(long elementoPrestabileId) {
        ElementoPrestabile found = entityManager.find(ElementoPrestabile.class, elementoPrestabileId);
        if (found == null) throw new ElementoNonTrovatoPerIdException(elementoPrestabileId);
        return found;
    }

    public void rimozioneElementoCatalogoPerIsbn(long codiceIsbn) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM ElementoPrestabile a WHERE a.codiceIsbn = :codiceIsbn");
        query.setParameter("codiceIsbn", codiceIsbn);
        transaction.commit();
        System.out.println("L'elemento è stato rimosso");
    }

    public List<ElementoPrestabile> ricercaElementoPrestabilePerIsbn(long codiceIsbn) {
        TypedQuery<ElementoPrestabile> query = entityManager.createQuery("SELECT a FROM ElementoPrestabile a WHERE a.codiceIsbn = :codiceIsbn", ElementoPrestabile.class);
        query.setParameter("codiceIsbn", codiceIsbn);
        if (query.getResultList().isEmpty()) throw new ElementoNonTrovato();
        return query.getResultList();
    }

    public List<ElementoPrestabile> ricercaElementoPrestabilePerAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<ElementoPrestabile> query = entityManager.createQuery("SELECT a FROM ElementoPrestabile a WHERE a.annoPubblicazione = :annoPubblicazione", ElementoPrestabile.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        if (query.getResultList().isEmpty()) throw new ElementoNonTrovato();
        return query.getResultList();
    }

    public List<ElementoPrestabile> ricercaElementoPrestabilePerAutore(String autore) {
        TypedQuery<ElementoPrestabile> query = entityManager.createQuery("SELECT a FROM ElementoPrestabile a WHERE LOWER(a.autore) LIKE LOWER(:autore)", ElementoPrestabile.class);
        query.setParameter("autore", autore);
        if (query.getResultList().isEmpty()) throw new ElementoNonTrovato();
        return query.getResultList();
    }

    public List<ElementoPrestabile> ricercaElementoPrestabilePerTitolo(String titolo) {
        TypedQuery<ElementoPrestabile> query = entityManager.createQuery("SELECT a FROM ElementoPrestabile a WHERE LOWER(a.titolo) LIKE LOWER(:titolo)", ElementoPrestabile.class);
        query.setParameter("titolo", "%" + titolo + "%");
        if (query.getResultList().isEmpty()) throw new ElementoNonTrovato();
        return query.getResultList();
    }

    public List<ElementoPrestabile> ricercaElementiInPrestitoConNumeroTessera(long numeroDiTessera) {
        TypedQuery<ElementoPrestabile> query = entityManager.createQuery("SELECT a.elementoPrestabile FROM Prestito a WHERE a.utente.numeroDiTessera =:numeroDiTessera", ElementoPrestabile.class);
        query.setParameter("numeroDiTessera", numeroDiTessera);
        if (query.getResultList().isEmpty()) throw new ElementoNonTrovato();
        return query.getResultList();
    }
}

