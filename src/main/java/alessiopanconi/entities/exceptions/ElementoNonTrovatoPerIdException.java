package alessiopanconi.entities.exceptions;

public class ElementoNonTrovatoPerIdException extends RuntimeException {
    public ElementoNonTrovatoPerIdException(long id) {super("Il record con id " + id + " non è stato trovato!");}
}
