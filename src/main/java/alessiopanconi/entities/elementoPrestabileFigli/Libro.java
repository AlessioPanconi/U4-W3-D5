package alessiopanconi.entities.elementoPrestabileFigli;

import alessiopanconi.entities.ElementoPrestabile;
import alessiopanconi.entities.enums.Genere;
import jakarta.persistence.*;

@Entity
@Table
public class Libro extends ElementoPrestabile {

    @Column(name = "autore")
    private String autore;
    @Column(name = "genere")
    @Enumerated(EnumType.STRING)
    private Genere genere;

    //COSTRUTTORE
    public Libro(){}
    public Libro(long codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //GETTER
    public String getAutore() {
        return autore;
    }
    public Genere getGenere() {
        return genere;
    }
    //SETTER
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "elementoPrestabileId=" + elementoPrestabileId +
                ", codiceIsbn=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
