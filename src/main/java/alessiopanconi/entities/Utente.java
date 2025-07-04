package alessiopanconi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @GeneratedValue
    @Column(name = "utente_id")
    private long utenteId;
    @Column(name = "nome_utente")
    private String nomeUtente;
    @Column(name = "cognome_utente")
    private String cognomeUtente;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;
    @Column(name = "numero_di_tessera")
    private long numeroDiTessera;
    //RELAZIONI
    //PRESTITO
    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    //COSTRUTTORI
    public Utente(){}
    public Utente(String nomeUtente, String cognomeUtente, LocalDate dataDiNascita, long numeroDiTessera) {
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTessera = numeroDiTessera;
    }

    //GETTER
    public long getUtenteId() {
        return utenteId;
    }
    public String getNomeUtente() {
        return nomeUtente;
    }
    public String getCognomeUtente() {
        return cognomeUtente;
    }
    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }
    public long getNumeroDiTessera() {
        return numeroDiTessera;
    }
    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    //SETTER
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }
    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }
    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
    public void setNumeroDiTessera(long numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "utenteId=" + utenteId +
                ", nomeUtente='" + nomeUtente + '\'' +
                ", cognomeUtente='" + cognomeUtente + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera +
                ", prestiti=" + prestiti +
                '}';
    }
}
