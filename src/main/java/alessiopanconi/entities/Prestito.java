package alessiopanconi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito")
public class Prestito {

    @Id
    @GeneratedValue
    @Column(name = "prestito_id")
    private long prestitoId;
    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    //RELAZIONI
    //UTENTE
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    //ELEMENTOPRESTABILE
    @OneToOne
    @JoinColumn(name = "elemento_prestabile_id")
    private ElementoPrestabile elementoPrestabile;

    //COSTRUTTORE
    public Prestito(){}
    public Prestito(LocalDate dataInizioPrestito, LocalDate dataRestituzioneEffettiva,Utente utente, ElementoPrestabile elementoPrestabile) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
        this.utente = utente;
        this.elementoPrestabile = elementoPrestabile;
    }

    //GETTER
    public long getPrestitoId() {
        return prestitoId;
    }
    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }
    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }
    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }
    public Utente getUtente() {
        return utente;
    }
    public ElementoPrestabile getElementoPrestabile() {
        return elementoPrestabile;
    }

    //SETTER
    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }
    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "prestitoId=" + prestitoId +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                ", utente=" + utente +
                ", elementoPrestabile=" + elementoPrestabile +
                '}';
    }
}
