package bus.reservation;

import bus.reservation.dao.IPersonneRepository;
import bus.reservation.dao.IPlaceRepository;
import bus.reservation.dao.IReservationRepository;
import bus.reservation.dao.IVoyageInfoRepository;
import bus.reservation.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@SpringBootApplication
public class ReservationApplication {

	@Autowired
	IPlaceRepository iPlaceRepository ;

	 @Autowired
	IVoyageInfoRepository iVoyageInfoRepository ;

     @Autowired
	IReservationRepository iReservationRepository;

     @Autowired
	IPersonneRepository iPersonneRepository ;

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

	@Bean
	CommandLineRunner start(){


		return  args->{

			/////Instanciation d'un nouveau voyage///////
            iPlaceRepository.deleteAll();
            iPersonneRepository.deleteAll();
            iReservationRepository.deleteAll();
            iVoyageInfoRepository.deleteAll();
			LocalDate dateVoyage1 = DateUtils.parseDate("20/05/2019") ;
			LocalTime timeVoyage1 = DateUtils.parseTime("12:30") ;
			VoyageInfo voyageInfo1 = new VoyageInfo(dateVoyage1,timeVoyage1) ;
			LocalDate dateVoyage2 = DateUtils.parseDate("20/05/2019") ;
			LocalTime timeVoyage2 = DateUtils.parseTime("17:30") ;
			VoyageInfo voyageInfo2 = new VoyageInfo(dateVoyage2,timeVoyage2) ;
			LocalDate dateVoyage3 = DateUtils.parseDate("20/05/2019") ;
			LocalTime timeVoyage3 = DateUtils.parseTime("20:30") ;
			VoyageInfo voyageInfo3 = new VoyageInfo(dateVoyage3,timeVoyage3) ;
			iVoyageInfoRepository.save(voyageInfo1) ;
			iVoyageInfoRepository.save(voyageInfo2) ;
			iVoyageInfoRepository.save(voyageInfo3) ;

			///// Creation d'une Liste de voyage ///////////////////////////

            List<VoyageInfo> listVoyage = Arrays.asList(voyageInfo1 ,voyageInfo2,voyageInfo3) ;

            /////Instanciation des places de voyage /////////////

			ArrayList<Place> listPlace = new ArrayList<>() ;

			for(int i = 1 ; i <= 20 ; i++ ){
			 	 Place p = new Place() ;
			 	 listPlace.add(p) ;
			 	 iPlaceRepository.save(p) ;
			 }

			listVoyage.stream().forEach(voyage -> {

			 	 voyage.setPlaces(listPlace);

			 	 iVoyageInfoRepository.save(voyage) ;

			 });

			////////////////////Personne/////////////////////////

			Personne per = new Personne( "Santos", "hamoud", 54)  ;
			Personne per2 = new Personne( "Santos", "hamoud", 54)  ;

			iPersonneRepository.save(per) ;
			iPersonneRepository.save(per2) ;


			////////////////////Reservation //////////////////////

			Reservation res1 = new Reservation() ;
			Reservation res2 = new Reservation() ;

			res1.setVoyageInfo(voyageInfo1);
			List<Reservation>  reservations = new ArrayList<>();
            reservations.add(res1) ;
			reservations.add(res2) ;
			reservations.stream().forEach( reservation ->{
				reservation.setPersonne(per) ;
				reservation.setVoyageInfo(voyageInfo1);
 				iReservationRepository.save(reservation) ;
			});





		} ;
	}

}
