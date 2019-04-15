import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import {  Router } from '@angular/router';
@Component({
  selector: 'app-datevoyage',//<app-datevoyage></app-datevoyage>
  templateUrl: './datevoyage.component.html',
  styleUrls: ['./datevoyage.component.css']
})
export class DatevoyageComponent implements OnInit {


  url: string = "http://localhost:9090/horaires/" ;
  lesHoraires : any;
  minDate = new Date();
  maxDate = new Date(2020, 0, 1);
  constructor(private router: Router) { }

  ngOnInit() {

  }

  getDateClient(date) {
     let datePipe = new DatePipe('en')
      .transform(date.dateClient.toString(), "ddMMyyyy");

    let urlEnd = this.url + datePipe;
    this.router.navigateByUrl("/horaires/" + btoa(urlEnd))  ;
  }

}
