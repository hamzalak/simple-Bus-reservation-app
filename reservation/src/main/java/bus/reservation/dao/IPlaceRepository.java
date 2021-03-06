package bus.reservation.dao;

import bus.reservation.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin({"http://localhost:4200"})
@RepositoryRestResource
public interface IPlaceRepository extends JpaRepository<Place,Long> {
}
