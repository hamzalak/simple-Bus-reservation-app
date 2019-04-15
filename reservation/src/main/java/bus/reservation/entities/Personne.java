package bus.reservation.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.* ;

@Entity
public class Personne implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id ;
    @Column
    private String nom ;
    @Column
    private String prenom ;
    @Column
    private Integer age ;
    @Column
    private  Integer nbrDePlaces ;

    @JsonIgnore
    @OneToMany(mappedBy = "personne",fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
    private List<Reservation> reservations ;

    public Personne() {
    }

    public Personne(String nom, String prenom, Integer age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Integer getNbrDePlaces() {
        return nbrDePlaces;
    }

    public void setNbrDePlaces(Integer nbrDePlaces) {
        this.nbrDePlaces = nbrDePlaces;
    }
}
