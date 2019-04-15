package bus.reservation.controller;


import bus.reservation.dao.IPersonneRepository;
import bus.reservation.dao.IPlaceRepository;
import bus.reservation.dao.IReservationRepository;
import bus.reservation.dao.IVoyageInfoRepository;
import bus.reservation.dto.ClientFom;
import bus.reservation.dto.ClientResponse;
import bus.reservation.entities.*;
import bus.reservation.service.IHoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin({"http://localhost:4200"})
public class MyController {


    @Autowired
    IHoraireService iHoraireService ;
    @Autowired
    IPersonneRepository iPersonneRepository ;
    @Autowired
    IVoyageInfoRepository iVoyageInfoRepository ;
    @Autowired
    IReservationRepository iReservationRepository;
    @Autowired
    IPlaceRepository iPlaceRepository ;


  @GetMapping("/horaires/{dt}")
  public ResponseEntity<?> getHorairesDispo(@PathVariable String dt) throws ParseException {


      String dateSt = dt.substring(0,2) + "/"+ dt.substring(2,4) +"/"+dt.substring(4,8) ;

      System.out.println(dateSt);

      LocalDate clientDt = DateUtils.parseDate(dateSt) ;


      List<VoyageInfo> list = iHoraireService.getHoraires(clientDt);


      return new ResponseEntity<List<VoyageInfo>>(list, HttpStatus.OK);



  }

   @PostMapping("/newclient")
    public ResponseEntity<?> reserverTicket(@RequestBody ClientFom cl){

      System.out.println(cl.toString()+"\n");

      Personne per = iHoraireService.getPersonne(cl) ;
      Reservation res = new Reservation() ;
      res.setPersonne(per);
      res.setVoyageInfo( iVoyageInfoRepository.getOne(cl.getIdVoyage()));
      iReservationRepository.save(res) ;
      ///////////////////Recuprer les places de l'objet voyages en fonction du nombre de place /////
      ///////////ce qu'on peut pt etre faire est de supprimer les données et les persister qlq part
       // //// ds une autre table
      VoyageInfo vi = iVoyageInfoRepository.getOne(cl.getIdVoyage()) ;
      List<Place> placesList = vi.getPlaces() ;
      List<Place> placesClients = new ArrayList<>() ;

     if(vi.getPlaces().size()==0) {

         iVoyageInfoRepository.delete(vi) ;
         String message = "pas de place disponible pour ce voyage" ;
         return new ResponseEntity<String>(message,HttpStatus.OK) ;

     }else if(cl.getNbrPlaces()-vi.getPlaces().size() > 0){

          String message = "Il reste que " + vi.getPlaces().size() +" place" ;

         return new ResponseEntity<String>(message,HttpStatus.OK) ;

     }else{
         for (int i = 0; i < cl.getNbrPlaces(); i++) {
             placesClients.add(placesList.get(0));
             placesList.remove(0);
         }
         vi.setPlaces(placesList);
         iVoyageInfoRepository.save(vi) ;
         ClientResponse clientResponse = iHoraireService.getClientRespons(placesClients,vi,res,cl) ;


         return new ResponseEntity<ClientResponse>(clientResponse,HttpStatus.OK ) ;

     }


   }

}
