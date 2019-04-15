package bus.reservation.dao;

import bus.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin({"http://localhost:4200"})
@RepositoryRestResource
public interface IReservationRepository extends JpaRepository<Reservation,Long> {


}
