package bus.reservation.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reservation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @ManyToOne
    private Personne personne ;
    @ManyToOne
    private VoyageInfo voyageInfo ;


    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public VoyageInfo getVoyageInfo() {
        return voyageInfo;
    }

    public void setVoyageInfo(VoyageInfo voyageInfo) {
        this.voyageInfo = voyageInfo;
    }
}
