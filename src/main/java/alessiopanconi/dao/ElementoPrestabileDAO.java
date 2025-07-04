package alessiopanconi.dao;

import alessiopanconi.entities.ElementoPrestabile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ElementoPrestabileDAO {

    private EntityManager entityManager;
    public ElementoPrestabileDAO(EntityManager entityManager) {this.entityManager = entityManager;}

    public void salvaElementoPrestabile(ElementoPrestabile nuovoElemento)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(nuovoElemento);
        transaction.commit();

        System.out.println("l'elemento: "+ nuovoElemento.getTitolo()+" è stato creato correttamente");
    }
}
