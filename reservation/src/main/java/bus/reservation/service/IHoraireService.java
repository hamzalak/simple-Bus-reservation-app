package bus.reservation.service;

import bus.reservation.dto.ClientFom;
import bus.reservation.dto.ClientResponse;
import bus.reservation.entities.Personne;
import bus.reservation.entities.Place;
import bus.reservation.entities.Reservation;
import bus.reservation.entities.VoyageInfo;

import java.time.LocalDate;
import java.util.List;

public interface IHoraireService {

      List<VoyageInfo> getHoraires(LocalDate localDate) ;
      Personne getPersonne (ClientFom cl) ;
      ClientResponse getClientRespons(List<Place> placesClients , VoyageInfo vi , Reservation res , ClientFom cl);

    }
