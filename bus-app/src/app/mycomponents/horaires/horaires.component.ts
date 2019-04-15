import { Component, OnInit, Input } from '@angular/core';
import { BusServiceService } from '../../myservices/bus-service.service';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-horaires', //<app-horaires> </app-horaires>
  templateUrl: './horaires.component.html',
  styleUrls: ['./horaires.component.css']
})
export class HorairesComponent implements OnInit {

  ngOnInit() {

  }

  constructor(private busService: BusServiceService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {

    this.changeUrl();

  }
  ok: boolean = true;
  listeHoraires;
  verifVoyage: boolean = true;
  urlVoyage: string = "http://localhost:9090/donper/" ;

//////////////////////Obtention des information et horaires das voyages disponibles en un jour donné///////
  getHoraires(url) {

    this.busService.getRessources(url).subscribe(data => {
      this.listeHoraires = data;
      this.listeHoraires.length === 0 ? this.verifVoyage = false : this.verifVoyage = true;
    }, err => {
      this.ok = err.ok
      console.log(err.ok);
    });

  }
///////////////////////////////souscription au router actif et obtention de son url///////////
  changeUrl() {

    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        let url: string = atob(this.activatedRoute.snapshot.params.infoUrl);
        this.getHoraires(url);

      }
    });

  }

  ////////////////////////////////Fournir le id du voyage au router pour garder le id du voyage donné pour la reservation//////////
  goToReservation(id: number) {

    let urlEnd = this.urlVoyage+id ; 
    this.router.navigateByUrl("/perso/" + btoa(urlEnd))  ;

  }




}
