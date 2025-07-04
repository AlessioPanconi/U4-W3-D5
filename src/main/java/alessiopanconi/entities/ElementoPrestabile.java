package alessiopanconi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "elemento_prestabile")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ElementoPrestabile {

    @Id
    @GeneratedValue
    @Column(name = "elemento_prestabile_id")
    protected long elementoPrestabileId;
    @Column(name = "codice_isbn")
    protected long codiceIsbn;
    @Column(name = "titolo")
    protected String titolo;
    @Column(name = "anno_pubblicazione")
    protected int annoPubblicazione;
    @Column(name = "numero_pagine")
    protected int numeroPagine;

    //Costruttore
    public ElementoPrestabile(){}
    public ElementoPrestabile(long codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    //GETTER
    public long getCodiceIsbn() {
        return codiceIsbn;
    }
    public String getTitolo() {
        return titolo;
    }
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public int getNumeroPagine() {
        return numeroPagine;
    }

    //SETTER
    public void setCodiceIsbn(long codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
