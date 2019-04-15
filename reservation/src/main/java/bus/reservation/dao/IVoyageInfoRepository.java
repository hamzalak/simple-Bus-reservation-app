package bus.reservation.dao;

import bus.reservation.entities.VoyageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin({"http://localhost:4200"})
@RepositoryRestResource
public interface IVoyageInfoRepository extends JpaRepository<VoyageInfo,Long> {


     public List<VoyageInfo> findByDateDepart(LocalDate localDate) ;

}
