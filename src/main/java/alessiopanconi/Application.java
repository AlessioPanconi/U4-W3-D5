package alessiopanconi;

import alessiopanconi.dao.ElementoPrestabileDAO;
import alessiopanconi.dao.PrestitoDAO;
import alessiopanconi.dao.UtenteDAO;
import alessiopanconi.entities.ElementoPrestabile;
import alessiopanconi.entities.Prestito;
import alessiopanconi.entities.Utente;
import alessiopanconi.entities.elementoPrestabileFigli.Libro;
import alessiopanconi.entities.elementoPrestabileFigli.Rivista;
import alessiopanconi.entities.enums.Genere;
import alessiopanconi.entities.enums.Periodicita;
import alessiopanconi.entities.exceptions.ElementoNonTrovato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        UtenteDAO u = new UtenteDAO(em);
        PrestitoDAO p = new PrestitoDAO(em);
        ElementoPrestabileDAO ep = new ElementoPrestabileDAO(em);

        Utente pietro = new Utente("Pietro","Storti", LocalDate.of(1980,10,13),778);
        Utente pierino = new Utente("Pierino","Rossi",LocalDate.of(2000,4,20),118);
        Utente giovanni = new Utente("Giovanni","Farfai",LocalDate.of(2004,11,20),104);
        Utente alessio = new Utente("Alessio","Panconi",LocalDate.of(2004,12,13),777);

        Libro l1 = new Libro(10101010,"Il Signore delle mosche",1954,250,"William Golding",Genere.NARRATIVA);
        Libro l2 = new Libro(01010101,"La cattedrale sul mare",2006,642,"Ildefonso Falcones",Genere.ROMANZOSTORICO);
        Libro l3 = new Libro(11100010,"Il signore degli anelli",1970,2000,"J. R. R. Tolkien",Genere.FANTASY);
        Rivista r1 = new Rivista(54672823,"Settimanale GIALLO",2013,100, Periodicita.SETTIMANALE);
        Rivista r2 = new Rivista(44445555,"FOCUS Junior",2004,80,Periodicita.MENSILE);

//        u.salvaUtente(pietro);
//        u.salvaUtente(pierino);
//        u.salvaUtente(giovanni);
//        u.salvaUtente(alessio);

//        ep.salvaElementoPrestabile(l1);
//        ep.salvaElementoPrestabile(l2);
//        ep.salvaElementoPrestabile(l3);
//        ep.salvaElementoPrestabile(r1);
//        ep.salvaElementoPrestabile(r2);

            Utente utenteFromDb1 = u.trovaUtentePerId(102);
            Utente utenteFromDb2 = u.trovaUtentePerId(103);
            Utente utenteFromDb3 = u.trovaUtentePerId(104);
            Utente utenteFromDb4 = u.trovaUtentePerId(105);

            ElementoPrestabile elementoPrestabilefromDb1 = ep.trovaElementoPrestabilePerId(302);
            ElementoPrestabile elementoPrestabilefromDb2 = ep.trovaElementoPrestabilePerId(303);
            ElementoPrestabile elementoPrestabilefromDb3 = ep.trovaElementoPrestabilePerId(304);
            ElementoPrestabile elementoPrestabilefromDb4 = ep.trovaElementoPrestabilePerId(305);
            ElementoPrestabile elementoPrestabilefromDb5 = ep.trovaElementoPrestabilePerId(306);


        Prestito p1 = new Prestito(LocalDate.of(2020,10,20),LocalDate.of(2020,10,29),utenteFromDb1,elementoPrestabilefromDb1);
        Prestito p2 = new Prestito(LocalDate.of(2010,10,20),LocalDate.of(2020,1,15),utenteFromDb2,elementoPrestabilefromDb2);
        Prestito p3 = new Prestito(LocalDate.of(2015,10,20),LocalDate.of(2015,12,13),utenteFromDb4,elementoPrestabilefromDb3);
        Prestito p4 = new Prestito(LocalDate.of(2017,10,20),LocalDate.of(2017,11,1),utenteFromDb3,elementoPrestabilefromDb5);

//        p.salvaPrestito(p1);
//        p.salvaPrestito(p2);
//        p.salvaPrestito(p3);
//        p.salvaPrestito(p4);

        //Li ho provati uno alla volta perchè sennò se trovo prima un errore esce e va nel catch
        try{
//        ep.ricercaElementoPrestabilePerIsbn(10101010).forEach(System.out::println);
//        ep.ricercaElementoPrestabilePerIsbn(55555555).forEach(System.out::println);
//        ep.ricercaElementoPrestabilePerAnnoPubblicazione(2013).forEach(System.out::println);
//        ep.ricercaElementoPrestabilePerAnnoPubblicazione(2030).forEach(System.out::println);
//        ep.ricercaElementoPrestabilePerAutore("J. R. R. Tolkien").forEach(System.out::println);
//        ep.ricercaElementoPrestabilePerTitolo("Il signore degli anelli").forEach(System.out::println);
//        ep.ricercaElementoPrestabilePerTitolo("Il").forEach(System.out::println);
        }catch(ElementoNonTrovato ex)
        {
            System.out.println(ex.getMessage());
        }

//        ep.rimozioneElementoCatalogoPerIsbn(44445555);
    }
}



