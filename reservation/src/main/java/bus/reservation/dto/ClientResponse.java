package bus.reservation.dto;


import bus.reservation.entities.Place;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/*
* Date voyage
* heure voyage
* nom
* prenom
* places
*numero de reservation
*
* */
//ville de départe ville d'arrivé
public class ClientResponse {

    private LocalDate dateVoyage ;
    private LocalTime heureVoyage ;
    private String nom ;
    private String prenom ;
    private Long numeroReservation ;
    private List<Place> places ;


    public LocalDate getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(LocalDate dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    public LocalTime getHeureVoyage() {
        return heureVoyage;
    }

    public void setHeureVoyage(LocalTime heureVoyage) {
        this.heureVoyage = heureVoyage;
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

    public Long getNumeroReservation() {
        return numeroReservation;
    }

    public void setNumeroReservation(Long numeroReservation) {
        this.numeroReservation = numeroReservation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "dateVoyage=" + dateVoyage +
                ", heureVoyage=" + heureVoyage +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroReservation=" + numeroReservation +
                ", places=" + places +
                '}';
    }
}
