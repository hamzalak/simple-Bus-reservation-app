package bus.reservation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Place implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @JsonIgnore
    @ManyToMany(mappedBy = "places" )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
    private List<VoyageInfo> voyageInfos ;


    public Place() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VoyageInfo> getVoyageInfos() {
        return voyageInfos;
    }

    public void setVoyageInfos(List<VoyageInfo> voyageInfos) {
        this.voyageInfos = voyageInfos;
    }
}
