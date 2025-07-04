package alessiopanconi.entities.exceptions;

public class ElementoNonTrovato extends RuntimeException {
    public ElementoNonTrovato() {
        super("La ricerca ha portato ad un errore");
    }
}
