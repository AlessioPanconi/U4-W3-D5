package alessiopanconi.entities.elementoPrestabileFigli;

import alessiopanconi.entities.ElementoPrestabile;
import alessiopanconi.entities.enums.Periodicita;
import jakarta.persistence.*;

@Entity
@Table
public class Rivista extends ElementoPrestabile {

    @Column(name = "periodicita")
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    //COSTRUTTORE
    public Rivista(){}
    public Rivista(long codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine,Periodicita periodicita ) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    //GETTER
    public Periodicita getPeriodicita() {
        return periodicita;
    }
    //SETTER
    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "elementoPrestabileId=" + elementoPrestabileId +
                ", codiceIsbn=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", periodicita=" + periodicita +
                '}';
    }
}
