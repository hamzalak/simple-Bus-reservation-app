package bus.reservation.service;

import bus.reservation.dao.IPersonneRepository;
import bus.reservation.dao.IVoyageInfoRepository;
import bus.reservation.dto.ClientFom;
import bus.reservation.dto.ClientResponse;
import bus.reservation.entities.Personne;
import bus.reservation.entities.Place;
import bus.reservation.entities.Reservation;
import bus.reservation.entities.VoyageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class HoraireService implements  IHoraireService {

@Autowired
    IVoyageInfoRepository iVoyageInfoRepository ;

@Autowired
    IPersonneRepository iPersonneRepository ;

  @Override
    public List<VoyageInfo> getHoraires(LocalDate localDate){

       List<VoyageInfo> list = iVoyageInfoRepository.findByDateDepart(localDate) ;

       return list;


    }

   @Override
   public Personne getPersonne(ClientFom cl){

       Personne per = new Personne() ;
       per.setAge(cl.getAge());
       per.setNom(cl.getNom());
       per.setPrenom(cl.getPrenom());
       per.setNbrDePlaces(cl.getNbrPlaces());
       iPersonneRepository.save(per) ;

    return  per ;

   }

   @Override
    public ClientResponse getClientRespons(List<Place> placesClients , VoyageInfo vi , Reservation res , ClientFom cl){

       ClientResponse clientResponse = new ClientResponse() ;
       clientResponse.setPlaces(placesClients);
       clientResponse.setDateVoyage(vi.getDateDepart());
       clientResponse.setHeureVoyage(vi.getHeureDepart());
       clientResponse.setNumeroReservation(res.getId());
       clientResponse.setNom(cl.getNom()) ;
       clientResponse.setPrenom(cl.getPrenom()) ;

      return  clientResponse ;
   }

}
